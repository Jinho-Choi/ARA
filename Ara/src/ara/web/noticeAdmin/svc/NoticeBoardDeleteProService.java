package ara.web.noticeAdmin.svc;

import static ara.db.JdbcUtil.close;
import static ara.db.JdbcUtil.commit;
import static ara.db.JdbcUtil.getConnect;
import static ara.db.JdbcUtil.rollback;

import java.sql.Connection;

import ara.web.noticeAdmin.dao.BoardAdminDAO;

public class NoticeBoardDeleteProService {

	public boolean removeNoticeArticle(int num, String passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardAdminDAO boardAdminDAO = BoardAdminDAO.getInstance();
		boardAdminDAO.setConnection(con); 
		
		boolean removeSuccess = false;

		int deleteCount = boardAdminDAO.deleteNoticeArticle(num, passwd);
		if(deleteCount > 0) {
			commit(con);
			removeSuccess = true;
		} else {
			rollback(con);
		}
		close(con); 
		
		return removeSuccess;
	}
}


