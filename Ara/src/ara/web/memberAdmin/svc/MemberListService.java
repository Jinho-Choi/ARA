package ara.web.memberAdmin.svc;

import static ara.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import ara.web.memberAdmin.dao.MemberAdminDAO;
import ara.web.memberAdmin.vo.Member;

public class MemberListService {

	public ArrayList<Member> getMemberList() {
		// TODO Auto-generated method stub
		ArrayList<Member> memberList = null;
		Connection con = getConnect();
		MemberAdminDAO memberAdminDAO = MemberAdminDAO.getInstance();
		memberAdminDAO.setConnection(con); // Ŀ�ؼ� ����
		memberList = memberAdminDAO.selectMemberList();
		close(con);
		return memberList; // ��� �迭 �״�� ����
	}

}
