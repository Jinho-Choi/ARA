package ara.web.noticeAdmin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.noticeAdmin.action.CommentAction;
import ara.web.noticeAdmin.action.NoticeBoardContentAction;
import ara.web.noticeAdmin.action.NoticeBoardDeleteFormAction;
import ara.web.noticeAdmin.action.NoticeBoardDeleteProAction;
import ara.web.noticeAdmin.action.NoticeBoardListAction;
import ara.web.noticeAdmin.action.NoticeBoardUpdateFormAction;
import ara.web.noticeAdmin.action.NoticeBoardUpdateProAction;
import ara.web.noticeAdmin.action.NoticeBoardWriteFormAction;
import ara.web.noticeAdmin.action.NoticeBoardWriteProAction;

/**
 * Servlet implementation class BoardAdminFrontController
 */
@WebServlet("*.boa")
public class BoardAdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAdminFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()); 
		Action action = null; 
		ActionForward forward = null; 
		
		// 각각의 요청 처리
		if(command.equals("/adminNoticeBoardList.boa")) {
			action = new NoticeBoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/adminNoticeBoardContent.boa")) { 
			action = new NoticeBoardContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeBoardWriteForm.boa")) { 
			action = new NoticeBoardWriteFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeBoardWritePro.boa")) {
			action = new NoticeBoardWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/noticeBoardUpdateForm.boa")) { 
			action = new NoticeBoardUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeBoardUpdatePro.boa")) { 
			action = new NoticeBoardUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeBoardDeleteForm.boa")) { 
			action = new NoticeBoardDeleteFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeBoardDeletePro.boa")) { 
			action = new NoticeBoardDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		// 비지니스로직 처리가 끝나면 포워딩
		if(forward != null) {
			if(forward.isRedirect()) { // 리다이렉트 방식이면...
				response.sendRedirect(forward.getUrl());
			}
			else { // 디스패치 방식이면...
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
		request.setCharacterEncoding("UTF-8"); // 요청을 한글 처리
		doProcess(request, response);
	}

}
