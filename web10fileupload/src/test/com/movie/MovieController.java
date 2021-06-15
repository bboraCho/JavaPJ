package test.com.movie;

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

/**
 * Servlet implementation class MovieController
 */
@WebServlet({"/mv_selectAll.do", "/mv_insert.do", "/mv_insertOK.do", "/mv_update.do", "/mv_updateOK.do", "/mv_deleteOK.do",
	"/mv_selectOne.do", "/mv_searchList.do"})
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDAO dao = new MovieDAOimpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String sPath = request.getServletPath();
		System.out.println("sPath:" + sPath);
		
		
		if (sPath.equals("/mv_insert.do")) {
			System.out.println("movie/mv_insert.jsp");
			
			//이 부분이 있어야 로그인 안 될시 접근 막을 수 있다.
			String loginSession = (String) request.getSession().getAttribute("login");
			request.getSession().setMaxInactiveInterval(5000);
			System.out.println("loginSession : " + loginSession);
			if (loginSession == null || loginSession.equals("failed")) { // login 성공시
				response.sendRedirect("index.do");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("movie/mv_insert.jsp");
				rd.forward(request, response);
			}
		} 
		else if (sPath.equals("/mv_insertOK.do")) {
			// 각각의 내용이 무엇인지 확인차
			System.out.println(request.getParameter("movieTitle"));
			System.out.println(request.getParameter("movieDirector"));
			System.out.println(request.getParameter("movieWriter"));
			System.out.println(request.getParameter("movietheatherPlace"));
			System.out.println(request.getParameter("movieTheaterNum"));
			System.out.println(request.getParameter("moviePeopleNum"));
			System.out.println(request.getParameter("movieSeatNum"));
			System.out.println(request.getParameter("movieJanre"));
			
			//사진 삽입
			String uploadPath = request.getServletContext().getRealPath("upload");
			System.out.println("uploadPath:" + uploadPath);

			int size = 10 * 1024 * 1024;
			
			MovieVO vo = new MovieVO();

			try {
				// 사진 업로드하는 방법
				MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8",
						new DefaultFileRenamePolicy());

				String name = multi.getParameter("name");
				String age = multi.getParameter("age");

				Enumeration files = multi.getFileNames();

				String pusa1 = (String) files.nextElement();
				System.out.println("pusa1:" + pusa1);
				String movieFileName = multi.getFilesystemName(pusa1);
				System.out.println("movieFileName:" + movieFileName);

				vo.setMovieTitle(multi.getParameter("movieTitle"));
				vo.setMovieDirector(multi.getParameter("movieDirector"));
				vo.setMovieWriter(multi.getParameter("movieWriter"));
				vo.setMovietheatherPlace(multi.getParameter("movietheatherPlace"));
				vo.setMovieTheaterNum(multi.getParameter("movieTheaterNum"));
				vo.setMoviePeopleNum(multi.getParameter("moviePeopleNum"));
				vo.setMovieSeatNum(multi.getParameter("movieSeatNum"));
				vo.setMovieJanre(multi.getParameter("movieJanre"));
				vo.setMovieFileName(movieFileName);
				
				int result = dao.insert(vo);
				System.out.println("insert result:" + result);

				if (result == 1) {
					response.sendRedirect("mv_selectAll.do");
				} else {
					response.sendRedirect("mv_insert.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (sPath.equals("/mv_selectAll.do")) {
			System.out.println("movieController/mv_selectAll.jsp");

			// 이 부분이 있어야 로그인 안 될시 접근 막을 수 있다.
			String loginSession = (String) request.getSession().getAttribute("login");
			request.getSession().setMaxInactiveInterval(5000);
			System.out.println("loginSession : " + loginSession);
			if (loginSession == null || loginSession.equals("failed")) { // login 성공시
				response.sendRedirect("index.do");
			} else {
				List<MovieVO> list = dao.selectAll();
				for (MovieVO x : list) {
					System.out.println(x);
				}

				request.setAttribute("list", list);

				RequestDispatcher rd = request.getRequestDispatcher("movie/mv_selectAll.jsp");
				rd.forward(request, response);
			}
		}
		 else if (sPath.equals("/mv_searchList.do")) {
			System.out.println("movie/mv_selectAll.jsp");
			System.out.println("searchKey:" + request.getParameter("searchKey"));
			System.out.println("searchWord:" + request.getParameter("searchWord"));

			List<MovieVO> list = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));
			for (MovieVO x : list) {
				System.out.println(x);
			}

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("movie/mv_selectAll.jsp");
			rd.forward(request, response);
		}
		  else if (sPath.equals("/mv_selectOne.do")) {
			System.out.println("movie/mv_selectOne.jsp");
			System.out.println("movieNum:" + request.getParameter("movieNum"));

			MovieVO vo = new MovieVO();
			vo.setMovieNum(Integer.parseInt(request.getParameter("movieNum")));

			MovieVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);

			String loginSession = (String) request.getSession().getAttribute("login");
			request.getSession().setMaxInactiveInterval(5000);
			System.out.println("loginSession : " + loginSession);
			if (loginSession == null || loginSession.equals("failed")) {
				response.sendRedirect("index.do");
			} else {
				request.setAttribute("vo2", vo2);

				RequestDispatcher rd = request.getRequestDispatcher("movie/mv_selectOne.jsp");
				rd.forward(request, response);
			}
		} 
		  else if (sPath.equals("/mv_update.do")) {
				System.out.println("movie/mv_update.jsp");

				System.out.println("movieNum:" + request.getParameter("movieNum"));
				
				MovieVO vo = new MovieVO();
				vo.setMovieNum(Integer.parseInt(request.getParameter("movieNum")));

				MovieVO vo2 = dao.selectOne(vo);
				System.out.println(vo2);

				request.setAttribute("vo2", vo2);

				RequestDispatcher rd = request.getRequestDispatcher("movie/mv_update.jsp");
				rd.forward(request, response);
			}
		  	 else if (sPath.equals("/mv_updateOK.do")) {
				System.out.println(request.getParameter("movieNum"));
				System.out.println(request.getParameter("movieTitle"));
				System.out.println(request.getParameter("movieDirector"));
				System.out.println(request.getParameter("movieWriter"));
				System.out.println(request.getParameter("movietheatherPlace"));
				System.out.println(request.getParameter("movieTheaterNum"));
				System.out.println(request.getParameter("moviePeopleNum"));
				System.out.println(request.getParameter("movieSeatNum"));
				System.out.println(request.getParameter("movieJanre"));

				MovieVO vo = new MovieVO();
				vo.setMovieNum(Integer.parseInt(request.getParameter("movieNum")));
				vo.setMovieTitle(request.getParameter("movieTitle"));
				vo.setMovieDirector(request.getParameter("movieDirector"));
				vo.setMovieWriter(request.getParameter("movieWriter"));
				vo.setMovietheatherPlace(request.getParameter("movietheatherPlace"));
				vo.setMovieTheaterNum(request.getParameter("movieTheaterNum"));
				vo.setMoviePeopleNum(request.getParameter("moviePeopleNum"));
				vo.setMovieSeatNum(request.getParameter("movieSeatNum"));
				vo.setMovieJanre(request.getParameter("movieJanre"));

				int result = dao.update(vo);
				System.out.println("update result:" + result);

				if (result == 1)
					response.sendRedirect("mv_selectAll.do");
				else
					response.sendRedirect("mv_selectOne.do?movieNum="+request.getParameter("movieNum"));

		  	 }
				else if (sPath.equals("/mv_deleteOK.do")) {
					System.out.println(request.getParameter("movieNum"));

					MovieVO vo = new MovieVO();
					vo.setMovieNum(Integer.parseInt(request.getParameter("movieNum")));

					int result = dao.delete(vo);
					System.out.println("delete result:" + result);

					if (result == 1)
						response.sendRedirect("mv_selectAll.do");
					else
						response.sendRedirect("mv_selectOne.do?movieNum=" + request.getParameter("movieNum"));

				}
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
