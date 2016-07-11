package ara.web.message.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.member.vo.Member;
import ara.web.message.svc.MessageWriteProService;
import ara.web.message.vo.MessageVO;

public class MessageWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MessageVO messageArticle = new MessageVO();
	    messageArticle.setMessageWriter(((Member)session.getAttribute("loginUser")).getM_id());
	    messageArticle.setTitle(request.getParameter("title"));
        messageArticle.setMessageReceiver(request.getParameter("receiver"));
        messageArticle.setMessageContent(request.getParameter("content"));
        messageArticle.setMessageReg_date(new Timestamp(System.currentTimeMillis()));
	      
	      MessageWriteProService messageWriteProService = new MessageWriteProService();
	      
	      boolean writeSuccess = messageWriteProService.sendMessage(messageArticle);
	      ActionForward forward = null;
	      if(writeSuccess){
	         forward = new ActionForward();
	         forward.setRedirect(true);
	         forward.setUrl("messageReceiveList.msg");
	      }
	      else{
	         response.setContentType("text/html;charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('���۽���')");
	         out.println("history.back()");
	         out.println("</script>");
	      }
	      return forward;
	}
}
