package ara.web.memberAdmin.vo;

public class Member {

	private String u_id;
	private String u_name;
	private String u_passwd;
	private String u_guardian;
	private String u_email;
	private int u_zipcode1;
	private int u_zipcode2;
	private String u_address1;
	private String u_address2;
	private String u_birthDay;
	private String u_phone;
	private String u_gender;
	private String u_auth;
	public Member(String u_id, String u_name, String u_passwd, String u_guardian, String u_email,
			int u_zipcode1, int u_zipcode2, String u_address1, String u_address2, String u_birthDay, String u_phone,
			String u_gender, String u_auth) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_passwd = u_passwd;
		this.u_guardian = u_guardian;
		this.u_email = u_email;
		this.u_zipcode1 = u_zipcode1;
		this.u_zipcode2 = u_zipcode2;
		this.u_address1 = u_address1;
		this.u_address2 = u_address2;
		this.u_birthDay = u_birthDay;
		this.u_phone = u_phone;
		this.u_gender = u_gender;
		this.u_auth = u_auth;
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

	public String getU_guardian() {
		return u_guardian;
	}
	public void setU_guardian(String u_guardian) {
		this.u_guardian = u_guardian;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
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
	public String getU_birthDay() {
		return u_birthDay;
	}
	public void setU_birthDay(String u_birthDay) {
		this.u_birthDay = u_birthDay;
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
	public String getU_auth() {
		return u_auth;
	}
	public void setU_auth(String u_auth) {
		this.u_auth = u_auth;
	}
	
	
}