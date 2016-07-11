package ara.web.noticeAdmin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;

public class NoticeBoardDeleteFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num")); 
		String pageNum = request.getParameter("pageNum");
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/noticeDeleteForm.jsp");
		
		return forward;
	}

}
