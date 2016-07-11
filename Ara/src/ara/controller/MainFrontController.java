package ara.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.action.MainAction;
import ara.vo.ActionForward;
<<<<<<< HEAD
<<<<<<< HEAD

=======
import ara.web.notice.action.CommentAction;
import ara.web.notice.action.NoticeBoardContentAction;
import ara.web.notice.action.NoticeBoardListAction;
>>>>>>> branch 'young' of https://github.com/Jinho-Choi/ARA.git
=======

>>>>>>> refs/remotes/origin/kim

/**
 * Servlet implementation class MainFrontController
 */
@WebServlet("*.do")
public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()); 
	
		Action action = null; 
		ActionForward forward = null; 

		if (command.equals("/main.do")) {
			action = new MainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} 
		
		if (forward != null) {
			if (forward.isRedirect()) { 
				response.sendRedirect(forward.getUrl());
			} else { 
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
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
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

}
