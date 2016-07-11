package ara.web.member.svc;

import static ara.db.JdbcUtil.*;

import java.sql.Connection;

import ara.web.member.dao.MemberDAO;
import ara.web.member.vo.Member;

public class LoginService {

	public Member getLoginUser(String id, String passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		Member loginMember = memberDAO.selectLoginMember(id, passwd);
		close(con);
		return loginMember;
	}

}
