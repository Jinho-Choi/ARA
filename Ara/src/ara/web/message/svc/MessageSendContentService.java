package ara.web.message.svc;

import static ara.db.JdbcUtil.close;
import static ara.db.JdbcUtil.getConnect;

import java.sql.Connection;

import ara.web.message.dao.MessageDAO;
import ara.web.message.vo.MessageVO;

public class MessageSendContentService {

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
