package ara.web.member.svc;

import static ara.db.JdbcUtil.*;
import java.sql.Connection;

import ara.web.member.dao.MemberDAO;
import ara.web.member.vo.Member;

public class MemberModifyProService {

	public boolean modifyMember(Member member) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con); // Ä¿³Ø¼Ç ÁÖÀÔ
		boolean modifySuccess = false;
		int updateCount = memberDAO.updateMember(member);
		if(updateCount > 0){
			modifySuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		close(con);
	
		return modifySuccess;
	}

	

	}


