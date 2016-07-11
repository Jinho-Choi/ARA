package ara.web.asBoard.svc;

import static ara.db.JdbcUtil.close;
import static ara.db.JdbcUtil.commit;
import static ara.db.JdbcUtil.getConnect;
import static ara.db.JdbcUtil.rollback;

import java.sql.Connection;

import ara.web.asBoard.dao.BoardDAO;



public class AsCommentDeleteService {

	public boolean removeComment(int c_num) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean removeSuccess = false;
		int deleteCount = boardDAO.deleteComment(c_num);
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



