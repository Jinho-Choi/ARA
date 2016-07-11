package ara.action;

<<<<<<< HEAD
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ara.vo.ActionForward;
<<<<<<< HEAD
<<<<<<< HEAD
import ara.web.board.svc.NoticeBoardListService;
import ara.web.board.svc.QnABoardListService;
import ara.web.board.vo.NoticeBoardVO;
import ara.web.board.vo.QnABoardVO;
import ara.web.pcAdmin.svc.ErrorPCListService;
import ara.web.pcAdmin.svc.ReservationListService;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pageSize = 10;
		
		String pageNum = request.getParameter("pageNum"); 
		if(pageNum == null) {
			pageNum = "1"; 
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;			
		int count = 0;
		int number = 0;

		List<NoticeBoardVO> noticeArticleList = null;
		List<QnABoardVO> qnaArticleList = null;
		int errorPCCount = 0;
		int reservationCount = 0;
		
		NoticeBoardListService noticeBoardListService = new NoticeBoardListService();
		QnABoardListService qnABoardListService = new QnABoardListService();
		ErrorPCListService errorPCListService = new ErrorPCListService();
		ReservationListService reservationListService = new ReservationListService();
		
		noticeArticleList = noticeBoardListService.getNoticeContentArticleList(); 
		qnaArticleList = qnABoardListService.getQnAContentArticleList();
		errorPCCount = errorPCListService.getErrorPCCount();
		reservationCount = reservationListService.getReservationCount();
		
		HttpSession session = request.getSession();
		session.setAttribute("noticeArticleList", noticeArticleList);
		session.setAttribute("qnaArticleList", qnaArticleList);
		session.setAttribute("errorPCCount", errorPCCount);
		session.setAttribute("reservationCount", reservationCount);
=======
import ara.web.notice.svc.NoticeBoardListService;
import ara.web.notice.vo.NoticeBoardVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pageSize = 10;
		
		String pageNum = request.getParameter("pageNum"); 
		if(pageNum == null) {
			pageNum = "1"; 
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;			
		int count = 0;
		int number = 0;

		List<NoticeBoardVO> noticeArticleList = null;
		
		NoticeBoardListService noticeBoardListService = new NoticeBoardListService();
		
		noticeArticleList = noticeBoardListService.getNoticeContentArticleList(); 
		
		HttpSession session = request.getSession();
		session.setAttribute("noticeArticleList", noticeArticleList);
>>>>>>> branch 'young' of https://github.com/Jinho-Choi/ARA.git
=======


public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pageSize = 10;
		
		String pageNum = request.getParameter("pageNum"); 
		if(pageNum == null) {
			pageNum = "1"; 
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;			
		int count = 0;
		int number = 0;

		/*List<NoticeBoardVO> noticeArticleList = null;
		List<QnABoardVO> qnaArticleList = null;
		int errorPCCount = 0;
		int reservationCount = 0;
		
		NoticeBoardListService noticeBoardListService = new NoticeBoardListService();
		AsBoardListService qnABoardListService = new AsBoardListService();
		ErrorPCListService errorPCListService = new ErrorPCListService();
		ReservationListService reservationListService = new ReservationListService();*/
		
		/*noticeArticleList = noticeBoardListService.getNoticeContentArticleList(); 
		qnaArticleList = qnABoardListService.getQnAContentArticleList();
		errorPCCount = errorPCListService.getErrorPCCount();
		reservationCount = reservationListService.getReservationCount();*/
		
		HttpSession session = request.getSession();
		/*session.setAttribute("noticeArticleList", noticeArticleList);
		session.setAttribute("qnaArticleList", qnaArticleList);
		session.setAttribute("errorPCCount", errorPCCount);
		session.setAttribute("reservationCount", reservationCount);*/
>>>>>>> refs/remotes/origin/kim
=======

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ara.vo.ActionForward;


public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pageSize = 10;
		
		String pageNum = request.getParameter("pageNum"); 
		if(pageNum == null) {
			pageNum = "1"; 
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;			
		int count = 0;
		int number = 0;

		int errorPCCount = 0;
		int reservationCount = 0;
		
				
		HttpSession session = request.getSession();
>>>>>>> refs/remotes/origin/knight
		session.setAttribute("pageNum", pageNum);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("main.jsp");
		
		return forward;
	}

}
