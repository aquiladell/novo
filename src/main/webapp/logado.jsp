<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Login</title>
</head>
<div id="container">
<body>
   <table border="0" bgcolor="silver">
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
    <% 
   String id = (String) session.getAttribute("id_client");
        // session = request.getSession(true);
     //if(id != null)
    	// throw new ServletException("Nenhum Usuário Logado");
     %>     
   <div id="head"> 
   <p><br> 
    <center><h1>WELCOME !</h1></center>
    </div>
   <table>
  <tr><td><h2>Id Cliente</h2></td> <td><h2>Username</h2></td>
   <tr><td><h2><%= session.getAttribute("id_client") %> </h2></td>
   <% 
   // String id_client = (String) session.getAttribute("id_client");
	
   //  if(  id_client != id_client){
   // 	 session = request.getSession(true);
    	 System.out.print("--ESSE E' id --"+ id);
   //  }else{
    //	 System.out.print("--NAO DEU CERTO id_client --");
   //  }
     %> 
     <td><h3><%= session.getAttribute("lastname") %> </h3></td>    
  <td><h3><%= session.getAttribute("username") %> </h3></td></tr>
   <tr><td><h2>FirstName</h2></td><td><h2>LastName</h2></td></tr>
  <td><h3><%= session.getAttribute("firstname") %> </h3></td>
  <td><h3><%= session.getAttribute("lastname") %> </h3></td>
  </tr>   
 <tr>
 <tr><td><h2>What we can do for you ?</h2>
 </td></tr>
 </table>
 </div>
 </td>
                </tr>
                </tbody>
                </tablet>
</body>

</html>