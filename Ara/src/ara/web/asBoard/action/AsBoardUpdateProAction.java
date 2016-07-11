package ara.web.asBoard.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.asBoard.svc.AsBoardUpdateProService;
import ara.web.asBoard.vo.AsBoardVO;

public class AsBoardUpdateProAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		AsBoardVO article = new AsBoardVO();
		article.setContent(request.getParameter("content")); 
		article.setEmail(request.getParameter("email"));
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setPasswd(request.getParameter("passwd"));
		article.setSubject(request.getParameter("subject"));
		article.setWriter(request.getParameter("writer"));

		article.setReg_date(new Timestamp(System.currentTimeMillis()));

		article.setIp(request.getRemoteAddr()); 

		AsBoardUpdateProService asBoardUpdateProService = new AsBoardUpdateProService();
		
		boolean updateSuccess = asBoardUpdateProService.modifyAsArticle(article);
		ActionForward forward = null;
		if(updateSuccess) { 
			forward = new ActionForward();
			forward.setRedirect(true); 
			forward.setUrl("qnABoardList.bo"); 
		} else { 
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}
}
