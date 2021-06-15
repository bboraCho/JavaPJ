package test.com.member;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//import test.com.member.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/index.do", "/m_selectAll.do", "/m_insert.do", "/m_insertOK.do", "/m_update.do", "/m_updateOK.do",
		"/m_deleteOK.do", "/m_selectOne.do", "/m_searchList.do", "/m_idCheck.do", "/m_loginOK.do", "/m_logout.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String sPath = request.getServletPath();
		// sPath 제대로 연결되는지 확인차
		System.out.println("sPath:" + sPath);

		if (sPath.equals("/index.do")) {
			System.out.println("----- index.jsp ----");
			// 원하는 페이지(sPath)로 이동시켜주고 싶을 때
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_insert.do")) {
			System.out.println("----- m_insert.do ----");

			RequestDispatcher rd = request.getRequestDispatcher("member/m_insert.jsp");
			rd.forward(request, response);
		} 
		else if (sPath.equals("/m_insertOK.do")) {
			System.out.println("----- m_insertOK.do ----");
//			//사진 넣는 부분
			String uploadPath = request.getServletContext().getRealPath("upload");
			System.out.println("uploadPath:" + uploadPath);

			int size = 10 * 1024 * 1024;

			MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();

			try {
				// 사진 업로드하는 방법
				MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8",
						new DefaultFileRenamePolicy());

				String name = multi.getParameter("name");
				String age = multi.getParameter("age");

				Enumeration files = multi.getFileNames();

				String pusa1 = (String) files.nextElement();
				System.out.println("pusa1:" + pusa1);
				String filename = multi.getFilesystemName(pusa1);
				System.out.println("filename:" + filename);
				
				vo.setMemberId(multi.getParameter("memberId"));
				vo.setMemberPw(multi.getParameter("memberPw"));
				vo.setMemberName(multi.getParameter("memberName"));
				vo.setMemberTel(multi.getParameter("memberTel"));
				vo.setMemberBday(multi.getParameter("memberBday"));
				vo.setMembership(multi.getParameter("membership"));
				vo.setMemberPoint(Integer.parseInt(multi.getParameter("memberPoint")));
				vo.setMemberNickname(multi.getParameter("memberNickname"));
				vo.setMemberGender(multi.getParameter("memberGender"));
				vo.setFilename(filename);
				int result = dao.insert(vo);

				if (result == 1) {
					response.sendRedirect("m_selectAll.do");
				} else {
					response.sendRedirect("m_insert.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // "/m_update.do" -> m_update.jsp, "/m_updateOK.do" -> update 작동 내용
		else if (sPath.equals("/m_selectAll.do")) {
			System.out.println(" ----m_selectAll.do --- ");
			// public List<MemberVO> selectAll();
			// MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();

			// 로그인 안 될시 페이지 접근 안되도록 하는 로직
			String loginSession = (String) request.getSession().getAttribute("login");
			request.getSession().setMaxInactiveInterval(5000);
			System.out.println("loginSession : " + loginSession); // session은 java 내부 객체
			if (loginSession == null || loginSession.equals("failed")) {
				response.sendRedirect("index.do"); // index.do 페이지로 바로 이동
			} else {
				List<MemberVO> list = dao.selectAll();
				for (MemberVO x : list) {
					System.out.println(x);
				}

				request.setAttribute("list", list);

				RequestDispatcher rd = request.getRequestDispatcher("member/m_selectAll.jsp");
				rd.forward(request, response);
			}
		} else if (sPath.equals("/m_selectOne.do")) {
			System.out.println(" ----- m_selectOne.do -----");

			// selectOne - 1개 고르기 -> 1개 고를 행 번호 선택
			MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();
			vo.setMemberNum(Integer.parseInt(request.getParameter("memberNum")));

			MemberVO vo2 = dao.selectOne(vo);

			request.setAttribute("vo2", vo2);

			// 로그인 안 될시 다른 곳에 접근 못하게 막는 로직! (딱 if문까지만)
			String loginSession = (String) request.getSession().getAttribute("login");
			request.getSession().setMaxInactiveInterval(5000);
			System.out.println("loginSession : " + loginSession);
			if (loginSession == null || loginSession.equals("failed")) { // 로그인 실패시 로직 작성
				response.sendRedirect("index.do");
			} else {// 로그인 성공시
				RequestDispatcher rd = request.getRequestDispatcher("member/m_selectOne.jsp");
				rd.forward(request, response);
			}
		} else if (sPath.equals("/m_searchList.do")) {
			System.out.println(" ---- m_searchList.do -------");
			// 번호 1개 선택해서 그거 값 출력

			MemberDAO dao = new MemberDAOimpl();

			// String searchKey, String searchWord
			List<MemberVO> list = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));
			for (MemberVO x : list) {
				System.out.println(x);
			}

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("member/m_selectAll.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_update.do")) {
			// 여기선 삭제할 행 번호 1개를 선택하는 로직만.
			System.out.println("----- m_update.do ----");

			MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();
			vo.setMemberNum(Integer.parseInt(request.getParameter("memberNum")));

			MemberVO vo2 = dao.selectOne(vo);

			request.setAttribute("vo2", vo2);

			RequestDispatcher rd = request.getRequestDispatcher("member/m_update.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_updateOK.do")) {
			System.out.println("----- m_update.do ----");
			// 객체 1개 선택 dao.update해주기 .update가 수정하는 함수니까.
			MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();

			vo.setMemberNum(Integer.parseInt(request.getParameter("memberNum")));
			vo.setMemberId(request.getParameter("memberId"));
			vo.setMemberPw(request.getParameter("memberPw"));
			vo.setMemberName(request.getParameter("memberName"));
			vo.setMemberTel(request.getParameter("memberTel"));
			vo.setMemberBday(request.getParameter("memberBday"));
			vo.setMembership(request.getParameter("membership"));
			vo.setMemberPoint(Integer.parseInt(request.getParameter("memberPoint")));
			vo.setMemberNickname(request.getParameter("memberNickname"));
			vo.setMemberGender(request.getParameter("memberGender"));

			int result = dao.update(vo);
			System.out.println("update result : " + result);

			if (result == 1) { // 성공
				response.sendRedirect("m_selectAll.do");
			} else { // 실패
				response.sendRedirect("m_selectOne.do?memberNum=" + request.getParameter("memberNum"));
			}

			
		} else if (sPath.equals("/m_deleteOK.do")) {
			System.out.println("----------- /m_deleteOK.do ------- ");

			MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();

			vo.setMemberNum(Integer.parseInt(request.getParameter("memberNum")));

			int result = dao.delete(vo);
			System.out.println("delete result : " + result);

			if (result == 1) { // 성공
				response.sendRedirect("m_selectAll.do");
			} else { // 실패
				response.sendRedirect("m_selectOne.do?num=" + request.getParameter("memberNum"));
			}

		} else if (sPath.equals("/m_loginOK.do")) {
			System.out.println(request.getParameter("memberId"));
			System.out.println(request.getParameter("memberPw"));
			// private String memberId;
			// private String memberPw;

			MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();
			vo.setMemberId(request.getParameter("memberId"));
			vo.setMemberPw(request.getParameter("memberPw"));

			String result = dao.loginOK(vo); // result = successed / failed로 나올 것.

			if (result.equals("successed")) {
				request.getSession().setAttribute("login", result); // login = successed / failed
				request.getSession().setAttribute("userID", vo.getMemberId());
				// 합칠 때 여기다 등급도 추가할 수 있지 않을까...?
				// request.getSession().setAttribute("membershipClass", vo.getMembership());
				request.getSession().setMaxInactiveInterval(5000);
				System.out.println(request.getSession().getMaxInactiveInterval());
			}
			request.getSession().setAttribute("login", result); // <- 이걸 붙여줘야 failed를 화면에 출력할 수 있다.
			response.sendRedirect("index.do");
		} else if (sPath.equals("/m_logout.do")) {

			request.getSession().invalidate(); // 모든 세션 제거 => 모든세션 제거해 로그아웃 => 회원목록안뜸
			response.sendRedirect("index.do");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
