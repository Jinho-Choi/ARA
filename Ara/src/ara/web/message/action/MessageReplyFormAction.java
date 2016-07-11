package ara.web.message.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;

public class MessageReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String writer = request.getParameter("writer");
		request.setAttribute("writer", writer);
		
		ActionForward forward = new ActionForward();
	    forward.setUrl("/message/messageReplyForm.jsp");
	      
	    return forward;
	}

}
