package ara.web.message.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.message.action.MessageContentAction;
import ara.web.message.action.MessageDeleteAction;
import ara.web.message.action.MessageReceiveListAction;
import ara.web.message.action.MessageReplyFormAction;
import ara.web.message.action.MessageResendFormAction;
import ara.web.message.action.MessageResendProAction;
import ara.web.message.action.MessageSendContentAction;
import ara.web.message.action.MessageSendDeleteAction;
import ara.web.message.action.MessageSendListAction;
import ara.web.message.action.MessageWriteFormAction;
import ara.web.message.action.MessageWriteProAction;

/**
 * Servlet implementation class MessageFrontController
 */
@WebServlet("*.msg")
public class MessageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageFrontController() {
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
		if(command.equals("/messageWriteForm.msg")) {
	         action = new MessageWriteFormAction();
	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	         }
	      }
	      else if(command.equals("/messageWritePro.msg")) {
	         action = new MessageWriteProAction();
	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	         }
	      }
	      else if(command.equals("/messageReceiveList.msg")) {
	         action = new MessageReceiveListAction();
	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	         }
	      }
	      else if(command.equals("/messageSendList.msg")) {
	    	  action = new MessageSendListAction();
	    	  try {
	    		  forward = action.execute(request, response);
	    	  } catch (Exception e) {
	    		  // TODO: handle exception
	    		  e.printStackTrace();
	    	  }
	      }

	      else if(command.equals("/messageContent.msg")) {
	         action = new MessageContentAction();
	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	         }
	      }
	      else if(command.equals("/messageSendContent.msg")) {
	    	  action = new MessageSendContentAction();
	    	  try {
	    		  forward = action.execute(request, response);
	    	  } catch (Exception e) {
	    		  // TODO: handle exception
	    		  e.printStackTrace();
	    	  }
	      }
	      else if(command.equals("/messageDelete.msg")) {
	         action = new MessageDeleteAction();
	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	         }
	      }
	      else if(command.equals("/messageSendDelete.msg")) {
	    	  action = new MessageSendDeleteAction();
	    	  try {
	    		  forward = action.execute(request, response);
	    	  } catch (Exception e) {
	    		  // TODO: handle exception
	    		  e.printStackTrace();
	    	  }
	      }
	      else if(command.equals("/messageReplyForm.msg")) {
	    	  action = new MessageReplyFormAction();
	    	  try {
	    		  forward = action.execute(request, response);
	    	  } catch (Exception e) {
	    		  // TODO: handle exception
	    		  e.printStackTrace();
	    	  }
	      }
	      else if(command.equals("/messageResendForm.msg")) {
	    	  action = new MessageResendFormAction();
	    	  try {
	    		  forward = action.execute(request, response);
	    	  } catch (Exception e) {
	    		  // TODO: handle exception
	    		  e.printStackTrace();
	    	  }
	      }
	      else if(command.equals("/messageResendPro.msg")) {
	    	  action = new MessageResendProAction();
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
