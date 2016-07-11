package ara.web.noticeAdmin.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.noticeAdmin.svc.NoticeBoardUpdateProService;
import ara.web.noticeAdmin.vo.NoticeBoardVO;


public class NoticeBoardUpdateProAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NoticeBoardVO article = new NoticeBoardVO();
		article.setContent(request.getParameter("content")); 
		article.setEmail(request.getParameter("email"));
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setPasswd(request.getParameter("passwd"));
		article.setSubject(request.getParameter("subject"));
		article.setWriter(request.getParameter("writer"));
		
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		article.setIp(request.getRemoteAddr()); 
		
		NoticeBoardUpdateProService noticeBoardUpdateProService = new NoticeBoardUpdateProService();
		
		boolean updateSuccess = noticeBoardUpdateProService.modifyNoticeArticle(article);
		ActionForward forward = null;
		if(updateSuccess) { 
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("adminNoticeBoardList.boa"); 
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��������')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
