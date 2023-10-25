package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print(" User name = "+request.getParameter("name") +" Pass Word = "+request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * TODO if name and pass is wrong, show the login page again with a message 
	 * if name is less than 4 chars, then add a message and show login page
	 * if pass is less than 8 chars, then add msg and go to login page 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//		super.doPost(request, response)
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		if("scott".equals(name) && "tiger".equals(pass)) {
			request.setAttribute("message", "Hi Scott, how have you been");
			request.getRequestDispatcher("LoginResults.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "That is not a valid user");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
//		request.getRequestDispatcher("LoginResults.jsp").forward(request, response);
		
		
//		Here these types of strings, we put the input is put on the left side so that .equals doesnt contain a null value when no input is given. When we do that
//		then equals(null value) will give error 500 and we will have to do exception handling
	}

}
