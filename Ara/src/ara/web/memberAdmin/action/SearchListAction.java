package ara.web.memberAdmin.action;

import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.memberAdmin.svc.SearchListService;
import ara.web.memberAdmin.vo.Member;

public class SearchListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String option = request.getParameter("searchOption");
		String search = request.getParameter("search");
        SearchListService searchListService  = new SearchListService();
        ArrayList<Member> memberList = null;
        		
		ActionForward forward = new ActionForward();
		if(option.equals("���̵�")){
			memberList = searchListService.getSearchId(search);
			if(memberList == null || memberList.isEmpty()) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���!!!')");
				out.println("history.back();");
				out.println("</script>");
			} else {
				request.setAttribute("memberList", memberList);
				forward.setUrl("/member/memberList.jsp");
			}
		}
		else if(option.equals("�̸�")) {
			memberList = searchListService.getSearchName(search);
			if(memberList == null || memberList.isEmpty()) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���!!!')");
				out.println("history.back();");
				out.println("</script>");
			} else {
				request.setAttribute("memberList", memberList);
				forward.setUrl("/member/memberList.jsp");
			}
		}	
		
		return forward;
	}

}
