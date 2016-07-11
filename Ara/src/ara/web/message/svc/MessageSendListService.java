package ara.web.message.svc;

import static ara.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.List;
import ara.web.message.dao.MessageDAO;
import ara.web.message.vo.MessageVO;


public class MessageSendListService {

	public int getSendCount() {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MessageDAO messageDAO = MessageDAO.getInstance();
		messageDAO.setConnection(con);
		int sendCount = messageDAO.selectSendCount();
		close(con);
		return sendCount;
	}
	
	public List<MessageVO> getSendList(String m_id, int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MessageDAO messageDAO = MessageDAO.getInstance();
		messageDAO.setConnection(con);
		
		List<MessageVO> sendList = messageDAO.selectSendList(m_id, startRow, pageSize);
		close(con);
		return sendList;
	}

}
