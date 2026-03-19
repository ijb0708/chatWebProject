#!/bin/sh

echo "=========================================="
echo "Stopping and Cleaning Chat Web System..."
echo "=========================================="

# 1. 실행 중인 컨테이너 정지 및 삭제
echo "1. Stopping containers: chatwebserver, chatwebdb..."
docker rm -f chatwebserver chatwebdb 2>/dev/null || true

# 2. (선택) 빌드 과정에서 생긴 '이름 없는' 이미지들 삭제
# --no-cache 빌드 등을 반복하면 <none>:<none> 이미지가 쌓여 용량을 차지합니다.
echo "2. Cleaning up dangling images..."
docker image prune -f

# 3. (선택) DB 데이터까지 완전히 초기화하고 싶다면 아래 주석을 해제하세요.
# echo "3. Removing DB volume (All data will be lost!)"
# docker volume rm pg_data 2>/dev/null || true

echo "=========================================="
echo "Cleanup complete!"
echo "=========================================="

# 윈도우 사용자라면 창이 바로 닫히지 않게 대기
read -p "Press Enter to exit..." temp