package ara.web.member.vo;
/*u_id VARCHAR2(12) NOT NULL,
u_name VARCHAR2(12) NOT NULL,
u_passwd VARCHAR2(12) NOT NULL,
u_address VARCHAR2(50) NOT NULL,
u_email VARCHAR2(30),
u_phone VARCHAR2(13) NOT NULL,
u_gender VARCHAR2(10) NOT NULL,
u_guardian VARCHAR2(20) NOT NULL,
u_auth VARCHAR2(20) NOT NULL,*/
public class Member {
	private String u_id;
	private String u_name;
	private String u_passwd;
	private String u_email;
	private String u_phone;
	private String u_gender;
	private String u_guardian;
	private int u_zipcode1;
	private int u_zipcode2;
	private String u_address1;
	private String u_address2;
	private String u_auth;
	public Member(String u_id, String u_name, String u_passwd, String u_email, String u_phone,
			String u_gender, String u_guardian, int u_zipcode1, int u_zipcode2, String u_address1, String u_address2,
			String u_auth) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_passwd = u_passwd;
		this.u_email = u_email;
		this.u_phone = u_phone;
		this.u_gender = u_gender;
		this.u_guardian = u_guardian;
		this.u_zipcode1 = u_zipcode1;
		this.u_zipcode2 = u_zipcode2;
		this.u_address1 = u_address1;
		this.u_address2 = u_address2;
		this.u_auth = u_auth;
	}
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_passwd() {
		return u_passwd;
	}
	public void setU_passwd(String u_passwd) {
		this.u_passwd = u_passwd;
	}
		public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_guardian() {
		return u_guardian;
	}
	public void setU_guardian(String u_guardian) {
		this.u_guardian = u_guardian;
	}
	public int getU_zipcode1() {
		return u_zipcode1;
	}
	public void setU_zipcode1(int u_zipcode1) {
		this.u_zipcode1 = u_zipcode1;
	}
	public int getU_zipcode2() {
		return u_zipcode2;
	}
	public void setU_zipcode2(int u_zipcode2) {
		this.u_zipcode2 = u_zipcode2;
	}
	public String getU_address1() {
		return u_address1;
	}
	public void setU_address1(String u_address1) {
		this.u_address1 = u_address1;
	}
	public String getU_address2() {
		return u_address2;
	}
	public void setU_address2(String u_address2) {
		this.u_address2 = u_address2;
	}
	public String getU_auth() {
		return u_auth;
	}
	public void setU_auth(String u_auth) {
		this.u_auth = u_auth;
	}
	
	
}
