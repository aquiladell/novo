<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Logado</title>
</head><body>
<div id="container">
         <div align="center">    
      <img src="investment_files/eugBank.jpg"/><br/>
      </div>


   <table border="0" bgcolor="cccccc">
             <tbody>
                <tr>
                 <td>
  <div id="navigation">
     <ul>
          <li><a href=" sacar.jsp ">WITHDROW</a></li>
         <li><a href=" deposit.jsp ">DEPOSIT</a></li>
         <li><a href=" balanco.jsp ">BALANCE</a></li>
         <li><a href=" historical.jsp ">RECENT TRANSACTIONS</a></li>
        <li><a href=" LogOut.java ">LOGOUT</a></li>
    </ul>
 </div>
 <p><br>

    <% 
   //String id = (String) session.getAttribute("id_client");
        // session = request.getSession(true);
     //if(id != null)
    	// throw new ServletException("Nenhum Usuário Logado");
     %> 
     
       <% 
   // String id_client = (String) session.getAttribute("id_client");
	
   //  if(  id_client != id_client){
   // 	 session = request.getSession(true);
   //  }else{
    //	 System.out.print("--NAO DEU CERTO id_client --");
   //  }
     %>    
   <div id="head"> 
  
    <center><h1>WELCOME !</h1></center>
    </div>
   <table align="center" border="0"> <tbody>
  <tr><td><h2>ID Client</h2></td><td> </td>
  <td><h2>First Name</h2></td><td> </td>  
  <td><h2>Last Name</h2></td>
  </tr>
   <td><center></center><h2><%= session.getAttribute("id_client") %> </h2></td><td> </td>
  <td><h2><%= session.getAttribute("firstname") %> </h2></td><td> </td>
  <td><h2><%= session.getAttribute("lastname") %> </h2></td>
   </tr>  </tbody></table>
   
 
  
 </div>
 </td>
                </tr>
                </tbody>
                </table>
</body>

</html>