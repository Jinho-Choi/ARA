package ara.web.notice.svc;

import java.sql.Connection;
import static ara.db.JdbcUtil.*;
import ara.web.notice.dao.BoardDAO;
import ara.web.notice.vo.NoticeBoardVO;

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
