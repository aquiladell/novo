

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

@WebServlet("/Cadastar")

public class Cadastar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Cadastar() {
        super();
    }
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id_client = null;
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String senha = request.getParameter("senha");
		String inicialdeposit = request.getParameter("inicialdeposit");
		
		String conta_type = request.getParameter("conta_type");
		String deposito = request.getParameter("deposito");
		String sacar = request.getParameter("sacar");
		String balanco = request.getParameter("balanco");  
				
			try {
				con = CriarConexao.getConexao();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO clientes(firstname,lastname,address,email,username,senha,inicialdeposit)values(?,?,?,?,?,?,?)");
				pst.setString(1, firstname);
				pst.setString(2, lastname);
				pst.setString(3, address);
				pst.setString(4, email);
				pst.setString(5, username);
				pst.setString(6, senha);
				pst.setString(7, inicialdeposit);	
				pst.execute();
			//	pst.close();   
			    
			    System.out.print("-- PEGOU TUDO DO PRIMEIRO--");  
			    PreparedStatement pst4 = (PreparedStatement) con.prepareStatement(
			   "INSERT INTO trans(SELECT id_client FROM clientes WHERE id_client= LAST_INSERT_ID(id_client+1))"); 
			    pst4.setString(1, id_client);  
			    pst4.execute();  
			    System.out.print("-- PEGOU O ID--"+id_client); 
			    
			    PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(
				 "INSERT INTO trans(id_client,conta_type,deposito,sacar,balanco)VALUES(?,?,?,?,?) AND UPDATE trans SET id_client WHERE id_client = id_client"); 
				System.out.print("-- ENTROU NA SEGUNDA TABELA--");
				pst2.setString(1, id_client);
				pst2.setString(2, conta_type);
				pst2.setString(3, deposito);
				pst2.setString(4, sacar);
				pst2.setString(5, balanco);	
				System.out.print("-- VAI COMPLETAR A SEGUNDA TABELA--");
				pst2.execute();  
				//pst2.close();
				  
				  System.out.print("-- PEGOU TUDO DO SEGUNDO--"); 
			/*	  
			 PreparedStatement pst4 = (PreparedStatement) con.prepareStatement(
			
				    		// "INSERT INTO trans(id_client)SELECT id_client FROM clientes ON DUPLICATE KEY UPDATE id_client= clientes.id_client");
						//"INSERT INTO trans(id_client)SELECT id_client FROM clientes ON DUPLICATE KEY UPDATE id_client= LAST_INSERT_ID(id_client+1)");
			  
					      //"UPDATE trans SET id_client=LAST_INSERT_ID()"); //DER CERTO MAIS TROCOU TODOS
						//"INSERT INTO trans(id_client)SELECT id_client FROM clientes ON DUPLICATE KEY UPDATE id_client=LAST_INSERT_ID(id_client+1)");
				    //  pst4.setString(1, id_client);
			        System.out.print("--1 ID_CLIENT--"+id_client); 
				     //pst4.executeUpdate();
				     pst4.execute();
				   System.out.print("--2 ID_CLIENT--"+id_client); */
				    
				    HttpSession session = request.getSession(true);
			        Object id = session.getAttribute("id_client");
			        System.out.print("--ESSE E' id --"+ id);
			        session.getAttribute("id_client");
			        
			     /*   PreparedStatement pst3 = (PreparedStatement) con.prepareStatement(
				    		"INSERT INTO trans (id_client) VALUES("+session.getAttribute("id_client")+")");
			                 pst3.setString(1, (String) session.getAttribute("id_client"));
							 pst3.execute();  */
							  System.out.print("-- ULTIMO PEGOU O  ID_CLIENT--"+id_client);
		
			//	PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(
			 //"INSERT INTO trans id_client=(SELECT id_client FROM clientes ON DUPLICATE KEY UPDATE id_client=id_client)");
			//"UPDATE trans SET id_client WHERE id_client = SELECT id_client FROM clientes");
			//"INSERT INTO trans (id_client)SELECT id_client FROM clientes WHERE id_client='?'; "); 	    			 
			// pst1.setString(1, id_client);
		
			//System.out.print("-- VAI EXECUTAR O ID--"+id_client);
			//  pst1.executeUpdate(); 
							
				 
				  con.close();
			      }  catch (SQLException e) {
			    	  System.out.print("--NNAAOO PEGOU ESTA NO CATCH DO SEGUNDO--"+ e);
			    	  
			    	  RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			     		rd.forward(request, response); 
			   
			      } finally {  }
			 System.out.print("----FOI CADASTRADO TUDO------");
			 System.out.println("Client ID is: "+ id_client);
			 System.out.println("Name is: "+ firstname);
	   
	         HttpSession session = request.getSession();
             session.setAttribute("id_client", id_client);
             session.setAttribute("firstname", firstname);
         
                   request.getSession().setAttribute("id_client", id_client);
				   request.getSession().setAttribute("firstname", firstname);
				
	                  			    		               
	              RequestDispatcher rd = request.getRequestDispatcher("logado.jsp");
	          	    rd.forward(request, response);  
		System.out.print(" DEU CERRTOOO");	  
		      }  
	}	