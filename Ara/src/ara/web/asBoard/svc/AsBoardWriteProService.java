package ara.web.asBoard.svc;

import java.sql.Connection;
import static ara.db.JdbcUtil.*;
import ara.web.asBoard.dao.BoardDAO;
import ara.web.asBoard.vo.AsBoardVO;

public class AsBoardWriteProService {
	
	public boolean writeArticle(AsBoardVO article) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean writeSuccess = false;
		int insertCount = boardDAO.insertAsArticle(article);
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
