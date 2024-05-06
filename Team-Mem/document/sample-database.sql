-- 샘플데이터
use manageDB;
-- minfo
INSERT INTO tbl_minfo(i_title, i_price, i_count, i_ccode)
VALUES
('플렉스 멤버십', 50000, 8, 'C0001'),
('프리미엄 멤버십', 80000, 12, 'C0001'),
('골드 멤버십', 120000, 16, 'C0001'),
('트레이너 멤버십', 150000, 20, 'C0001'),
('학생 할인 멤버십', 30000, 4, 'C0001'),
('트라이얼 멤버십', 0, 1, 'C0001'), -- 가격은 무료이며 수강 횟수는 NULL로 설정
('싱글 디이 멤버십', 70000, 10, 'C0001'),
('퍼스트타임 멤버십', 40000, 6, 'C0001'),
('파워 패스 멤버십', 200000, 24, 'C0001'),
('이브닝 패스 멤버십', 60000, 8, 'C0001');

-- user
INSERT INTO tbl_user (u_id, u_password, u_name, u_tel)
VALUES
('user1', 'password1', '홍길동', '010-1234-5678'),
('user2', 'password2', '김철수', '010-2345-6789'),
('user3', 'password3', '이영희', '010-3456-7890'),
('user4', 'password4', '박민수', '010-4567-8901'),
('user5', 'password5', '최미영', '010-5678-9012'),
('user6', 'password6', '정기남', '010-6789-0123'),
('user7', 'password7', '한영호', '010-7890-1234'),
('user8', 'password8', '송진아', '010-8901-2345'),
('user9', 'password9', '장현우', '010-9012-3456'),
('user10', 'password10', '윤하늘', '010-0123-4567');

-- role
INSERT INTO tbl_role (r_uid, r_role)
VALUES
('user1', 'ROLE_USER'),
('user2', 'ROLE_USER'),
('user3', 'ROLE_USER'),
('user4', 'ROLE_USER'),
('user5', 'ROLE_USER'),
('user6', 'ROLE_USER'),
('user7', 'ROLE_USER'),
('user8', 'ROLE_USER'),
('user9', 'ROLE_USER'),
('user10', 'ROLE_USER');
