package ara.web.noticeAdmin.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.notice.svc.CommentService;
import ara.web.notice.vo.CommentVO;
import ara.web.member.vo.Member;

public class CommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		String c_content = request.getParameter("reply_content");
		String c_writer = ((Member)session.getAttribute("loginUser")).getM_id();
	    CommentVO commentVO = new CommentVO(q_num, c_writer, c_content, new Timestamp(System.currentTimeMillis()));
		CommentService commentService = new CommentService();
		boolean isRegistSuccess = commentService.registComment(commentVO);
		ActionForward forward = new ActionForward();
		if (isRegistSuccess) {
			forward.setUrl("adminQnABoardContent.boa?num=" + q_num);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��� ��� ����.')");
			out.println("history.back()"); 
			out.println("</script>");
		}
		return forward;
   }

}
