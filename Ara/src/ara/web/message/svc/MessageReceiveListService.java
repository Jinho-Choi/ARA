package ara.web.message.svc;

import static ara.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.List;
import ara.web.message.dao.MessageDAO;
import ara.web.message.vo.MessageVO;


public class MessageReceiveListService {

	public int getReceiveCount() {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MessageDAO messageDAO = MessageDAO.getInstance();
		messageDAO.setConnection(con);
		int receiveCount = messageDAO.selectReceiveCount();
		close(con);
		return receiveCount;
	}
	
	public List<MessageVO> getReceiveList(String m_id, int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		MessageDAO messageDAO = MessageDAO.getInstance();
		messageDAO.setConnection(con);
		
		List<MessageVO> receiveList = messageDAO.selectReceiveList(m_id, startRow, pageSize);
		close(con);
		return receiveList;
	}

}
