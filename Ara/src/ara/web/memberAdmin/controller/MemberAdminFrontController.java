package ara.web.memberAdmin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.memberAdmin.action.MemberAdminMainAction;
import ara.web.memberAdmin.action.MemberListAction;
import ara.web.memberAdmin.action.MemberRemoveAction;
import ara.web.memberAdmin.action.SearchListAction;

/**
 * Servlet implementation class MemberAdminFrontController
 */
@WebServlet("*.mema")
public class MemberAdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAdminFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet, doPost�� ����� �۾����� doProcess���� ��û ó��
		// 1. ��û �ľ�(���� ��û�� �Ѿ�Դ��� �ľ�)
		String requestURI = request.getRequestURI();
		// ��û �ּ� : http://localhost:8088/BoardProject/boardWriteForm.bo�� �Ѿ����..
		// reqeustURI : /BoardProject/boardWriteForm.bo
		
		String contextPath = request.getContextPath();
		// /BoardProject�� ��ȯ��.
		
		String command = requestURI.substring(contextPath.length()); // ��� �ľ�
		// contextPath �������� �������� ���ڸ� ������. ----> /boardWriteForm.bo�� �������� ��.
		
		Action action = null; // Action �������̽� ����
		ActionForward forward = null; // �������� �������� ������ ���� foward����
		
		// ������ ��û ó��
		if(command.equals("/memberAdminMain.mema")) { // �������� ����Ʈ
			action = new MemberAdminMainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberList.mema")) { // �������� ����Ʈ
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberRemove.mema")) { // �������� ����Ʈ
			action = new MemberRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/searchList.mema")) { // �������� ����Ʈ
			action = new SearchListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		// �����Ͻ����� ó���� ������ ������
		if(forward != null) {
			if(forward.isRedirect()) { // �����̷�Ʈ ����̸�...
				response.sendRedirect(forward.getUrl());
			}
			else { // ����ġ ����̸�...
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); // ��û�� �ѱ� ó��
		doProcess(request, response);
	}

}
