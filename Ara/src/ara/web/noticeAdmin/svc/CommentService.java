package ara.web.noticeAdmin.svc;

import java.sql.Connection;
import java.util.ArrayList;

import static ara.db.JdbcUtil.*;
import ara.web.notice.dao.BoardDAO;
import ara.web.noticeAdmin.dao.BoardAdminDAO;
import ara.web.noticeAdmin.vo.CommentVO;

public class CommentService {

	public boolean registComment(CommentVO commentVO) {
		// TODO Auto-generated method stub
		Connection con = getConnect();
		BoardAdminDAO boardAdminDAO = BoardAdminDAO.getInstance();
		boardAdminDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = boardAdminDAO.insertComment(commentVO);
		if (insertCount>0) {
			commit(con);
			isRegistSuccess = true;
		}else{
			rollback(con);
		}
		close(con);
		return isRegistSuccess;
	}
	

	public ArrayList<CommentVO> selectqnaReplyList(int num) {

		Connection con = getConnect();
		BoardAdminDAO boardAdminDAO = BoardAdminDAO.getInstance();
		boardAdminDAO.setConnection(con);
		ArrayList<CommentVO> commentList = boardAdminDAO.selectBoardCommentList(num);
		close(con);
		return commentList;
	}
	

}
