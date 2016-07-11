package ara.web.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.member.svc.MemberRegistService;
import ara.web.member.vo.Member;

public class MemberRegistProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String u_id = request.getParameter("id");
		String u_name = request.getParameter("name");
		String u_passwd = request.getParameter("passwd");
		String u_email = request.getParameter("email");
		String u_phone = request.getParameter("phone");
		String u_gender = request.getParameter("gender");
		String u_guardian = request.getParameter("guardian");
		int u_zipcode1 = Integer.parseInt(request.getParameter("zipcode1"));
		int u_zipcode2 = Integer.parseInt(request.getParameter("zipcode2"));
		String u_address1 = request.getParameter("address1");
		String u_address2 = request.getParameter("address2");
		String u_auth = request.getParameter("auth");
		
		Member member = new Member(u_id, u_name, u_passwd, u_email, u_phone, u_gender, u_guardian, u_zipcode1, u_zipcode2, u_address1, u_address2, u_auth);
		MemberRegistService memberRegistService = new MemberRegistService();
		boolean registSuccess = memberRegistService.registMember(member);
		
		ActionForward forward = null;
		if(registSuccess){
			forward = new ActionForward();
			forward.setRedirect(true); // 리다이렉트로 넘어간다는것을 표시
			forward.setUrl("index.jsp"); // 글 목록 보는 화면으로 화면을 넘긴다.
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
