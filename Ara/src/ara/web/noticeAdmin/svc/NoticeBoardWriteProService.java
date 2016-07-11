package ara.web.noticeAdmin.svc;

import static ara.db.JdbcUtil.close;
import static ara.db.JdbcUtil.commit;
import static ara.db.JdbcUtil.getConnect;
import static ara.db.JdbcUtil.rollback;

import java.sql.Connection;

import ara.web.noticeAdmin.dao.BoardAdminDAO;
import ara.web.noticeAdmin.vo.NoticeBoardVO;

public class NoticeBoardWriteProService {

	public boolean writeNoticeArticle(NoticeBoardVO article) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		BoardAdminDAO boardAdminDAO = BoardAdminDAO.getInstance();
		boardAdminDAO.setConnection(con); 
		
		boolean writeSuccess = false;
		int insertCount = boardAdminDAO.insertNoticeArticle(article);
		if(insertCount > 0) {
			commit(con);
			writeSuccess = true;
		} else {
			rollback(con);
		}
		close(con); 
		
		return writeSuccess;
	}

}
