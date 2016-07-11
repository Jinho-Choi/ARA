package ara.web.asBoard.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.asBoard.svc.AsCommentDeleteService;


public class AsCommentDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int c_num = Integer.parseInt(request.getParameter("c_num"));
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		AsCommentDeleteService qnACommentDeleteService = new AsCommentDeleteService();
		boolean removeSuccess = qnACommentDeleteService.removeComment(c_num);
		ActionForward forward = new ActionForward();
		if(removeSuccess) {
			forward.setUrl("qnABoardContent.bo?num=" + num + "&pageNum=" + pageNum);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('���� ����')"); // ���� ���н� �˸�â ����ش�.
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
