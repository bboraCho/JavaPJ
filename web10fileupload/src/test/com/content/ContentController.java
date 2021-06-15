package test.com.content;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContentController
 */
@WebServlet({"/c_selectAll.do", "/c_insert.do", "/c_insertOK.do", "/c_update.do", "/c_updateOK.do", "/c_deleteOK.do",
	"/c_selectOne.do", "/c_searchList.do"})
public class ContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentDAO dao = new ContentDAOimpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String sPath = request.getServletPath();
		System.out.println("sPath:" + sPath);
	
		if (sPath.equals("/c_insert.do")) {
			System.out.println("content/c_insert.jsp");

			// 이 부분이 있어야 로그인 안 될시 접근 막을 수 있다.
			String loginSession = (String) request.getSession().getAttribute("login");
			request.getSession().setMaxInactiveInterval(5000);
			System.out.println("loginSession : " + loginSession);
			if (loginSession == null || loginSession.equals("failed")) { // login 성공시
				response.sendRedirect("index.do");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("content/c_insert.jsp");
				rd.forward(request, response);
			}
		} 
		else if (sPath.equals("/c_insertOK.do")) {
			System.out.println(request.getParameter("contentTitle"));
			//System.out.println(request.getParameter("contentDirector"));
			System.out.println(request.getParameter("contentPoint"));
			System.out.println(request.getParameter("contentReview"));
			System.out.println(request.getParameter("contentPeopleName"));
			System.out.println(request.getParameter("contentRating"));
			System.out.println(request.getParameter("contentRecommend"));
			System.out.println(request.getParameter("contentSnack"));

			ContentVO vo = new ContentVO();
			vo.setContentTitle(request.getParameter("contentTitle"));
			//vo.setContentDirector(request.getParameter("contentDirector"));
			vo.setContentPoint(request.getParameter("contentPoint"));
			vo.setContentReview(request.getParameter("contentReview"));
			vo.setContentPeopleName(request.getParameter("contentPeopleName"));
			vo.setContentRating(Integer.parseInt(request.getParameter("contentRating")));
			vo.setContentRecommend(request.getParameter("contentRecommend"));
			vo.setContentSnack(request.getParameter("contentSnack"));

			int result = dao.insert(vo);
			System.out.println("insert result:" + result);

			if (result == 1)
				response.sendRedirect("c_selectAll.do");
			else
				response.sendRedirect("c_insert.do");

		}
		else if (sPath.equals("/c_selectAll.do")) {
			System.out.println("content/c_selectAll.jsp");

			String loginSession = (String) request.getSession().getAttribute("login");
			request.getSession().setMaxInactiveInterval(5000);
			System.out.println("loginSession : " + loginSession);
			if (loginSession == null || loginSession.equals("failed")) {
				response.sendRedirect("index.do");
			} else {
				List<ContentVO> list = dao.selectAll();
				for (ContentVO x : list) {
					System.out.println(x);
				}

				request.setAttribute("list", list);

				RequestDispatcher rd = request.getRequestDispatcher("content/c_selectAll.jsp");
				rd.forward(request, response);
			}
		}
		else if (sPath.equals("/c_searchList.do")) {
			System.out.println("content/c_selectAll.jsp");
			System.out.println("searchKey:" + request.getParameter("searchKey"));
			System.out.println("searchWord:" + request.getParameter("searchWord"));

			List<ContentVO> list = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));
			for (ContentVO x : list) {
				System.out.println(x);
			}

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("content/c_selectAll.jsp");
			rd.forward(request, response);
		}
		else if (sPath.equals("/c_selectOne.do")) {
			System.out.println("content/c_selectOne.jsp");
			System.out.println("contentNum :" + request.getParameter("contentNum"));

			ContentVO vo = new ContentVO();
			vo.setContentNum(Integer.parseInt(request.getParameter("contentNum")));

			ContentVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);

			String loginSession = (String) request.getSession().getAttribute("login");
			request.getSession().setMaxInactiveInterval(5000);
			System.out.println("loginSession : " + loginSession);
			if (loginSession == null || loginSession.equals("failed")) {
				response.sendRedirect("index.do");
			} else {
				request.setAttribute("vo2", vo2);

				RequestDispatcher rd = request.getRequestDispatcher("content/c_selectOne.jsp");
				rd.forward(request, response);
			}
		} 
		else if (sPath.equals("/c_update.do")) {
			System.out.println("content/c_update.jsp");

			System.out.println("contentNum:" + request.getParameter("contentNum"));

			ContentVO vo = new ContentVO();
			vo.setContentNum(Integer.parseInt(request.getParameter("contentNum")));

			ContentVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);

			request.setAttribute("vo2", vo2);

			RequestDispatcher rd = request.getRequestDispatcher("content/c_update.jsp");
			rd.forward(request, response);
		}
		 else if (sPath.equals("/c_updateOK.do")) {
				System.out.println(request.getParameter("contentNum"));
				System.out.println(request.getParameter("contentTitle"));
				//System.out.println(request.getParameter("contentDirector"));
				System.out.println(request.getParameter("contentPoint"));
				System.out.println(request.getParameter("contentReview"));
				System.out.println(request.getParameter("contentPeopleName"));
				System.out.println(request.getParameter("contentRating"));
				System.out.println(request.getParameter("contentRecommend"));
				System.out.println(request.getParameter("contentSnack"));

				ContentVO vo = new ContentVO();
				vo.setContentNum(Integer.parseInt(request.getParameter("contentNum")));
				vo.setContentTitle(request.getParameter("contentTitle"));
				//vo.setContentDirector(request.getParameter("contentDirector"));
				//vo.setContentDate(Integer.parseInt(request.getParameter("contentDate")));
				vo.setContentPoint(request.getParameter("contentPoint"));
				vo.setContentReview(request.getParameter("contentReview"));
				vo.setContentPeopleName(request.getParameter("contentPeopleName"));
				vo.setContentRating(Integer.parseInt(request.getParameter("contentRating")));
				vo.setContentRecommend(request.getParameter("contentRecommend"));
				vo.setContentSnack(request.getParameter("contentSnack"));

				int result = dao.update(vo);
				System.out.println("update result:" + result);

				if (result == 1) {
					response.sendRedirect("c_selectAll.do");
				}
				else {
					response.sendRedirect("c_selectOne.do?contentNum="+request.getParameter("contentNum"));
				}
		  	 }
				else if (sPath.equals("/c_deleteOK.do")) {
					System.out.println(request.getParameter("contentNum"));

					ContentVO vo = new ContentVO();
					vo.setContentNum(Integer.parseInt(request.getParameter("contentNum")));

					int result = dao.delete(vo);
					System.out.println("delete result:" + result);

					if (result == 1)
						response.sendRedirect("c_selectAll.do");
					else
						response.sendRedirect("c_selectOne.do?contentNum=" + request.getParameter("contentNum"));

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
