package ara.web.asBoard.svc;

import static ara.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.List;

import ara.web.asBoard.dao.BoardDAO;
import ara.web.asBoard.vo.AsBoardVO;

public class AsBoardListService {

	public int getQnAArticleCount() {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 
		int articleCount = boardDAO.selectAsArticleCount();
		
		close(con);
		
		return articleCount;
	}

	public List<AsBoardVO> getArticleList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 

		List<AsBoardVO> articleList = boardDAO.selectAsArticleList(startRow, pageSize);
		
		close(con);
		
		return articleList;
	}

	public List<AsBoardVO> getQnAContentArticleList() {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		List<AsBoardVO> qnaContentArticleList = boardDAO.selectAsContentArticleList();
		
		close(con);
		
		return qnaContentArticleList;
		
	}
}
