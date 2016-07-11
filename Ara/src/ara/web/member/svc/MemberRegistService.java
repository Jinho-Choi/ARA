package ara.web.member.svc;

import static ara.db.JdbcUtil.*;

import java.sql.Connection;

import ara.web.member.dao.MemberDAO;
import ara.web.member.vo.Member;

public class MemberRegistService {

	public boolean registMember(Member member) {
		// TODO Auto-generated method stub
		boolean registSuccess = false;

		Connection con = getConnect();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int insertCount = memberDAO.insertMember(member);
		if(insertCount > 0) {
			registSuccess = true;
			commit(con); // �����ϸ� Ŀ��
		} else {
			rollback(con); // �����ϸ� �ѹ�
		}
		close(con); // Ŭ����(close)�� DAO�� �ƴ϶� ���񽺿��� ó�����־�� �Ѵ�. 
		
		return registSuccess;
	
	}

}
