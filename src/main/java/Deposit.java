

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Deposit() {
        super();
    }
    Connection con;
	PreparedStatement pst = null;
 	ResultSet rs = null;
 	String id=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_client = null;
		String id = request.getParameter("id");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String senha = request.getParameter("senha");
		
		
		//String conta_type = request.getParameter("conta_type");
		String deposito = request.getParameter("deposito");
		String balanco = request.getParameter("balanco");
		

		HttpSession session = request.getSession(true);
 		session.setAttribute("username", username);
 		session.setAttribute("senha", senha);
 		System.out.print("--PEGOU o 1 ID id --"+ id);
		//Connection con = null;
		
			      try {
				       con = CriarConexao.getConexao();
			           } catch (SQLException e) {
				                     System.out.print("--NAO PEGOU CONEXAO--"+ e);
			                          }
			  
			  System.out.print("--PEGOU o 2 ID id --"+ id);
		      	
			      try {  
	               PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("SELECT * FROM trans "); 
	               System.out.print("--PEGOU o 3ID id --"+ id);
				rs = stmt2.executeQuery();
		          
				System.out.print("--PEGOU o 4 ID id --"+ id);
		        /*  Login l = new Login();
				  l.getid_client();
				  l.getfirstname();
				  l.getlastname();
				  l.getdeposito();
				  l.getbalanco();
		          */
		                 }  catch (SQLException e) {
				    	              System.out.print("-- ESTA NO CATCH PRIMEIRO TRY CATCH--"+ e);	   
				                                            } 
			      System.out.print("--PEGOU o 5 ID id --"+ id);
		                 	try {
		          System.out.print("--PEGOU o 6 ID id --"+ id);    
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO trans(id_client, deposito, balanco) values(?,?,?)"); 
			    
				 stmt.setString(1, id);
				  stmt.setString(2, deposito);
				  stmt.setString(3, balanco);
				  stmt.execute();
				  stmt.close();
				  
				  System.out.print("--PEGOU PRA INSERT o ID --"+ id);
				   
		
				con.close();
				} catch (SQLException e) {
					System.out.print("--PROBLEMA NO SEGUNDO CATCH--"+ e);   
				} finally {
					  System.out.print("--PEGOU TUDO E COLOCOU NO DATABASE fist,deposi,balanco --"+ id_client +firstname+deposito+balanco);
					   
			 System.out.println("ID CLIENTE is: "+ id);
			 System.out.println("Name is: "+ firstname);
	         System.out.println("Deposit is: "+ deposito);
	         System.out.println("Balanco is: "+ balanco);
	       request.getSession().setAttribute("id", id); 
	       request.getSession().setAttribute("firstname", firstname);       
	       request.getSession().setAttribute("deposit",deposito); 
	       request.getSession().setAttribute("balanco",balanco); 
	       
	       response.sendRedirect("depositResult.jsp");
	
				System.out.print(" DEUUUUU  CERRTOOOOOOOOOO");	  
		      }  
	}
}  