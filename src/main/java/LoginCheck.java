

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCheck() {
        super();    
    }
	Connection con;
	PreparedStatement pst = null;
 	ResultSet rs = null;

		 // response.getWriter().append("Served at: ").append(request.getContextPath());   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        	
	         String username = request.getParameter("username");
       		 String senha = request.getParameter("senha");     		      
            		
    			  try {
					con = CriarConexao.getConexao();
					  pst = con.prepareStatement("SELECT * FROM clientes WHERE username = ? AND senha = ?");
	    		      pst.setString(1, username);
    		          pst.setString(2, senha);
    		        rs=pst.executeQuery();   		
    		          		     
    	                     if(rs.next()) {
    			                     System.out.print("--COMPAROU O Username E Senha ");
    			                     HttpSession session = request.getSession();
    				                    session.setAttribute("id_client", rs.getString("id_client"));
    				                    session.setAttribute("firstname", rs.getString("firstname"));
    				                    session.setAttribute("lastname", rs.getString("lastname"));
    				                    session.setAttribute("username", username);
    				                       request.getSession().setAttribute("id_client", rs.getString("id_client"));
    									   request.getSession().setAttribute("firstname", rs.getString("firstname"));
    									   request.getSession().setAttribute("lastname", rs.getString("lastname"));
    			    		               request.getSession().setAttribute("username", username);
    			    		                 			    		               
    			    		               RequestDispatcher rd = request.getRequestDispatcher("logado.jsp");
    			    		          	    rd.forward(request, response);  
    	                                  }
    	                                   else {
	    	                                System.out.print("----NAO NAO ENTROU NO DATABASE------");
	                                        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
   		                                    rd.forward(request, response); 
	                                            }       
    		                           con.close();
    		       	
  				                         } catch (SQLException e) {
  					                                 System.out.print("--PROBLEMA NO SEGUNDO CATCH--"+ e);   
  				                                                   } finally { }
       	  
	}
}
    			  
					           
	
	
