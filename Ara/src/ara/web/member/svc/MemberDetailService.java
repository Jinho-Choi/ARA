package ara.web.member.svc;

import static ara.db.JdbcUtil.*;

import java.sql.Connection;

import ara.web.member.dao.MemberDAO;
import ara.web.member.vo.Member;

public class MemberDetailService {

	public Member getMember(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con); // Ŀ�ؼ� ����
		Member member = memberDAO.selectMember(id);
		close(con);
		return member;
	}

}
