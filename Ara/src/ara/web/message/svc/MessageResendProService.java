package ara.web.message.svc;

import static ara.db.JdbcUtil.*;
import static ara.db.JdbcUtil.getConnect;
import static ara.db.JdbcUtil.rollback;

import java.sql.Connection;

import ara.web.message.dao.MessageDAO;
import ara.web.message.vo.MessageVO;

public class MessageResendProService {

	public boolean resendMessage(MessageVO resendMessage) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MessageDAO messageDAO = MessageDAO.getInstance();
		messageDAO.setConnection(con);
		boolean isSendSuccess = false;
		int insertCount = messageDAO.insertMessage(resendMessage);
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
