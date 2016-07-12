package ara.web.member.dao;

import static ara.db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ara.web.member.vo.Member;
import ara.web.member.vo.Zipcode;

public class MemberDAO {
	private static MemberDAO instance;
	private Connection con;

	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	/*u_id VARCHAR2(12) NOT NULL,
	u_name VARCHAR2(12) NOT NULL,
	u_passwd VARCHAR2(12) NOT NULL,
	u_address VARCHAR2(50) NOT NULL,
	u_email VARCHAR2(30),
	u_phone VARCHAR2(13) NOT NULL,
	u_gender VARCHAR2(10) NOT NULL,
	u_guardian VARCHAR2(20) NOT NULL,
	u_auth VARCHAR2(20) NOT NULL,*/
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO member(u_id, u_name, u_passwd, u_email, u_phone,"
				+ " u_gender, u_guardian, u_zipcode1, u_zipcode2, "
				+ "u_address1, u_address2, u_auth)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null; // statement 선언
		int insertCount = 0;
		try {
			// DB연결
			pstmt = con.prepareStatement(sql); // statement를 만들어준다.
			pstmt.setString(1, member.getU_id());
			pstmt.setString(2, member.getU_name());
			pstmt.setString(3, member.getU_passwd());
			pstmt.setString(4, member.getU_email());
			pstmt.setString(5, member.getU_phone());
			pstmt.setString(6, member.getU_gender());
			pstmt.setString(7, member.getU_guardian());
			pstmt.setInt(8, member.getU_zipcode1());
			pstmt.setInt(9, member.getU_zipcode2());
			pstmt.setString(10, member.getU_address1());
			pstmt.setString(11, member.getU_address2());
			pstmt.setString(12, member.getU_auth());
			insertCount = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt); // close 메소드 사용
		}
		return insertCount;
	}

	public int selectIdCount(String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM member WHERE u_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 로그인 성공
				idCount = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return idCount;
	}
	public ArrayList<Zipcode> selectZipcodeList(String dong) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM zipcode WHERE dong LIKE ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Zipcode> zipSearchList = null;
		Zipcode zipcode = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + dong + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				zipSearchList = new ArrayList<Zipcode>();
				do {
					zipcode = new Zipcode();
					zipcode.setSido(rs.getString("sido"));
					zipcode.setDong(rs.getString("dong"));
					zipcode.setGugun(rs.getString("gugun"));
					zipcode.setBungi(rs.getString("bungi"));
					zipcode.setSeq(rs.getInt("seq"));
					zipcode.setZipcode(rs.getString("zipcode"));
					zipSearchList.add(zipcode);
				} while (rs.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return zipSearchList;
	}

	public Member selectLoginMember(String id, String passwd) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM member WHERE u_id = ? AND u_passwd = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member loginMember = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 로그인 성공	
				loginMember = new Member();
				loginMember.setU_id(rs.getString("u_id"));
				loginMember.setU_name(rs.getString("u_name"));
				loginMember.setU_passwd(rs.getString("u_passwd"));
				loginMember.setU_email(rs.getString("u_email"));
				loginMember.setU_phone(rs.getString("u_phone"));
				loginMember.setU_gender(rs.getString("u_gender"));
				loginMember.setU_guardian(rs.getString("u_guardian"));
				loginMember.setU_zipcode1(rs.getInt("u_zipcode1"));
				loginMember.setU_zipcode2(rs.getInt("u_zipcode2"));
				loginMember.setU_address1(rs.getString("u_address1"));
				loginMember.setU_address2(rs.getString("u_address2"));
				loginMember.setU_auth(rs.getString("u_auth"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginMember;
	}

	public Member selectMember(String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM member WHERE u_id = ?";
		PreparedStatement pstmt = null; // statement 선언
		ResultSet rs = null;
		Member member = null;
		try {
			// DB연결
			pstmt = con.prepareStatement(sql); // statement를 만들어준다.
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // resultSet 생성 후 select 구문 실행
			if (rs.next()) {
				member = new Member(rs.getString("u_id"), rs.getString("u_name"),
						rs.getString("u_passwd"), rs.getString("u_email"),
						rs.getString("u_phone"), rs.getString("u_gender"), rs.getString("u_guardian"), rs.getInt("u_zipcode1"), rs.getInt("u_zipcode2"),
						rs.getString("u_address1"), rs.getString("u_address2"),rs.getString("u_auth"));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;

	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		String sql = "UPDATE member SET u_name = ?, u_passwd = ?, u_address = ?, u_email = ?, u_phone = ?, u_gender = ?,u_guardian = ?, u_zipcode1 = ?,u_zipcode2 = ?, u_address1 = ?, u_address2 = ?, u_auth = ? WHERE u_id = ?";
		PreparedStatement pstmt = null; // statement 선언
		int updateCount = 0;
		try {
			// DB연결
			pstmt = con.prepareStatement(sql); // statement를 만들어준다.
			pstmt.setString(1, member.getU_name());
			pstmt.setString(2, member.getU_passwd());
			pstmt.setString(3, member.getU_email());
			pstmt.setString(4, member.getU_phone());
			pstmt.setString(5, member.getU_gender());
			pstmt.setString(6, member.getU_guardian());
			pstmt.setInt(7, member.getU_zipcode1());
			pstmt.setInt(8, member.getU_zipcode2());
			pstmt.setString(9, member.getU_address1());
			pstmt.setString(10, member.getU_address2());
			pstmt.setString(11, member.getU_auth());
			pstmt.setString(12, member.getU_id());

			updateCount = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt); // close 메소드 사용
		}
		return updateCount;


	}
}

