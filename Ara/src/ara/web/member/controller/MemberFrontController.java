package ara.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.member.action.IdCheckProAction;
import ara.web.member.action.LogoutAction;
import ara.web.member.action.MemberDetailAction;
import ara.web.member.action.MemberMainAction;
import ara.web.member.action.MemberModifyFormAction;
import ara.web.member.action.MemberModifyProAction;
import ara.web.member.action.MemberRegistFormAction;
import ara.web.member.action.MemberRegistProAction;
import ara.web.member.action.loginFormAction;
import ara.web.member.action.loginProAction;
import ara.web.member.action.zipcodeSearchAction;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.mem")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
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
		if(command.equals("/memberRegistForm.mem")) { // ȸ������ ��
			action = new MemberRegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberRegistPro.mem")) { // ȸ������ ó��
			action = new MemberRegistProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/idCheckPro.mem")) { // ���̵� üũ
			action = new IdCheckProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/loginForm.mem")) { // �α���ȭ�� ���
			action = new loginFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/loginPro.mem")) { // �α��� ó��
			action = new loginProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.mem")) { // �α׾ƿ� ó��
			action = new LogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/memberMain.mem")) { // ȸ������ ����
			action = new MemberMainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberDetail.mem")) { // ȸ�������󼼺���
			action = new MemberDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberModifyForm.mem")) { // ȸ�������󼼺���
			action = new MemberModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberModifyPro.mem")) { // ȸ�������󼼺���
			action = new MemberModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/zipcodeSearch.mem")) { // �����ȣ �˻�
	         action = new zipcodeSearchAction();
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
