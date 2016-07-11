package ara.web.notice.svc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static ara.db.JdbcUtil.*;
import ara.web.notice.dao.BoardDAO;
import ara.web.notice.vo.NoticeBoardVO;

public class NoticeBoardListService {

	public int getNoticeArticleCount() {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 
		int articleCount = boardDAO.selectNoticeArticleCount();
		
		close(con);
		
		return articleCount;
	}

	public List<NoticeBoardVO> getNoticeArticleList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 
	
		List<NoticeBoardVO> articleList = boardDAO.selectNoticeArticleList(startRow, pageSize);
		
		close(con);
		
		return articleList;
	}

	public List<NoticeBoardVO> getNoticeArticleList(int startRow) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 
	
		List<NoticeBoardVO> articleList = boardDAO.selectNoticeArticleList(startRow);
		
		close(con);
		
		return articleList;
	}

	public List<NoticeBoardVO> getNoticeContentArticleList() {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		List<NoticeBoardVO> noticeContentArticleList = boardDAO.selectNoticeContentArticleList();
		close(con);
		
		return noticeContentArticleList;
	}
	

}
