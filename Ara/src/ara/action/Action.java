package ara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.vo.ActionForward;

//������ ��û�� ó���ϴ� ActionŬ���� ��ü���� �԰��� ������ �������̽�
public interface Action {
	
<<<<<<< HEAD
	public ActionForward execute(HttpServletRequest request,
=======
	public ara.vo.ActionForward execute(HttpServletRequest request,
>>>>>>> refs/remotes/origin/59
			HttpServletResponse response) throws Exception;
}
