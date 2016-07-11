package ara.web.noticeAdmin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.noticeAdmin.svc.NoticeBoardContentService;
import ara.web.noticeAdmin.vo.NoticeBoardVO;


public class NoticeBoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		NoticeBoardContentService noticeBoardContentService = new NoticeBoardContentService();
		
		NoticeBoardVO article = noticeBoardContentService.getNoticeArticle(num);
		
		request.setAttribute("article", article);
		request.setAttribute("pageNum", pageNum);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/adminNoticeContent.jsp");
		return forward;
	}

}
