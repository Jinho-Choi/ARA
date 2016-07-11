package ara.web.message.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.member.vo.Member;
import ara.web.message.svc.MessageSendListService;
import ara.web.message.vo.MessageVO;
import ara.web.message.vo.PageInfo;

public class MessageSendListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum"); // ������ ��ȣ�� �޾ƿ´�.
		if(pageNum == null) {
			pageNum = "1"; // ������ ��ȣ�� ������ ������ ������ �Խ��� 1page�� �����ش�.
		}
		
		// ������ ��ȣ�� ����ؼ� ����¡ ó�� �� ������ ������ ���̹Ƿ�
		// ������ ��ȣ���� ����Ÿ������ ����
		
		int currentPage = Integer.parseInt(pageNum);
		
		// �ش� �������� ��µǴ� �۵� �� ���� ���� ��µǴ� ���� ���ڵ� ��ȣ
		int startRow = (currentPage - 1) * pageSize + 1;
		// ���� ������ : 1
		// (1 - 1) * pageSize + 1 ---------> 1
		// ���� ������ : 2
		// (2 - 1) * pageSize + 1 ---------> 11
		
		int count = 0;
		// count : �� ���� ������ ������ ����
		int number = 0;
		// number : �ش� �������� ���� ���� ��µǴ� ���� ��ȣ
		
		List<MessageVO> sendList = null;
		MessageSendListService messageSendListService = new MessageSendListService();
		
		count = messageSendListService.getSendCount();
		if (count > 0){
				sendList = messageSendListService.getSendList(((Member)session.getAttribute("loginUser")).getM_id(), startRow, pageSize);
		}
		
		// ��ü ���������� ���������� -1�� �ؼ� pageSize�� ���Ѵ�.
					number = count - (currentPage - 1) * pageSize;
					// �� ���� ���� : 134
					// ���� ������ : 1
					// 134 - (1 - 1) * 10 -------> 134
					
					int startPage = 0;
					int pageCount = 0;
					int endPage = 0;
					if(count >0){
					pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
					// �� ������ ������ ����.
					// ex) �� ���� ���� 13���̸� �������� 2�� �ʿ�..

					startPage = ((currentPage -1) / pageSize) * pageSize + 1;
					// ���� ������ �׷��� ù��° �������� ����.
					// [1][2][3][4][5][6][7]...[10] -------> ó�� ������ �׷�
					// ���� ������ ��ŸƮ ������ : [11][12][13]....[20]
							
					int pageBlock = 10;
					endPage = startPage + pageBlock - 1;
					
					// ������ ������ �׷��� ���..
					if(endPage > pageCount) endPage = pageCount;
					}
					request.setAttribute("pageNum", pageNum);
		request.setAttribute("sendList", sendList);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCount(count);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setNumber(number);
		pageInfo.setPageCount(pageCount);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		forward.setUrl("/message/messageSendList.jsp");
		return forward;
		
	}
}
