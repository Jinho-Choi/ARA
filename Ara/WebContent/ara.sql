CREATE TABLE member (
	u_id VARCHAR2(12) NOT NULL,
	u_name VARCHAR2(12) NOT NULL,
	u_passwd VARCHAR2(12) NOT NULL,
	u_phone VARCHAR2(13) NOT NULL,
	u_u_guardian VARCHAR2(13) NOT NULL,
	u_zipcode1 NUMBER NOT NULL,
	u_zipcode2 NUMBER NOT NULL,
	u_address1 VARCHAR2(50) NOT NULL,
	u_address2 VARCHAR2(50) NOT NULL,
	u_birthday DATE NOT NULL,
	u_email VARCHAR2(30),
	u_gender VARCHAR2(10) NOT NULL,
	u_auth VARCHAR2(20) NOT NULL,
	PRIMARY KEY(u_id)
)

CREATE SEQUENCE member_seq;

drop table member purge;