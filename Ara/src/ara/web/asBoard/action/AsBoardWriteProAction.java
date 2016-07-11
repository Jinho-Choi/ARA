package ara.web.asBoard.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.web.asBoard.vo.AsBoardVO;
import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.asBoard.svc.AsBoardWriteProService;
import ara.web.asBoard.vo.AsBoardVO;

public class AsBoardWriteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		AsBoardVO article = new AsBoardVO();
		article.setContent(request.getParameter("content")); 
		article.setEmail(request.getParameter("email"));
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setPasswd(request.getParameter("passwd"));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setSubject(request.getParameter("subject"));
		article.setWriter(request.getParameter("writer"));
		
		article.setReg_date(new Timestamp(System.currentTimeMillis()));

		article.setIp(request.getRemoteAddr()); 
		
		AsBoardWriteProService qnABoardWriteProService = new AsBoardWriteProService();
		
		boolean writeSuccess = qnABoardWriteProService.writeArticle(article);
		ActionForward forward = null;
		if(writeSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true); 
			forward.setUrl("qnABoardList.bo");
		} else { 
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}
}
