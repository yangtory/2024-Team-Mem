CREATE DATABASE manageDB;
USE manageDB;
DROP DATABASE manageDB;
SELECT * FROM tbl_company;
SELECT * FROM tbl_user;
SELECT * FROM tbl_role;
SELECT * FROM tbl_class;
SELECT * FROM tbl_minfo;
SELECT * FROM tbl_notice;
SELECT * FROM tbl_teacher;
SELECT * FROM tbl_schedule;
SELECT * FROM tbl_user_minfo; 
SELECT * FROM tbl_user_comp;

select r_uid,r_iseq,i_price
       from tbl_user_minfo        
join tbl_minfo on i_seq = r_iseq;

-- 총매출
select sum(i_price) as total_price
from tbl_user_minfo
join tbl_minfo on r_iseq = i_seq;

-- 월매출
SELECT SUM(i_price) AS total_price
FROM tbl_user_minfo
JOIN tbl_minfo ON r_iseq = i_seq
where  r_sdate between '2024-05-01' and '2024-05-31';

SELECT n_seq, n_title, n_uid, n_date
FROM tbl_notice
ORDER BY n_date DESC
LIMIT 10 OFFSET 10;

-- truncate
SET FOREIGN_KEY_CHECKS = 0;
SET FOREIGN_KEY_CHECKS = 1;
TRUNCATE tbl_user;
TRUNCATE tbl_company;
TRUNCATE tbl_notice;
TRUNCATE tbl_role;
TRUNCATE tbl_class;
TRUNCATE tbl_minfo;
TRUNCATE tbl_notice;
TRUNCATE tbl_teacher;
TRUNCATE tbl_schedule;
TRUNCATE tbl_user_minfo;
TRUNCATE tbl_user_comp;

SELECT * FROM tbl_schedule
ORDER BY s_sdate DESC, s_edate DESC;
TRUNCATE tbl_schedule;

SELECT * 
		FROM tbl_user_comp uc
		LEFT JOIN tbl_user u ON u.u_id = uc.us_uid
		where uc.us_ccode = 'C0001';

CREATE TABLE tbl_user(
u_id	VARCHAR(20)		PRIMARY KEY,
u_password	VARCHAR(125)	NOT NULL	,
u_name	VARCHAR(10)	NOT NULL	,
u_tel	VARCHAR(15)	NOT NULL,
u_comp VARCHAR(10)
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
c_addr	VARCHAR(125)		,
c_tel	VARCHAR(15)		,
c_uid VARCHAR(20),
    FOREIGN KEY (c_uid)
    REFERENCES tbl_user(u_id)
    ON DELETE CASCADE
);

CREATE TABLE tbl_teacher(
t_code	VARCHAR(10)		PRIMARY KEY,
t_name	VARCHAR(10)	NOT NULL	,
t_tel	VARCHAR(15)	NOT NULL	,
t_ccode VARCHAR(10) NOT NULL,
    FOREIGN KEY (t_ccode)
    REFERENCES tbl_company(c_code)
    ON DELETE CASCADE
);

CREATE TABLE tbl_class(
c_seq	INT		PRIMARY KEY AUTO_INCREMENT,
c_name	VARCHAR(50)	NOT NULL	,
c_sdate	VARCHAR(15)	NOT NULL	,
c_edate	VARCHAR(15)	NOT NULL	,
c_stime	VARCHAR(15)	NOT NULL,
c_etime VARCHAR(15) NOT NULL,
c_tcode VARCHAR(10) NOT NULL,
c_ccode VARCHAR(10) NOT NULL,
c_color VARCHAR(20),
    FOREIGN KEY (c_tcode)
    REFERENCES tbl_teacher(t_code)
    ON DELETE CASCADE,
	FOREIGN KEY (c_ccode)
    REFERENCES tbl_company(c_code)
    ON DELETE CASCADE
);


CREATE TABLE tbl_notice(
n_seq	VARCHAR(255),
n_title	VARCHAR(125)	NOT NULL	,
n_content	VARCHAR(255)	NOT NULL,
n_ccode VARCHAR(10) NOT NULL,
n_uid VARCHAR(20) NOT NULL,
n_date VARCHAR(10) NOT NULL,
n_time  VARCHAR(10) not null,
    FOREIGN KEY (n_ccode)
    REFERENCES tbl_company(c_code)
    ON DELETE CASCADE,
	FOREIGN KEY (n_uid)
    REFERENCES tbl_user(u_id)
    ON DELETE CASCADE
);


CREATE TABLE tbl_minfo(
i_seq	INT		PRIMARY KEY AUTO_INCREMENT,
i_title	VARCHAR(50)	NOT NULL	,
i_price	INT	NOT NULL	,
i_count	INT	NOT NULL	,
i_ccode VARCHAR(10) NOT NULL,
    FOREIGN KEY (i_ccode)
    REFERENCES tbl_company(c_code)
    ON DELETE CASCADE
);

CREATE TABLE tbl_schedule (
	s_seq	INT		PRIMARY KEY AUTO_INCREMENT,
	s_title	VARCHAR(50)	NOT NULL	,
	s_content VARCHAR(125),
	s_sdate VARCHAR(15) 	,
	s_edate VARCHAR(15)	,
    s_ccode VARCHAR(15)	,
    s_color VARCHAR(20)

);

-- user, minfo 릴레이션 테이블
CREATE TABLE tbl_user_minfo(
r_uid	VARCHAR(20)	NOT NULL,
r_iseq	INT	NOT NULL,
r_icount int not null,
r_sdate varchar(10) not null,
r_edate varchar(10) not null,

CONSTRAINT mi_pk PRIMARY KEY(r_iseq,r_uid,r_sdate),
    FOREIGN KEY (r_iseq)
    REFERENCES tbl_minfo(i_seq)
    ON DELETE CASCADE
);



-- user, comp 릴레이션 테이블
CREATE TABLE tbl_user_comp(
	us_uid	VARCHAR(20)	NOT NULL,
	us_ccode	VARCHAR(10)	NOT NULL,
	us_uname	VARCHAR(10)	,
	us_utel	VARCHAR(15)	,
	us_cname	VARCHAR(10)	,
    us_date varchar(15),
	CONSTRAINT uc_pk PRIMARY KEY(us_uid,us_ccode)	

);

SELECT u.u_id, u.u_name, u.u_tel, u.u_role,
       c.c_code, c.c_name, c.c_addr
	FROM tbl_user u
		LEFT JOIN tbl_company c
			ON u.u_id = c.c_uid;
            
SELECT u.*, uc.us_cname , uc.us_ccode
		FROM tbl_user u
		LEFT JOIN tbl_user_comp uc ON u.u_id = uc.us_uid
        WHERE uc.us_ccode = "C001";

INSERT INTO tbl_schedule(s_title,s_content,s_sdate, s_edate)
values('ㅎㅇ', 'ㅎㅇ','2024-04-20','2024-04-25');
INSERT INTO tbl_schedule(s_title,s_content,s_sdate, s_edate)
values('ㄱㄱ', 'ㄱㄱ','2024-04-25','2024-04-30');


