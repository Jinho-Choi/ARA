package ara.web.message.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.message.svc.MessageDeleteService;

public class MessageSendDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		if(request.getParameter("num")!=null){
	      String pageNum = request.getParameter("pageNum");
	      String[] deleteArray = request.getParameterValues("num");
	      MessageDeleteService messageDeleteService = new MessageDeleteService();

	      boolean deleteSuccess = messageDeleteService.removeArticle(deleteArray);
	      

	      if(deleteSuccess){
	    	  forward = new ActionForward();
	    	  forward.setRedirect(true);
	    	  forward.setUrl("messageSendList.msg");
	         }
	      else{
	    	  response.setContentType("text/html;charset=UTF-8");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<script>");
	          out.println("alert('��������')");
	          out.println("history.back()");
	          out.println("</script>");
	      }
		}else{
			response.setContentType("text/html;charset=UTF-8");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<script>");
	          out.println("alert('������ �׸��� �����ϼ���.')");
	          out.println("history.back()");
	          out.println("</script>");
		}
	      return forward;
	}

}
