package ara.web.asBoard.svc;

import java.sql.Connection;
import static ara.db.JdbcUtil.*;
import ara.web.asBoard.dao.BoardDAO;
import ara.web.asBoard.vo.NoticeBoardVO;

public class NoticeBoardContentService {

	public NoticeBoardVO getNoticeArticle(int num) {
		// TODO Auto-generated method stub
		Connection con = getConnect(); 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con); 
		
		NoticeBoardVO article = boardDAO.selectNoticeArticle(num);
		close(con);
		
		return article;
	}

}
