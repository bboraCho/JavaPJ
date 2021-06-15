package test.com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO{

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "pro";
	private final String PASSWORD = "1234"; 
	//table name : member10
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public MemberDAOimpl() {
		try {
			Class.forName(DRIVER_NAME); //driver 이름 로드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	
	@Override
	public int insert(MemberVO vo) {
		System.out.println(" ------- MemberDAOimpl의 insert() ----------");
		System.out.println(vo);
		int flag = 0;
		
		try {
			//1.
			conn=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connect successed! ");
			//2.
			String sql ="insert into member10(memberNum, memberId, memberPw, memberName, "
					+ "memberTel, memberBday, membership, memberPoint, memberNickname, "
					+ "memberGender ,filename) "
					+ "values (seq_member10.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//3.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getMemberTel());
			pstmt.setString(5, vo.getMemberBday());
			pstmt.setString(6, vo.getMembership());
			pstmt.setInt(7, vo.getMemberPoint());
			pstmt.setString(8, vo.getMemberNickname());
			pstmt.setString(9, vo.getMemberGender());
			pstmt.setString(10, vo.getFilename());
			
			flag = pstmt.executeUpdate(); //sql문 실행(insert, delete, update)
			
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
	public int update(MemberVO vo) {
		System.out.println(" ----- update() ------");
		System.out.println("vo : " + vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "update member10 set memberId=?, memberPw=?, memberName=?, memberTel=?,"
					+ " memberBday=?, membership=?, memberPoint=?, memberNickname=?, memberGender=? where memberNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getMemberTel());
			pstmt.setString(5, vo.getMemberBday());
			pstmt.setString(6, vo.getMembership());
			pstmt.setInt(7, vo.getMemberPoint());
			pstmt.setString(8, vo.getMemberNickname());
			pstmt.setString(9, vo.getMemberGender());
			pstmt.setInt(10, vo.getMemberNum());
			
			flag = pstmt.executeUpdate(); //sql문 실행(insert, delete, update)
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
	public int delete(MemberVO vo) {
		System.out.println(" ----- delete() ------");
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "delete from member10 where memberNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMemberNum());
			
			flag = pstmt.executeUpdate(); //sql문 실행(insert, delete, update)
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
	public MemberVO selectOne(MemberVO vo) {
		System.out.println(" ----- selectOne() ------");
		System.out.println("vo : " + vo);
		
		MemberVO vo2 = new MemberVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "select * from member10 where memberNum=?";
			pstmt = conn.prepareStatement(sql);
			
			//selectOne : 1개만 가져오는 거니까 번호로 해당 행 가져온다.
			pstmt.setInt(1, vo.getMemberNum());
			rs = pstmt.executeQuery(); //받은 sql문 실행
			while(rs.next()) {
				vo2.setMemberNum(rs.getInt("memberNum"));
				vo2.setMemberId(rs.getString("memberId"));
				vo2.setMemberPw(rs.getString("memberPw"));
				vo2.setMemberName(rs.getString("memberName"));
				vo2.setMemberTel(rs.getString("memberTel"));
				vo2.setMemberBday(rs.getString("memberBday"));
				vo2.setMembership(rs.getString("membership"));
				vo2.setMemberPoint(rs.getInt("memberPoint"));
				vo2.setMemberNickname(rs.getString("memberNickname"));
				vo2.setMemberGender(rs.getString("memberGender"));
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
	public List<MemberVO> selectAll() {
		System.out.println("---- selectAll() ----");
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "select * from member10 order by memberNum asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemberNum(rs.getInt("memberNum"));
				vo.setMemberId(rs.getString("memberId"));
				vo.setMemberPw(rs.getString("memberPw"));
				vo.setMemberName(rs.getString("memberName"));
				vo.setMemberTel(rs.getString("memberTel"));
				vo.setMemberBday(rs.getString("memberBday"));
				vo.setMembership(rs.getString("membership"));
				vo.setMemberPoint(rs.getInt("memberPoint"));
				vo.setMemberNickname(rs.getString("memberNickname"));
				vo.setMemberGender(rs.getString("memberGender"));
				vo.setFilename(rs.getString("filename"));
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
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		System.out.println(" ----- searchList() ------");
		System.out.println("searchKey : " + searchKey);
		System.out.println("searchWord : " + searchWord);
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "select * from member10 where " + searchKey + " like ? order by memberNum asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo2 = new MemberVO();
				vo2.setMemberNum(rs.getInt("memberNum"));
				vo2.setMemberId(rs.getString("memberId"));
				vo2.setMemberPw(rs.getString("memberPw"));
				vo2.setMemberName(rs.getString("memberName"));
				vo2.setMemberTel(rs.getString("memberTel"));
				vo2.setMemberBday(rs.getString("memberBday"));
				vo2.setMembership(rs.getString("membership"));
				vo2.setMemberPoint(rs.getInt("memberPoint"));
				vo2.setMemberNickname(rs.getString("memberNickname"));
				vo2.setMemberGender(rs.getString("memberGender"));
				vo2.setFilename(rs.getString("filename"));
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



	@Override
	//해당 id가 있는지 확인 - successed / failed 체크해주는 메소드
	public String idCheck(MemberVO vo) {
		System.out.println(" ---- idCheck() ----");
		System.out.println("vo : " + vo);
		
		String result = "OK";
		
		//id 없으면 "Not OK"
		if(vo.getMemberId().trim().length()==0)
			return "Not OK";
		
		//id 있으면 
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			
			String sql = "select * from member10 where memberId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = "Not OK";
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
		return result;
	}



	@Override
	public String loginOK(MemberVO vo) {
		System.out.println(" ---- loginOK ----");
		System.out.println("parameter로 vo 들어온다 : " + vo);
		
		String result ="failed";
		
		//id, pw의 공백 없는 길이가 0이면 실패!
		if(vo.getMemberId().trim().length()==0 || vo.getMemberPw().trim().length()==0) return "failed";
				
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			//private String memberId;
			//private String memberPw;
			String sql ="select * from member10 where memberId=? and memberPw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			
			rs = pstmt.executeQuery(); //sql select문이라 사용
			while(rs.next()) { // 로그인 성공할 경우 - while문이 돌아가면 id,pw 존재한다.
				result = "successed";
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
		return result;
	}
	
	
}
