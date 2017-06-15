
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public LogOut() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//response.setContentType("text/html");
				//PrintWriter out = response.getWriter();
				//out.println("thank you!!, Your session was destroyed successfully!!");
		
				HttpSession session = request.getSession(false);
						
		 		session.setAttribute("id_client","id_client");
				session.removeAttribute("id_client");
				session.getMaxInactiveInterval();
				
				request.getSession().invalidate();
				 response.sendRedirect("logOut.jsp");
	}

}
