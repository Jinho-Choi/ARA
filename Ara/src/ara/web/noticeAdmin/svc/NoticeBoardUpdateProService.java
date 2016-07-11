package ara.web.noticeAdmin.svc;

import static ara.db.JdbcUtil.close;
import static ara.db.JdbcUtil.commit;
import static ara.db.JdbcUtil.getConnect;
import static ara.db.JdbcUtil.rollback;

import java.sql.Connection;

import ara.web.noticeAdmin.dao.BoardAdminDAO;
import ara.web.noticeAdmin.vo.NoticeBoardVO;

public class NoticeBoardUpdateProService {

	public boolean modifyNoticeArticle(NoticeBoardVO article) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardAdminDAO boardAdminDAO = BoardAdminDAO.getInstance();
		boardAdminDAO.setConnection(con); 
		
		boolean updateSuccess = false;

		int updateCount = boardAdminDAO.updateNoticeArticle(article);
		if(updateCount > 0) {
			commit(con);
			updateSuccess = true;
		} else {
			rollback(con);
		}
		close(con); 
		
		return updateSuccess;
	}

}
