package ara.web.member.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.member.svc.IdCheckService;

public class IdCheckProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id"); // ���̵� ���� �޾ƿ´�.
		IdCheckService idCheckService = new IdCheckService();
		
		boolean idExists = idCheckService.existsId(id); // �ߺ� üũ
		request.setAttribute("id", id);
		request.setAttribute("idExists", idExists);
		
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("member/idCheck.jsp");
		dispatcher.forward(request, response);*/
		ActionForward forward = new ActionForward();
		forward.setUrl("member/idCheck.jsp");
		return forward;
	}

}
