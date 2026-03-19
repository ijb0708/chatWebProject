#!/bin/sh

# 1. 포트 및 DB 정보 입력
echo "Choose expose port number (default: 8080):"
read EXPOSE_PORT
EXPOSE_PORT=${EXPOSE_PORT:-8080}

echo "Enter DB User (default: myuser):"
read DB_USER
DB_USER=${DB_USER:-"myuser"}

echo "Enter DB Password:"
read -s DB_PASS  # 비밀번호는 -s 옵션으로 안 보이게 받는 게 매너!
echo ""

# 고정 변수 설정
DB_NAME="chat"
DB_HOST="172.17.0.1" 
DB_PORT="5432"

SCRIPT_DIR=$(cd "$(dirname "$0")" && pwd)
cd "$SCRIPT_DIR"

# 기존 public 폴더의 내용물을 싹 비웁니다. (폴더 자체는 유지)
rm -rf ./server/public/*

# 2. 이미지 빌드
# 프론트엔드 빌드 (결과물을 추출)
docker build --target export-stage --output type=local,dest=./server/public \
  --build-arg VITE_BASE_URL="/" \
  --build-arg VITE_API_URL="http://localhost/api" \
  --build-arg VITE_SOCKET_URL="ws://localhost/" \
  -t chatwebfront ./front

# 백엔드 서버 빌드
docker build --no-cache -t chatwebserver ./server

# 3. 기존 컨테이너 정리
echo "Cleaning up old containers..."
docker rm -f chatwebserver chatwebdb 2>/dev/null || true\

# 4. DB 컨테이너 실행 (Postgres)
# -p 포트 설정 시 변수명 확인: $DB_PORT 사용
docker run -d \
  --name chatwebdb \
  -e POSTGRES_USER="$DB_USER" \
  -e POSTGRES_PASSWORD="$DB_PASS" \
  -e POSTGRES_DB="$DB_NAME" \
  -p $DB_PORT:5432 \
  --mount type=bind,source="$PWD/database/initDB.sql",target=/docker-entrypoint-initdb.d/init.sql,readonly \
  postgres:15-alpine

# 5. 백엔드 서버 컨테이너 실행
# 코드 내 환경변수명(POSTGRE_...)에 맞춰 주입
docker run -d \
  --name chatwebserver \
  -p "$EXPOSE_PORT":80 \
  -e TOKEN_SECRET="secret" \
  -e POSTGRE_USER="$DB_USER" \
  -e POSTGRE_PASSWORD="$DB_PASS" \
  -e POSTGRE_DATABASE="$DB_NAME" \
  -e POSTGRE_HOST="$DB_HOST" \
  -e POSTGRE_PORT="$DB_PORT" \
  chatwebserver

echo "=========================================="
echo "Local Access: http://localhost:$EXPOSE_PORT"
echo "=========================================="

read exit_press