package ara.web.memberAdmin.svc;

import static ara.db.JdbcUtil.close;
import static ara.db.JdbcUtil.getConnect;

import java.sql.Connection;
import java.util.ArrayList;

import ara.web.memberAdmin.dao.MemberAdminDAO;
import ara.web.memberAdmin.vo.Member;

public class SearchListService {

	public ArrayList<Member> getSearchId(String search) {
		// TODO Auto-generated method stub
		ArrayList<Member> memberList = null;
		Connection con = getConnect();
		MemberAdminDAO memberAdminDAO = MemberAdminDAO.getInstance();
		memberAdminDAO.setConnection(con); // Ŀ�ؼ� ����
		memberList = memberAdminDAO.selectSearchId(search);
		close(con);
		return memberList; // ��� �迭 �״�� ����
	}

	

	public ArrayList<Member> getSearchName(String search) {
		// TODO Auto-generated method stub
		ArrayList<Member> memberList = null;
		Connection con = getConnect();
		MemberAdminDAO memberAdminDAO = MemberAdminDAO.getInstance();
		memberAdminDAO.setConnection(con); // Ŀ�ؼ� ����
		memberList = memberAdminDAO.selectSearchName(search);
		close(con);
		return memberList; // ��� �迭 �״�� ����
	}


}
