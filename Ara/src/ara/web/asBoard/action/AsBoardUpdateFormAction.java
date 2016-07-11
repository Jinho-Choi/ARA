package ara.web.asBoard.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.asBoard.svc.AsBoardUpdateFormService;
import ara.web.asBoard.vo.AsBoardVO;
import ara.web.member.vo.Member;

public class AsBoardUpdateFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num")); 
		String pageNum = request.getParameter("pageNum");
		String writer = request.getParameter("writer");
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		ActionForward forward = new ActionForward();
		if(writer.equals(loginUser.getM_id())) {
			AsBoardUpdateFormService asBoardUpdateFormService = new AsBoardUpdateFormService();
			AsBoardVO article = asBoardUpdateFormService.getUpdateAsArticle(num);
	
			request.setAttribute("article", article);
			request.setAttribute("pageNum", pageNum);
			forward = new ActionForward();
			forward.setUrl("/board/qnAUpdateForm.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 수 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}
}
	
