package ara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.vo.ActionForward;

//각각의 요청을 처리하는 Action클래스 객체들의 규격을 정의한 인터페이스
public interface Action {
	
<<<<<<< HEAD
<<<<<<< HEAD
	public ActionForward execute(HttpServletRequest request,
=======
	public ara.vo.ActionForward execute(HttpServletRequest request,
>>>>>>> refs/remotes/origin/59
=======
	public ActionForward execute(HttpServletRequest request,
>>>>>>> refs/remotes/origin/knight
			HttpServletResponse response) throws Exception;
}
