package ara.web.asBoard.svc;

import java.sql.Connection;
import static ara.db.JdbcUtil.*;
import ara.web.asBoard.dao.BoardDAO;
import ara.web.asBoard.vo.AsBoardVO;

public class AsBoardUpdateFormService {

	public AsBoardVO getUpdateAsArticle(int num) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 
		
		AsBoardVO article = boardDAO.selectUpdateAsArticle(num);
		close(con); 
		
		return article;
	}
}
