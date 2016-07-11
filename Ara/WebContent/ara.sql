CREATE TABLE AsBoard(
	as_num NUMBER NOT NULL,
	as_writer VARCHAR2(12) NOT NULL,
	as_email VARCHAR2(30),
	as_subject VARCHAR2(50) NOT NULL,
	as_passwd VARCHAR2(12),
	as_reg_date TIMESTAMP NOT NULL,
	as_readcount NUMBER DEFAULT 0,
	as_content VARCHAR2(400),
	PRIMARY KEY(as_num)
)