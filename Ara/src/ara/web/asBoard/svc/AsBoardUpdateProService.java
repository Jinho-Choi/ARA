package ara.web.asBoard.svc;

import java.sql.Connection;
import static ara.db.JdbcUtil.*;
import ara.web.asBoard.dao.BoardDAO;
import ara.web.asBoard.vo.AsBoardVO;

public class AsBoardUpdateProService {

	public boolean modifyAsArticle(AsBoardVO article) {
		// TODO Auto-generated method stub
			Connection con = getConnect(); 
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con); 
			
			boolean updateSuccess = false;

			int updateCount = boardDAO.updateAsArticle(article);
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


