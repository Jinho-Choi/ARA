package ara.web.asBoard.svc;

import java.sql.Connection;
import static ara.db.JdbcUtil.*;
import ara.web.asBoard.dao.BoardDAO;
import ara.web.asBoard.vo.AsBoardVO;

public class AsBoardContentService {

	public AsBoardVO getAsArticle(int num) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 
		
		AsBoardVO article = boardDAO.selectAsArticle(num);
		close(con);
		
		return article;
	}

}
