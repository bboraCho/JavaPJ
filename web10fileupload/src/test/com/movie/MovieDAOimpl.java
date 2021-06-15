package test.com.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOimpl implements MovieDAO{

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "pro";
	private final String PASSWORD = "1234"; 
	//table name : movie
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public MovieDAOimpl() {
		try {
			Class.forName(DRIVER_NAME); //driver 이름 로드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@Override
	public int insert(MovieVO vo) {
		System.out.println(" ------- MovieVO의 insert() ----------");
		System.out.println(vo);
		int flag = 0;
		
		try {
			conn=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connect successed! ");
			//insert into movie(movieNum, movieTitle, movieDirector, movieWriter, movietheatherPlace, movieTheaterNum, moviePeopleNum, movieSeatNum, movieJanre) 
			//values(seq_movie.nextval, 'Soul', 'pete', 'mike', 'cgv건대입구점', '3관', '성인2명', 'F15', 'Animation');
			String sql ="insert into movie(movieNum, movieTitle, movieDirector, movieWriter, "
					+ "movietheatherPlace, movieTheaterNum, moviePeopleNum, "
					+ "movieSeatNum, movieJanre, movieFileName) values(seq_movie.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMovieTitle());
			pstmt.setString(2, vo.getMovieDirector());
			pstmt.setString(3, vo.getMovieWriter());
			pstmt.setString(4, vo.getMovietheatherPlace());
			pstmt.setString(5, vo.getMovieTheaterNum());
			pstmt.setString(6, vo.getMoviePeopleNum());
			pstmt.setString(7, vo.getMovieSeatNum());
			pstmt.setString(8, vo.getMovieJanre());
			pstmt.setString(9, vo.getMovieFileName());
			
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public int update(MovieVO vo) {
		System.out.println(" ----- update() ------");
		System.out.println("vo : " + vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			//String sql ="insert into movie(movieNum, movieTitle, movieDirector, movieWriter, "
			//		+ "movietheatherPlace, movieTheaterNum, moviePeopleNum, "
			//		+ "movieSeatNum, movieJanre) values(seq_movie.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			//수정시 movieDate도 같이 수정(시스템 날짜에 맞춰 자동으로)
			String sql = "update movie set movieTitle=?, movieDirector=?, movieWriter=?, "
					+ "movietheatherPlace=?, movieTheaterNum=?, moviePeopleNum=?, "
					+ "movieSeatNum=?, movieJanre=?, movieDate=sysdate  where movieNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMovieTitle());
			pstmt.setString(2, vo.getMovieDirector());
			pstmt.setString(3, vo.getMovieWriter());
			pstmt.setString(4, vo.getMovietheatherPlace());
			pstmt.setString(5, vo.getMovieTheaterNum());
			pstmt.setString(6, vo.getMoviePeopleNum());
			pstmt.setString(7, vo.getMovieSeatNum());
			pstmt.setString(8, vo.getMovieJanre());
			pstmt.setInt(9, vo.getMovieNum());
			
			flag = pstmt.executeUpdate(); 
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public int delete(MovieVO vo) {
		System.out.println(" ----- delete() ------");
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "delete from movie where movieNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMovieNum());
			
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public MovieVO selectOne(MovieVO vo) {
		System.out.println(" ----- selectOne() ------");
		System.out.println("vo : " + vo);
		
		MovieVO vo2 = new MovieVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
		
			String sql = "select * from movie where movieNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMovieNum());
			rs = pstmt.executeQuery();
			//String sql ="insert into movie(movieNum, movieTitle, movieDirector, movieWriter, "
			//		+ "movietheatherPlace, movieTheaterNum, moviePeopleNum, "
			//		+ "movieSeatNum, movieJanre) values(seq_movie.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			while(rs.next()) {
				vo2.setMovieNum(rs.getInt("movieNum"));
				vo2.setMovieTitle(rs.getString("movieTitle"));
				vo2.setMovieDirector(rs.getString("movieDirector"));
				vo2.setMovieWriter(rs.getString("movieWriter"));
				vo2.setMovietheatherPlace(rs.getString("movietheatherPlace"));
				vo2.setMovieTheaterNum(rs.getString("movieTheaterNum"));
				vo2.setMoviePeopleNum(rs.getString("moviePeopleNum"));
				vo2.setMovieSeatNum(rs.getString("movieSeatNum"));
				vo2.setMovieJanre(rs.getString("movieJanre"));
				vo2.setMovieDate(rs.getDate("movieDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public List<MovieVO> selectAll() {
		System.out.println("---- selectAll() ----");
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "select * from movie order by movieNum asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setMovieNum(rs.getInt("movieNum"));
				vo.setMovieTitle(rs.getString("movieTitle"));
				vo.setMovieDirector(rs.getString("movieDirector"));
				vo.setMovieWriter(rs.getString("movieWriter"));
				vo.setMovietheatherPlace(rs.getString("movietheatherPlace"));
				vo.setMovieTheaterNum(rs.getString("movieTheaterNum"));
				vo.setMoviePeopleNum(rs.getString("moviePeopleNum"));
				vo.setMovieSeatNum(rs.getString("movieSeatNum"));
				vo.setMovieJanre(rs.getString("movieJanre"));
				vo.setMovieDate(rs.getDate("movieDate"));
				vo.setMovieFileName(rs.getString("movieFileName"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
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
	public List<MovieVO> searchList(String searchKey, String searchWord) {
		System.out.println(" ----- searchList() ------");
		System.out.println("searchKey : " + searchKey);
		System.out.println("searchWord : " + searchWord);
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "select * from movie where " + searchKey + " like ? order by movieNum asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo2 = new MovieVO();
				vo2.setMovieNum(rs.getInt("movieNum"));
				vo2.setMovieTitle(rs.getString("movieTitle"));
				vo2.setMovieDirector(rs.getString("movieDirector"));
				vo2.setMovieWriter(rs.getString("movieWriter"));
				vo2.setMovietheatherPlace(rs.getString("movietheatherPlace"));
				vo2.setMovieTheaterNum(rs.getString("movieTheaterNum"));
				vo2.setMoviePeopleNum(rs.getString("moviePeopleNum"));
				vo2.setMovieSeatNum(rs.getString("movieSeatNum"));
				vo2.setMovieJanre(rs.getString("movieJanre"));
				vo2.setMovieDate(rs.getDate("movieDate"));
				vo2.setMovieFileName(rs.getString("movieFileName"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
