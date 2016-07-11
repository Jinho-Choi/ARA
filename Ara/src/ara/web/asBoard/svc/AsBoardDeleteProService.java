package ara.web.asBoard.svc;

import java.sql.Connection;

import ara.web.asBoard.dao.BoardDAO;
import static ara.db.JdbcUtil.*;
public class AsBoardDeleteProService {

	public boolean removeAsArticle(int num, String passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 
		
		boolean removeSuccess = false;
		int deleteCount = boardDAO.deleteAsArticle(num, passwd);
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


