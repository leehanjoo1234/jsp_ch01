package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; //상속
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목표  : 1부터 누적값 전달 // request는 모두 문자로 받아줌. 숫자일지라도 받아올떄는 문자
		int num = Integer.parseInt(request.getParameter("num"));
		String loc =request.getParameter("loc");
		System.out.println("Add3 num->"+num);
		int sum = 0;
		for (int i=1; i<=num; i++) {
			sum +=i;
		}
		
		
		request.setCharacterEncoding("utf-8"); /* parmeta 넘어 왔을때 애초에 안깨지게..post 방식일떄 */
		response.setContentType("text/html;charset=utf-8"); /* 화면에 보여줬을때 한글이 안깨지게 하려구 */
		// 공식 -->사용자 Browser에 보여주는 객체
		// 결과 값을 보여줄때 response 객체에 담아서 보여짐
		PrintWriter out = response.getWriter();
		out.println("<html><body>");  //System.out.println();-> 콘솔로 이동.out.println() -> 화면으로 이동
		out.printf("<h1>1부터 %d까지 합계</h1>",num);
		out.printf("<h4>Loc---> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("doPost 시작  ");
		doGet(request, response);
		//     요청       응답
	}

}
