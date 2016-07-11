package ara.web.message.svc;

import java.sql.Connection;
import static ara.db.JdbcUtil.*;

import ara.web.message.dao.MessageDAO;
import ara.web.message.vo.MessageVO;

public class MessageContentService {

	public MessageVO getArticle(int num) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MessageDAO messageDAO = MessageDAO.getInstance();
		messageDAO.setConnection(con);
      
		MessageVO articleContent = messageDAO.selectArticleContent(num);
		close(con);
      
		return articleContent;
	}

}
