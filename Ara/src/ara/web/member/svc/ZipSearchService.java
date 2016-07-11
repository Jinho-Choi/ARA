package ara.web.member.svc;

import static ara.db.JdbcUtil.*;


import java.sql.Connection;
import java.util.ArrayList;

import ara.web.member.dao.MemberDAO;
import ara.web.member.vo.Zipcode;

public class ZipSearchService {

   public ArrayList<Zipcode> getZipSearchData(String dong) {
      // TODO Auto-generated method stub
      Connection con = getConnect();
      MemberDAO memberDAO = MemberDAO.getInstance();
      memberDAO.setConnection(con);
      
      ArrayList<Zipcode> zipSearchList = memberDAO.selectZipcodeList(dong);
      
      close(con);
      
      return zipSearchList;
   }
   }