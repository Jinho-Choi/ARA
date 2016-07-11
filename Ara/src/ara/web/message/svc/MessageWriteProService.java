package ara.web.message.svc;

import static ara.db.JdbcUtil.*;
import java.sql.Connection;
import ara.web.message.dao.MessageDAO;
import ara.web.message.vo.MessageVO;

public class MessageWriteProService {
	public boolean sendMessage(MessageVO sendMessage) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MessageDAO messageDAO = MessageDAO.getInstance();
		messageDAO.setConnection(con);
		boolean isSendSuccess = false;
		int insertCount = messageDAO.insertMessage(sendMessage);
		if(insertCount > 0 ){
			commit(con);
			isSendSuccess = true;
		}else{
			rollback(con);
		}
		close(con);
		
		return isSendSuccess;
	}
}
