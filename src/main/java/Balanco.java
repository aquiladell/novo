

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Balanco")
public class Balanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String inicialdeposit = null;
        
    public Balanco() {
        super();    
    }

    Connection con;
	PreparedStatement pst = null;
 	ResultSet rs = null ;
 
      
 	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		  String sacar =request.getParameter("sacar");
 		 String balanco =request.getParameter("balanco");
  
 		    HttpSession session = request.getSession();
 		    String id = (String) session.getAttribute("id_client");
 		        System.out.print("--ESSE E' id --"+ id);
 		        session.getAttribute("id_client"); 
 		       try {
    			   con = CriarConexao.getConexao();  
    		
    			  System.out.print("----depois da CONNETION--- ");
    			//   pst = con.prepareStatement("SELECT sacar,balanco FROM trans WHERE id_client = id");
     		      
    		     pst = con.prepareStatement("SELECT sacar, balanco FROM trans ");
    			
    			   System.out.print("----PASSOU A PERGUNTA DO ID CLIENTE--- ");
    		  
    		     pst.setString(1, sacar);
    		      //pst.setString(2,rs.getString(balanco));
    			   pst.setString(2, balanco);
    		     rs=pst.executeQuery();
    		   
    		      System.out.print("---depois EXECUTEQUERY----"+ balanco + id + sacar);
    		     // System.out.print("--TEM BALANCO is:--"+rs.getString("balanco"));
 		                                       
 		              //   while (rs.next()) { 
 		                  if (rs.getString("id_client").trim().equals(id)) {         
 		                
 		                 String som; String sac; String bal;
 		                 
 		                 sac= rs.getString("sacar");
 		                 bal= rs.getString("balanco");
 		                System.out.print("---VALORES ----"+ balanco + sacar);
 		                RequestDispatcher rd = request.getRequestDispatcher("balancoResult.jsp");
 			             rd.forward(request, response);  
 		              
 		                 }else{
 		                System.out.print("--ERRROORRR--");
 		               RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
 		              rd.forward(request, response);  
 		                }
 		              //  } 		
                    }catch (SQLException e) {
                     System.out.print("----TA NO PRIMEIRO CATCH DEU ERRADO------"+ e);	
                    } finally {
                               }
                                  System.out.print("----DEU CERTO E SAIU DO DATABASE------");
             }	
} 
 /*	public void acharClient(String idClient){
 		try{
 		 con = CriarConexao.getConexao();
	        //pst = con.prepareStatement("SELECT * FROM clientes WHERE id_client = '"+ id_client+ "'");
	        pst = con.prepareStatement("SELECT * FROM clientes WHERE id_client = '"+ idClient+ "'");
	        pst.setString(1, idClient);
	        rs=pst.executeQuery();  
	        
 		    rs.first();
 		    idClient = rs.getString("id_client");
 		   System.out.print("--PEGOU O 11 ID--"+idClient);
 		  }catch(SQLException e){
 			 System.out.print("--NO CATCH DO JAVA BALANCO--"+e);
 		                         }
 		 System.out.print("--PEGOU O 22 ID--"+idClient);
 		}
}*/
 		 
		 
 		 
		 
 		 
 		 
      		// String balanco = null;
       		// String id_client = request.getParameter("id_client");
       		//String username = request.getParameter("username");
     	//	HttpSession session = request.getSession(true);
            		  		
    /*        HttpSession session = request.getSession();
		     //session.setAttribute("id_client", "id_client");
            request.getSession().setAttribute("id_client", rs.getString(id_client));
	        // session.setAttribute("firstname", "firstname");
            String id_client1 = request.getParameter("id_client");
 		  //  String firstname = request.getParameter("firstname");     
		   
      try {
    	        con = CriarConexao.getConexao();
		        //pst = con.prepareStatement("SELECT * FROM essecliente WHERE id_client = '"+ id_client+ "'");
    	        pst = con.prepareStatement("SELECT * FROM essecliente WHERE id_client = "+ id_client1);
    	        pst.setString(1, id_client1);
		        rs=pst.executeQuery();   
		        
		        System.out.print("--COMPAROU ID FIRST--"+rs.getString("id_client"));
		      //  System.out.print("--COMPAROU ID SECOND--"+rs.getString(id_client));
		        System.out.print("--DEU CERTO o EXECUTEQUERY DE VERIFICACAO --");
		*/        
		        
		      //  if(rs.next()) {
               //     System.out.print("--COMPAROU E ENTROU NO IF--"+rs.getString(id_client));
              
		        
                //  pst = con.prepareStatement("SELECT balanco FROM essecliente ");
                //  pst.setString(1, balanco);
                 // rs=pst.executeQuery();
                //  rs.last();
             //      balanco = con.rs.getString("balanco");		      
	                    
		//	System.out.print("--PEGOU O BALANCO "+rs.getString(balanco));
			                       // HttpSession session = request.getSession();
				                //    session.setAttribute("id_client",id_client);
				                //    session.setAttribute("firstname",firstname);
				                //    session.setAttribute("lastname", lastname);
				                //    session.setAttribute("username", username);
				                         //request.getSession().setAttribute("id_client", rs.getString("id_client"));
						         // request.getSession().setAttribute("firstname", rs.getString("firstname"));
							 //request.getSession().setAttribute("lastname", rs.getString("lastname"));
			    		                 //request.getSession().setAttribute("username", username);
			    		                  			    		               
			    		            //  RequestDispatcher rd = request.getRequestDispatcher("balancoResult.jsp");
			    		          	//    rd.forward(request, response);  
	                                   
		             // con.close();
		       	
	/*		      
      		//HttpSession session=request.getSession(true) ;     		
      		request.getParameter(id_client);  
      		session.getAttribute("id_client");
      		System.out.print("--PEGOU O ID Client is:--"+ id_client);
       		//String sql = "INSERT INTO trans(sacar, dia) values('?', now()) WHERE balaco>=sacar AND id_trans=1";	
	        // String sql = "INSERT INTO trans(sacar) values'?'";	
	         
    		try {
    			   con = CriarConexao.getConexao();  
    		
    			  System.out.print("----depois da CONNETION--- ");
    			  // pst = con.prepareStatement("SELECT * FROM essecliente WHERE id_client = ?");
     		      
    		     // pst = con.prepareStatement("SELECT * FROM essecliente ");
    			   pst = con.prepareStatement("SELECT * FROM essecliente");
    			   System.out.print("----PASSOU A PERGUNTA--- ");
    		    //  pst.setString(1, id_client);
    		    //  pst.setString(1, firstname);
    		    // pst.setString(2, lastname);
    		      pst.setString(2, balanco); 
    		     rs=pst.executeQuery();
    		   
    		      System.out.print("---depois EXECUTEQUERY----"+ balanco + id_client);
    		      System.out.print("--TEM BALANCO is:--"+rs.getString("balanco"));
    		    //   if (ID.equals(id_client)){
    		    	 //  HttpSession session=request.getSession(true) ;
    		           // id= (String) session.getAttribute(id_client); 
    		            // password=(String)session.getValue("Password");
    		    	   System.out.print("--PASSOU O IF --- ");
    		
    		      //  HttpSession session = request.getSession(true);
				  //  session.setAttribute("id_client", rs.getString("id_client"));
				    System.out.print("--PEGOU O ID Client is:--"+ id_client);
			     */
				   // System.out.print("--BALANCO is:--"+rs.getString(balanco));
				  //  System.out.print("--TEM BALANCO is:--"+rs.getString("balanco"));
				 
     /*               session.setAttribute("id_client", rs.getString("id_client"));
                    session.setAttribute("firstname", rs.getString("firstname"));
                    session.setAttribute("lastname", rs.getString("lastname"));
                //    session.setAttribute("username", username);
                    session.setAttribute("balanco", rs.getString("balanco"));
                    request.getSession().setAttribute("id_client", rs.getString("id_client"));
		            request.getSession().setAttribute("firstname", rs.getString("firstname"));
		            request.getSession().setAttribute("lastname", rs.getString("lastname"));
                 //   request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("balanco", rs.getString("balanco"));
            			    		               
                    RequestDispatcher rd = request.getRequestDispatcher("balancoResult.jsp");
    	             rd.forward(request, response);  
    
	               	con.close();
	         //   }
	               }catch (SQLException e) {
	    	                   System.out.print("--NO CATCH DO JAVA BALANCO--"+e);
	                                        }    	
    		System.out.print("----SAIU DO DATABASE DO JAVA BALANCO------");
        }	
  } */