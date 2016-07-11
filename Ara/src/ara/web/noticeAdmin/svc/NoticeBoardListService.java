package ara.web.noticeAdmin.svc;

import static ara.db.JdbcUtil.close;
import static ara.db.JdbcUtil.getConnect;

import java.sql.Connection;
import java.util.List;

import ara.web.noticeAdmin.dao.BoardAdminDAO;
import ara.web.noticeAdmin.vo.NoticeBoardVO;


public class NoticeBoardListService {

	public int getNoticeArticleCount() {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardAdminDAO boardAdminDAO = BoardAdminDAO.getInstance();
		boardAdminDAO.setConnection(con);
		int articleCount = boardAdminDAO.selectNoticeArticleCount();
		
		close(con);
		
		return articleCount;
	}

	public List<NoticeBoardVO> getNoticeArticleList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardAdminDAO boardAdminDAO = BoardAdminDAO.getInstance();
		boardAdminDAO.setConnection(con); 
		
		List<NoticeBoardVO> articleList = boardAdminDAO.selectNoticeArticleList(startRow, pageSize);
		
		close(con);
		
		return articleList;
	}
	

}
