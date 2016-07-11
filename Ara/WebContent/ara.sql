CREATE TABLE member (
	u_id VARCHAR2(12) NOT NULL,
	u_name VARCHAR2(12) NOT NULL,
	u_passwd VARCHAR2(12) NOT NULL,
	u_email VARCHAR2(30),
	u_phone VARCHAR2(13) NOT NULL,
	u_gender VARCHAR2(10) NOT NULL,
	u_guardian VARCHAR2(20) NOT NULL,
	u_zipcode1 NUMBER NOT NULL,
	u_zipcode2 NUMBER NOT NULL,
	u_address1 VARCHAR2(50) NOT NULL,
	u_address2 VARCHAR2(50) NOT NULL,
	u_auth VARCHAR2(20) NOT NULL,
	PRIMARY KEY(u_id)
)
CREATE TABLE zipcode(
	seq NUMBER NOT NULL,
	zipcode VARCHAR2(7) NOT NULL,
	sido VARCHAR2(10),
	gugun VARCHAR2(30),
	dong VARCHAR2(43),
	bungi VARCHAR2(25),
	PRIMARY KEY(seq)
)
DROP TABLE zipcode;
DROP TABLE member;