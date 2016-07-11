package ara.web.member.action;

import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ara.action.Action;
import ara.vo.ActionForward;
import ara.web.member.svc.ZipSearchService;
import ara.web.member.vo.Zipcode;

public class zipcodeSearchAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      String dong = request.getParameter("dong");
      ZipSearchService zipSearchService = new ZipSearchService();
      
      ArrayList<Zipcode> zipSearchDataList = zipSearchService.getZipSearchData(dong);
      
      request.setAttribute("zipSearchDataList", zipSearchDataList);
      /*RequestDispatcher dispatcher = request.getRequestDispatcher("zipSearch.jsp");
      dispatcher.forward(request, response);*/
      ActionForward forward = new ActionForward();
      forward.setUrl("/member/zipSearch.jsp");
   
      return forward;
   }

}
