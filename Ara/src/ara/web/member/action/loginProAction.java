package ara.web.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.member.svc.LoginService;
import ara.web.member.vo.Member;

public class loginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		LoginService loginService = new LoginService();
		Member loginUser = loginService.getLoginUser(id, passwd);

		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			forward.setUrl("index.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�α��� ����')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
