package ara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ara.vo.ActionForward;
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
		session.setAttribute("pageNum", pageNum);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("main.jsp");
		
		return forward;
	}

}
