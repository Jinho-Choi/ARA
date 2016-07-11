package ara.web.memberAdmin.action;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.memberAdmin.svc.MemberListService;
import ara.web.memberAdmin.vo.Member;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
MemberListService memberListService  = new MemberListService();
		
		ArrayList<Member> memberList =
				memberListService.getMemberList();
		request.setAttribute("memberList", memberList);
		ActionForward forward = new ActionForward();
		forward.setUrl("/member/memberList.jsp");
		return forward;
	}

}
