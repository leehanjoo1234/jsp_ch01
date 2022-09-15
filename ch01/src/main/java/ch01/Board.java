package ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Board 
 */
@WebServlet("/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.setCharacterEncoding("utf-8");
		String tittle =request.getParameter("tittle");
		String writer =request.getParameter("writer");
		String content =request.getParameter("content");
		Date now = new Date();
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");  //System.out.println();-> 콘솔로 이동.out.println() -> 화면으로 이동
		out.printf("<h1>게시판</h1>");
		out.printf("<p>제목 :  %s</p>",tittle);
		out.printf("<p>작성자 :  %s</p>",writer);
		out.printf("<p>작성일 :  %s</p>",now);
		out.printf("<p>내용 : <p>  %s</p>",content);
		out.println("</body></html>"); 
		out.close();
		
	}

}
