package test.com.content;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContentDAOimpl implements ContentDAO {

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "pro";
	private final String PASSWORD = "1234"; 
	//table name : movie
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ContentDAOimpl() {
		try {
			Class.forName(DRIVER_NAME); //driver 이름 로드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	
	
	@Override
	public int insert(ContentVO vo) {
		System.out.println(" ------- ContentVO의 insert() ----------");
		System.out.println(vo);
		int flag = 0;
		
		try {
			conn=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connect successed! ");
			
			//insert into content(contentNum, contentTitle, contentDirector, contentPoint, 
			//contentReview, contentPeopleName, contentRating, 
			//contentRecommend, contentSnack) 
			//values(seq_content.nextval, 'ironman', 'john', '영상미,내용', '액션신이 너무 재밌었다.', '홍길동,김영희', 9, '예', '카라멜맛팝콘');
			
			String sql ="insert into content(contentNum, contentTitle, contentPoint, "
					+ "contentReview, contentPeopleName, contentRating, "
					+ "contentRecommend, contentSnack) values(seq_content.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContentTitle());
			//pstmt.setString(2, vo.getContentDirector());
			pstmt.setString(2, vo.getContentPoint());
			pstmt.setString(3, vo.getContentReview());
			pstmt.setString(4, vo.getContentPeopleName());
			pstmt.setInt(5, vo.getContentRating());
			pstmt.setString(6, vo.getContentRecommend());
			pstmt.setString(7, vo.getContentSnack());
			
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	
	
	@Override
	public int update(ContentVO vo) {
		System.out.println(" ----- update() ------");
		System.out.println("vo : " + vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
		
			//insert into content(contentNum, contentTitle, contentDirector, contentPoint, 
			//contentReview, contentPeopleName, contentRating, 
			//contentRecommend, contentSnack) 
			//values(seq_content.nextval, 'ironman', 'john', '영상미,내용', '액션신이 너무 재밌었다.', '홍길동,김영희', 9, '예', '카라멜맛팝콘');
			
			String sql = "update content set contentTitle=?, contentPoint=?, "
					+ "contentReview=?, contentPeopleName=?, contentRating=?, "
					+ "contentRecommend=?, contentSnack=?, contentDate=sysdate  where contentNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContentTitle());
			//pstmt.setString(2, vo.getContentDirector());
			pstmt.setString(2, vo.getContentPoint());
			pstmt.setString(3, vo.getContentReview());
			pstmt.setString(4, vo.getContentPeopleName());
			pstmt.setInt(5, vo.getContentRating());
			pstmt.setString(6, vo.getContentRecommend());
			pstmt.setString(7, vo.getContentSnack());
			pstmt.setInt(8, vo.getContentNum());
			
			flag = pstmt.executeUpdate(); 
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	
	
	@Override
	public int delete(ContentVO vo) {
		System.out.println(" ----- delete() ------");
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "delete from content where contentNum =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getContentNum());
			
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	
	
	@Override
	public ContentVO selectOne(ContentVO vo) {
		System.out.println(" ----- selectOne() ------");
		System.out.println("vo : " + vo);
		
		ContentVO vo2 = new ContentVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
		
			String sql = "select * from content where contentNum =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getContentNum());
			rs = pstmt.executeQuery();
			
//			pstmt.setString(1, vo.getContentTitle());
//			pstmt.setString(2, vo.getContentDirector());
//			pstmt.setString(3, vo.getContentPoint());
//			pstmt.setString(4, vo.getContentReview());
//			pstmt.setString(5, vo.getContentPeopleName());
//			pstmt.setInt(6, vo.getContentRating());
//			pstmt.setString(7, vo.getContentRecommend());
//			pstmt.setString(8, vo.getContentSnack());
//			pstmt.setInt(9, vo.getContentNum());
			
			
			while(rs.next()) {
				vo2.setContentNum(rs.getInt("contentNum"));
				vo2.setContentTitle(rs.getString("contentTitle"));
				//vo2.setContentDirector(rs.getString("contentDirector"));
				vo2.setContentDate(rs.getDate("ContentDate"));
				vo2.setContentPoint(rs.getString("contentPoint"));
				vo2.setContentReview(rs.getString("contentReview"));
				vo2.setContentPeopleName(rs.getString("contentPeopleName"));
				vo2.setContentRating(rs.getInt("contentRating"));
				vo2.setContentRecommend(rs.getString("contentRecommend"));
				vo2.setContentSnack(rs.getString("contentSnack"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vo2;
	}

	
	
	@Override
	public List<ContentVO> selectAll() {
		System.out.println("---- selectAll() ----");
		List<ContentVO> list = new ArrayList<ContentVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
		
			String sql = "select * from content order by contentNum asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			
			while(rs.next()) {
				ContentVO vo = new ContentVO();
				vo.setContentNum(rs.getInt("contentNum"));
				vo.setContentTitle(rs.getString("contentTitle"));
				//vo.setContentDirector(rs.getString("contentDirector"));
				vo.setContentDate(rs.getDate("ContentDate"));
				vo.setContentPoint(rs.getString("contentPoint"));
				vo.setContentReview(rs.getString("contentReview"));
				vo.setContentPeopleName(rs.getString("contentPeopleName"));
				vo.setContentRating(rs.getInt("contentRating"));
				vo.setContentRecommend(rs.getString("contentRecommend"));
				vo.setContentSnack(rs.getString("contentSnack"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	
	
	
	@Override
	public List<ContentVO> searchList(String searchKey, String searchWord) {
		System.out.println(" ----- searchList() ------");
		System.out.println("searchKey : " + searchKey);
		System.out.println("searchWord : " + searchWord);
		
		List<ContentVO> list = new ArrayList<ContentVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "select * from content where " + searchKey + " like ? order by contentNum asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ContentVO vo2 = new ContentVO();
				vo2.setContentNum(rs.getInt("contentNum"));
				vo2.setContentTitle(rs.getString("contentTitle"));
				//vo2.setContentDirector(rs.getString("contentDirector"));
				vo2.setContentDate(rs.getDate("ContentDate"));
				vo2.setContentPoint(rs.getString("contentPoint"));
				vo2.setContentReview(rs.getString("contentReview"));
				vo2.setContentPeopleName(rs.getString("contentPeopleName"));
				vo2.setContentRating(rs.getInt("contentRating"));
				vo2.setContentRecommend(rs.getString("contentRecommend"));
				vo2.setContentSnack(rs.getString("contentSnack"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	
	
}
