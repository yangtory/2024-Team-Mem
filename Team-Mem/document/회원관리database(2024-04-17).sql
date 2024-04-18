CREATE DATABASE manageDB;
USE manageDB;
DROP DATABASE manageDB;
SELECT * FROM tbl_user WHERE u_comp = "";
SELECT * FROM tbl_company;
SELECT * FROM tbl_user;
SELECT * FROM tbl_role;
SELECT * FROM tbl_class;
SELECT * FROM tbl_minfo;
SELECT * FROM tbl_notice;
SELECT * FROM tbl_teacher;
SELECT * FROM tbl_user_minfo;
SELECT * FROM tbl_user_comp;





CREATE TABLE tbl_user(
u_id	VARCHAR(20)		PRIMARY KEY,
u_password	VARCHAR(20)	NOT NULL	,
u_name	VARCHAR(10)	NOT NULL	,
u_tel	VARCHAR(15)	NOT NULL,
u_comp VARCHAR(10)
);

-- 테이블 변경
ALTER TABLE tbl_user
MODIFY COLUMN u_password VARCHAR(125);

ALTER TABLE tbl_user
DROP COLUMN u_role;

ALTER TABLE tbl_user
ADD COLUMN u_comp VARCHAR(10);


SELECT u.*, uc.us_cname , uc.us_ccode
		FROM tbl_user u
		LEFT JOIN tbl_user_comp uc ON u.u_id = uc.us_uid
        WHERE uc.us_ccode = "C001";
        


-- 아직 추가안햇음
CREATE TABLE tbl_user_comp(
	uc_uid VARCHAR(20) NOT NULL,
    uc_ccode VARCHAR(10) NOT NULL,
    uc_uname VARCHAR(10),
    uc_utel VARCHAR(15),
    uc_cname VARCHAR(10),
    CONSTRAINT uc_pk PRIMARY KEY(uc_uid,uc_ccode)

);

CREATE TABLE tbl_role(
	r_uid VARCHAR(20) NOT NULL,
    r_role VARCHAR(20) NOT NULL,
    FOREIGN KEY (r_uid)
    REFERENCES tbl_user(u_id)
    ON DELETE CASCADE
);

CREATE TABLE tbl_company(
c_code	VARCHAR(10)		PRIMARY KEY,
c_name	VARCHAR(10)	NOT NULL	,
c_addr	VARCHAR(10)		,
c_tel	VARCHAR(15)		,
c_uid VARCHAR(20)
);

CREATE TABLE tbl_teacher(
t_code	VARCHAR(10)		PRIMARY KEY,
t_name	VARCHAR(10)	NOT NULL	,
t_tel	VARCHAR(15)	NOT NULL	,
t_ccode VARCHAR(10) NOT NULL
);
CREATE TABLE tbl_class(
c_seq	INT		PRIMARY KEY AUTO_INCREMENT,
c_name	VARCHAR(50)	NOT NULL	,
c_date	VARCHAR(15)	NOT NULL	,
c_stime	VARCHAR(15)	NOT NULL,
c_etime VARCHAR(15) NOT NULL,
c_tcode VARCHAR(10) NOT NULL,
c_ccode VARCHAR(10) NOT NULL
);



CREATE TABLE tbl_notice(
n_seq	INT		AUTO_INCREMENT PRIMARY KEY,
n_title	VARCHAR(125)	NOT NULL	,
n_content	VARCHAR(255)	NOT NULL,
n_ccode VARCHAR(10) NOT NULL,
n_uid VARCHAR(20) NOT NULL
);


CREATE TABLE tbl_minfo(
i_seq	INT		PRIMARY KEY AUTO_INCREMENT,
i_title	VARCHAR(50)	NOT NULL	,
i_price	INT	NOT NULL	,
i_count	INT	NOT NULL	,
i_sdate VARCHAR(15) 	,
i_edate VARCHAR(15)		
);


-- user, minfo 릴레이션 테이블
CREATE TABLE tbl_user_minfo(
r_iseq	INT	NOT NULL,
r_uid	VARCHAR(20)	NOT NULL,
r_sdate	VARCHAR(15)	NOT NULL,
r_edate	VARCHAR(15)	NOT NULL,
CONSTRAINT mi_pk PRIMARY KEY(r_iseq,r_uid)
);

-- user, comp 릴레이션 테이블
CREATE TABLE tbl_user_comp(
	us_uid	VARCHAR(20)	NOT NULL,
	us_ccode	VARCHAR(10)	NOT NULL,
	us_uname	VARCHAR(10)	,
	us_utel	VARCHAR(15)	,
	us_cname	VARCHAR(10)	,
	CONSTRAINT uc_pk PRIMARY KEY(us_uid,us_ccode)	

);


-- 데이터 추가 후 실행하기

ALTER TABLE tbl_teacher
ADD CONSTRAINT FK_CCODE
FOREIGN KEY (t_ccode)
REFERENCES tbl_company(c_code);


ALTER TABLE tbl_company
ADD CONSTRAINT FK_UID
FOREIGN KEY (c_uid)
REFERENCES tbl_user(u_id);

ALTER TABLE tbl_class
ADD CONSTRAINT FK_TCODE
FOREIGN KEY (c_tcode)
REFERENCES tbl_teacher(t_code);

ALTER TABLE tbl_class
ADD CONSTRAINT FK_CCCODE
FOREIGN KEY (c_ccode)
REFERENCES tbl_company(c_code);

ALTER TABLE tbl_notice
ADD CONSTRAINT FK_NCCODE
FOREIGN KEY (n_ccode)
REFERENCES tbl_company(c_code);

ALTER TABLE tbl_notice
ADD CONSTRAINT FK_NUID
FOREIGN KEY (n_uid)
REFERENCES tbl_user(u_id);


ALTER TABLE tbl_user_minfo
ADD CONSTRAINT FK_MINFO 
FOREIGN KEY(r_iseq)
REFERENCES tbl_minfo(i_seq);

ALTER TABLE tbl_user_minfo
ADD CONSTRAINT FK_USER
FOREIGN KEY(r_uid)
REFERENCES tbl_user(u_id);

SELECT * FROM tbl_class
LEFT JOIN tbl_teacher
ON c_tcode = t_code
LEFT JOIN tbl_company
ON c_ccode = c_code;



SELECT * FROM tbl_user_minfo
LEFT JOIN tbl_user
	ON r_uid = u_id
LEFT JOIN tbl_minfo
	ON r_iseq = i_seq;
    
    

SELECT * FROM tbl_user
WHERE u_role = "일반사용자";

SELECT u.u_id, u.u_name, u.u_tel, u.u_role,
       c.c_code, c.c_name, c.c_addr
	FROM tbl_user u
		LEFT JOIN tbl_company c
			ON u.u_id = c.c_uid;
