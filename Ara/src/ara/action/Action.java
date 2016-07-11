package ara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.vo.ActionForward;

//������ ��û�� ó���ϴ� ActionŬ���� ��ü���� �԰��� ������ �������̽�
public interface Action {
	
	public ara.vo.ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
