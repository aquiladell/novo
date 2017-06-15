

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/Historical")
public class Historical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Historical() {
        super();
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_client = null;
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String senha = request.getParameter("senha");
		String inicialdeposit = request.getParameter("inicialdeposit");
		
		String conta_type = request.getParameter("conta_type");
		String deposito = request.getParameter("deposito");
		String sacar = request.getParameter("sacar");
		String balanco = request.getParameter("balanco");

		HttpSession session = request.getSession(true);
 		session.setAttribute("fisrtname", firstname);
 		
 		
		Connection con = null;
		
			try {
				con = CriarConexao.getConexao();
			} catch (SQLException e) {
				System.out.print("--NAO PEGOU CONEXAO--"+ e);
			
			  Login l1 = new Login();
			
			  l1.setfirstname(firstname);
			  l1.setlastname(lastname);
			  l1.setaddress(address);
			  l1.setusername(username);
			  l1.setsenha(senha);
			  l1.setinicialdeposit(inicialdeposit);
			  
			  l1.setconta_type(conta_type);
			  l1.setdeposito(deposito);
			  l1.setsacar(sacar);
			  l1.setbalanco(balanco);	  
			  
		      } finally {		    
			}	
				
			try {
				
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO clientes(firstname,lastname,address,username,senha,inicialdeposit)values(?,?,?,?,?,?)");
			
				stmt.setString(1, firstname);
				stmt.setString(2, lastname);
				stmt.setString(3, address);
				stmt.setString(4, username);
				stmt.setString(5, senha);
				stmt.setString(6, inicialdeposit);	
				stmt.execute();
			    stmt.close();
			    
			    System.out.print("-- PEGOU TUDO DO PRIMEIRO--");

			    
				PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("INSERT INTO trans(id_client,conta_type,deposito,sacar,balanco) values(?,?,?,?,?)"); 
			
				 stmt1.setString(1, id_client);
				  stmt1.setString(2, conta_type);
				  stmt1.setString(3, deposito);
				  stmt1.setString(4, sacar);
				  stmt1.setString(5, balanco);
				  stmt1.execute();
				  stmt1.close();
				  
				  System.out.print("-- PEGOU TUDO DO SEGUNDO--");
			/*	  
               PreparedStatement stmt3 = (PreparedStatement) con.prepareStatement("SELECT id_client FROM client"); 
              
				 
				stmt3.setString(1, id_client);
				//  stmt2.setString(2, deposito);
				//  stmt2.setString(3, sacar);
				//  stmt2.setString(4, balanco);
				 System.out.print("-- PEGOU O  ID_CLIENT--"+id_client);
				  stmt3.execute();
				 // stmt3.close(); 
				  System.out.print("-- PEGOU TODO  ID_CLIENT  DEU CERTO --"+id_client);
				  
				  PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("INSERT INTO trans(id_client) values(SELECT(id_client FROM client)"); 
				// PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("INSERT INTO trans(id_client) values(?)"); 
				   
				  System.out.print("-- COLOCANDO NO DATABASE O  ID_CLIENT--"+id_client);
				stmt2.setString(1, id_client);
				//  stmt2.setString(2, deposito);
				//  stmt2.setString(3, sacar);
				//  stmt2.setString(4, balanco);
				  stmt2.execute();
				  stmt2.close();
				 */
				  System.out.print("-- PEGOU O  ID_CLIENT--"+id_client);
			  
			      }  catch (SQLException e) {
			    	  System.out.print("--NNNNAAAAOOOO PEGOU ESTA NO CATCH DO SEGUNDO--"+ e);
			    	  
			    	  RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			     		rd.forward(request, response); 
			   
			      } finally {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("--FECHOU COM PROBLEMA--"+ e);
					e.printStackTrace();
				}    
				}
			System.out.print("----FOI CADASTRADO------");
			
			 System.out.println("Name is: "+ firstname);
	         System.out.println("Senha is: "+ lastname);
	         System.out.println("Balanco is: "+ balanco);
	        // System.out.println("IP is: "+ userip);
	         
	       request.getSession().setAttribute("firstname", firstname);      
	       request.getSession().setAttribute("lastname", lastname); 
	       request.getSession().setAttribute("balanco",balanco); 
	     //  request.getSession().setAttribute("userip",userip); 
	       
	       response.sendRedirect("logado.jsp");
	
			
			/*
		    RequestDispatcher rd = request.getRequestDispatcher("logado.jsp");
	   		rd.forward(request, response);  */
				System.out.print(" CERRTOOOOOOOOOO");	  
		      }  
	}
