

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/Sacar")
public class Sacar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public Sacar() {
        super();
        }

  	Connection con = null;
  	PreparedStatement pst = null;
   	ResultSet rs = null;
    float som = 0 ;
  		 // response.getWriter().append("Served at: ").append(request.getContextPath());
         
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        		String balanco = null;
        		
  	            
        		String sacar = request.getParameter("sacar");     
        		//String balanco = request.getParameter("balanco"); 
        		
         		//HttpSession session = request.getSession(true);
          		//session.setAttribute("username", username);	
      
      		try {
      			con = CriarConexao.getConexao();
      		
          		System.out.print("---depois EXECUTEQUERY---- "+ sacar + balanco);
          		//PreparedStatement pst1 = (PreparedStatement) con.prepareStatement("INSERT INTO trans(sacar) values(?)WHERE id_client='2'"); 
          		PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO trans(sacar) values(?)");
				  pst.setString(1, sacar);
				  pst.execute();
				
      			System.out.print("----INSERT INTO SACAR VALOR:--- "+ sacar);
      			
      			//String sql = "SELECT username, senha FROM essecliente WHERE username = ? AND senha = ?";	
      		     
        	
        	    System.out.print("----depois vai selicionar o sacar e balanco--- "+ sacar + balanco );
        		pst = (PreparedStatement) con.prepareStatement("SELECT balanco FROM trans");
        		//pst.setString(1, sacar);
        		pst.setString(1, rs.getString(balanco));
       
        		rs=pst.executeQuery();
        		
        		System.out.print("---fez EXECUTEQUERY---- "+ sacar + balanco);
        			
  	                              som = rs.getFloat("sacar")  - rs.getFloat("balanco");
  	  
  	   // System.out.println("Name is: "+ firstname);
        
                                   System.out.println("Sacar is: "+ sacar);
                                   System.out.println("Balanco is: "+ balanco); 
                                   System.out.println("Balanco NOW is: "+ som); 
      //  request.getSession().setAttribute("firstname", firstname);      
      
                                    request.getSession().setAttribute("sacar", sacar);
                                    request.getSession().setAttribute("balanco",balanco); 
                                    request.getSession().setAttribute("som",som); 
                                    System.out.print("----FOI CONFIRMADO E PODE SACAR O VALOR E'MENOR DO BALANCO------"+ sacar + balanco + som);
                                    response.sendRedirect("sacarResult.jsp");
     		
  	    	
  	                               
  	    	                     // System.out.print("----NAO TEM O VALOR SUFUCIENTE E NAO ENTROU NO DATABASE------"+ sacar + balanco);
  	                             // RequestDispatcher rd = request.getRequestDispatcher("insuficiente.jsp");
     		                     // rd.forward(request, response); 		 
  	     
  		                          // rs.close();
  	                            // }
  	                             }catch (SQLException e) {
  		                         System.out.print("----TA NO PRIMEIRO CATCH DEU ERRADO------"+ e);
  		
  	   		
  	                            } finally {
  		                  }
      		System.out.print("----DEU CERTO E SAIU DO DATABASE------");
          }	
    } 
		
