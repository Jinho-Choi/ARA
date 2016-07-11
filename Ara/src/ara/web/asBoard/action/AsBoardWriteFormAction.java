package ara.web.asBoard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.asBoard.vo.ReplyInfo;

public class AsBoardWriteFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
		int num = 0, ref = 0, re_step = 0, re_level = 0;
	
		if(request.getParameter("num") != null) {
			num = Integer.parseInt(request.getParameter("num")); 
			ref = Integer.parseInt(request.getParameter("ref"));
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}
		
		ReplyInfo replyInfo = new ReplyInfo(); 
		replyInfo.setNum(num);
		replyInfo.setRe_step(re_step);
		replyInfo.setRe_level(re_level);
		replyInfo.setRef(ref);

		request.setAttribute("replyInfo", replyInfo);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/qnAWriteForm.jsp");
		
		return forward;
	}

}
