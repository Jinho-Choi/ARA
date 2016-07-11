package ara.web.noticeAdmin.svc;

import static ara.db.JdbcUtil.close;
import static ara.db.JdbcUtil.getConnect;

import java.sql.Connection;

import ara.web.notice.dao.BoardDAO;
import ara.web.noticeAdmin.dao.BoardAdminDAO;
import ara.web.noticeAdmin.vo.NoticeBoardVO;

public class NoticeBoardContentService {

	public NoticeBoardVO getNoticeArticle(int num) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardAdminDAO boardAdminDAO = BoardAdminDAO.getInstance();
		boardAdminDAO.setConnection(con); 
		
		NoticeBoardVO article = boardAdminDAO.selectNoticeArticle(num);
		close(con);
		
		return article;
	}


}
