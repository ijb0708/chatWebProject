-- 1. 유저 테이블
CREATE TABLE IF NOT EXISTS users (
    user_seq SERIAL PRIMARY KEY,
    user_id VARCHAR(50) UNIQUE NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_password TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. 채팅방 테이블
CREATE TABLE IF NOT EXISTS rooms (
    room_seq SERIAL PRIMARY KEY,
    room_name VARCHAR(255) NOT NULL,
    admin_user_seq INTEGER NOT NULL REFERENCES users(user_seq) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. 게시글 테이블
CREATE TABLE IF NOT EXISTS posts (
    post_seq SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    create_user_seq INTEGER NOT NULL REFERENCES users(user_seq) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 인덱스 추가 (조회 성능 최적화)
CREATE INDEX idx_rooms_created_at ON rooms (created_at DESC);
CREATE INDEX idx_posts_created_at ON posts (created_at DESC);