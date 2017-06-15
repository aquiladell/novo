

import java.io.IOException;
import java.sql.Connection;
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

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Withdraw() {
        super();
    }

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   	
		String sacar = request.getParameter("sacar");  
		
		HttpSession session = request.getSession(true);
        Object id = session.getAttribute("id_client");
        System.out.print("--ESSE E' id --"+ id);
        session.getAttribute("id_client");
        System.out.print("--ESSE E' id_client --"+ "id_client");
			if (session.getAttribute("id_client").equals(id)) {  
				  System.out.println("--PEGOU O IF eo ID-- " + id);
			     try{

			        con = CriarConexao.getConexao();
			       pst = (PreparedStatement) con.prepareStatement( 
			        	//	"INSERT INTO trans (sacar) VALUES(?)");
			        	//	"INSERT INTO trans (id_client, sacar) VALUES("+session.getAttribute("id_client")+",?)");
			             "INSERT INTO trans (id_client, sacar) VALUES(?,?)");
			      pst.setString(1, (String) session.getAttribute("id_client"));
			       System.out.print("--passou INSERT--");
			        pst.setString(2, sacar);
			        System.out.print("--passou SETSTRING--");
					pst.execute();
			       
			        
			        System.out.println("--PEGOU O PRIMEIRO-- ");
			      /*  pst = (PreparedStatement) con.prepareStatement(
			        "SELECT *  FROM transacao ");
			    //"SELECT id_client, sacar, balanco, dia FROM essecliente ");
			        rs = pst.executeQuery(); 
			        System.out.println("--PEGOU O SEGUNDO-- ");     */
			       /*  HttpSession session1 = request.getSession(true);
			         Object id = session1.getAttribute("id_client");
			         System.out.print("--ESSE E' id --"+ id);
			         session1.getAttribute("id_client"); */
			        System.out.println("--PEGAR O WHILE-- ");     
			 //   while (rs.next()) {
			                if (rs.getString("id_client").trim().equals(id)) {           
			                	  System.out.println("--Passou o IF-- ");
			                   rs.getString("id_client");
			         		 //  rs.getString("firstname");
			         		   rs.getString("sacar");
			         		   rs.getString("balanco");
			         		   
			         		   float som;
			         		   som = rs.getFloat("balanco")  - rs.getFloat("sacar");
   
			         		   System.out.println("--Sacar is:-- "+ sacar);
			                   System.out.println("--Balanco is:-- "+ rs.getString("balanco")); 
			                   System.out.println("--Balanco NOW is:-- "+ som);       
			                  
			                   request.getSession().setAttribute("sacar", sacar);
			                   request.getSession().setAttribute("balanco",rs.getString("balanco")); 
			                   request.getSession().setAttribute("som",som); 
			                   System.out.print("----FOI CONFIRMADO E PODE SACAR O VALOR E'MENOR DO BALANCO------"+ sacar + rs.getString("balanco"));
			                   
			                   RequestDispatcher rd = request.getRequestDispatcher("sacarResult.jsp");
			          	       rd.forward(request, response);
			            
			         		   }else{
			         			   System.out.print("--1--ERRROORRR--");
			         			    } 
			           //  }           
			             }catch (SQLException e){
			                         System.out.print("---Catch 1 do Statement---- "+ e);
			                                    }
			}else{
				   System.out.print("-- 2  ERRROORRR--");
				    }
		
          }
   }

    
             
	

