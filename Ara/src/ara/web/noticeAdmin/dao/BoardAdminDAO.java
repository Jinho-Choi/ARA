package ara.web.noticeAdmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static ara.db.JdbcUtil.*;

import ara.web.noticeAdmin.vo.CommentVO;
import ara.web.noticeAdmin.vo.NoticeBoardVO;



public class BoardAdminDAO {
	private static BoardAdminDAO instance;
	private Connection con;

	public BoardAdminDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BoardAdminDAO getInstance() {
		if (instance == null) {
			instance = new BoardAdminDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int selectNoticeArticleCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int articleCount = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT COUNT(*) FROM noticeBoard"); 
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articleCount = rs.getInt(1); 
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleCount;
	}

	public List<NoticeBoardVO> selectNoticeArticleList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeBoardVO> articleList = null;
		NoticeBoardVO article = null; 
		
		try {
	
			pstmt = con.prepareStatement("SELECT list2.* FROM (SELECT rownum r, list1.* "
					+ "FROM (SELECT * FROM noticeBoard ORDER BY n_num DESC) list1 ) list2 "
					+ "WHERE r BETWEEN ? AND ?");
	
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, startRow + pageSize - 1); 
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				articleList = new ArrayList<NoticeBoardVO>(); 
				do {
					article = new NoticeBoardVO();
					article.setNum(rs.getInt("n_num"));
					article.setWriter(rs.getString("n_writer"));
					article.setEmail(rs.getString("n_email"));
					article.setSubject(rs.getString("n_subject"));
					article.setPasswd(rs.getString("n_passwd"));
					article.setReg_date(rs.getTimestamp("n_reg_date"));
					article.setReadCount(rs.getInt("n_readCount"));
					article.setContent(rs.getString("n_content"));
					article.setIp(rs.getString("n_ip"));
					articleList.add(article); 
				} while (rs.next());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;	
		}

	public NoticeBoardVO selectNoticeArticle(int num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeBoardVO article = null;
		try {

			pstmt = con.prepareStatement("UPDATE noticeBoard SET n_readcount = n_readcount + 1 WHERE n_num = ?");
			
			pstmt.setInt(1, num);
			int updateCount = pstmt.executeUpdate(); 
			if(updateCount > 0) {
				commit(con);
			}
			
			pstmt = con.prepareStatement("SELECT * FROM noticeBoard WHERE n_num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
					article = new NoticeBoardVO();
					article.setNum(rs.getInt("n_num"));
					article.setWriter(rs.getString("n_writer"));
					article.setEmail(rs.getString("n_email"));
					article.setSubject(rs.getString("n_subject"));
					article.setPasswd(rs.getString("n_passwd"));
					article.setReg_date(rs.getTimestamp("n_reg_date"));
					article.setReadCount(rs.getInt("n_readCount"));
					article.setContent(rs.getString("n_content"));
					article.setIp(rs.getString("n_ip"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return article;
	}

	public int insertNoticeArticle(NoticeBoardVO article) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertCount = 0;

		int num = article.getNum();
		int number = 0;

		String sql = "";
		
		 try { 
			 pstmt = con.prepareStatement("SELECT MAX(n_num) FROM noticeBoard");

			 rs = pstmt.executeQuery();
			 if(rs.next()) { 
			
				 number = rs.getInt(1) + 1; 
			 } else {
				 number = 1; 
			 }
			 
			 
			 sql = "INSERT INTO noticeBoard"
			 		+ "(n_num, n_writer, n_email, n_subject, n_passwd, n_reg_date, "
			 		+ "n_readcount, n_content, n_ip) "
			 		+ "VALUES(noticeBoard_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, article.getWriter());
			 pstmt.setString(2, article.getEmail());
			 pstmt.setString(3, article.getSubject());
			 pstmt.setString(4, article.getPasswd());
			 pstmt.setTimestamp(5, article.getReg_date());
			 pstmt.setInt(6, article.getReadCount());
			 pstmt.setString(7, article.getContent());
			 pstmt.setString(8, article.getIp());
			 insertCount = pstmt.executeUpdate();
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		 
		 return insertCount;
	}

	public NoticeBoardVO selectUpdateNoticeArticle(int num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeBoardVO article = null;
		
		try {
			
			pstmt = con.prepareStatement("SELECT * FROM noticeBoard WHERE n_num = ?"); 
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
					article = new NoticeBoardVO();
					article.setNum(rs.getInt("n_num"));
					article.setWriter(rs.getString("n_writer"));
					article.setEmail(rs.getString("n_email"));
					article.setSubject(rs.getString("n_subject"));
					article.setPasswd(rs.getString("n_passwd"));
					article.setReg_date(rs.getTimestamp("n_reg_date"));
					article.setReadCount(rs.getInt("n_readCount"));;
					article.setContent(rs.getString("n_content"));
					article.setIp(rs.getString("n_ip"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return article;
	}

	public int updateNoticeArticle(NoticeBoardVO article) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPasswd = ""; 
		String sql = "";
		int updateCount = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT n_passwd FROM noticeBoard WHERE n_num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				// �ش� ���� ������...
				dbPasswd = rs.getString("n_passwd"); 
				if(dbPasswd.equals(article.getPasswd())) { 
					sql = "UPDATE noticeBoard SET n_writer = ?, n_email = ?, n_subject = ?, n_passwd = ?, "
							+ "n_content = ? WHERE n_num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getWriter()); 
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getPasswd());
					pstmt.setString(5, article.getContent());
					pstmt.setInt(6, article.getNum());
					
					updateCount = pstmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return updateCount;
	}

	public int deleteNoticeArticle(int num, String passwd) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPasswd = ""; 
		String sql = ""; 
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT n_passwd FROM noticeBoard WHERE n_num = ?"); 
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				dbPasswd = rs.getString("n_passwd"); 
				if(dbPasswd.equals(passwd)) { 
					sql = "DELETE FROM noticeBoard WHERE n_num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					deleteCount = pstmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return deleteCount;
	}

	public int selectQnAArticleCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int articleCount = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT COUNT(*) FROM qnABoard"); 
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articleCount = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleCount;
	}


	public int insertComment(CommentVO commentVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "insert into commentInfo values (comment_seq.nextval,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, commentVO.getC_content());
			pstmt.setTimestamp(2, commentVO.getC_reg_date());
			pstmt.setInt(3, commentVO.getC_num());
	     	pstmt.setString(4, commentVO.getC_writer());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<CommentVO> selectBoardCommentList(int num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<CommentVO> commentList = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM commentInfo WHERE q_num= ? ORDER BY c_reg_date desc");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
		
			if(rs.next()){
				commentList = new ArrayList<CommentVO>();
				CommentVO comment = null;
			
				do{
					comment = new CommentVO(rs.getInt("c_seq"), 
							rs.getString("m_id"),
							rs.getString("c_content"),
							rs.getTimestamp("c_reg_date")); 	
					commentList.add(comment);
			}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rs);
		}
		return commentList;
	}

	public int deleteComment(int c_num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement("DELETE FROM commentInfo WHERE c_seq = ?"); 
			pstmt.setInt(1, c_num); 
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

}


	

