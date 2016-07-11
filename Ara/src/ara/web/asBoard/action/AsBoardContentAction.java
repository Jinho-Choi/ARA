package ara.web.asBoard.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.asBoard.svc.CommentService;
import ara.web.asBoard.svc.AsBoardContentService;
import ara.web.asBoard.vo.CommentVO;
import ara.web.asBoard.vo.AsBoardVO;

public class AsBoardContentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		AsBoardContentService asBoardContentService = new AsBoardContentService();
		
		AsBoardVO article = asBoardContentService.getAsArticle(num);
		CommentService commentService = new CommentService();
		ArrayList<CommentVO> comment = commentService.selectqnaReplyList(num);
		
		request.setAttribute("comment", comment);
		request.setAttribute("article", article);
		request.setAttribute("pageNum", pageNum);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/qnAContent.jsp"); 
		return forward;
	}

}
