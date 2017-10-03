<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Withdrow</title>
</head>
<body>
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
        <li><a href=" deposit.jsp ">DEPOSIT</a></li>
        <li><a href=" balanco.jsp ">BALANCE</a></li>
        <li><a href=" historical.jsp ">RECENT TRANSACTIONS</a></li>
        <li><a href=" LogOut.java ">LOGOUT</a></li>
        </ul>
 </div>

 <div id="head"  align="center">

  <h1>To Withdraw</h1>
  </div>
 <div id="content">
 <% 
     String id = (String) session.getAttribute("id_client");
   
     //  String username = (String) session.getAttribute("usuername");
   //  if(username != "username")
   // 	 throw new ServletException("Nenhum Usuário Logado");
     %> 
     <table border="0">
             <tbody>
                <tr>
                 <td>    
 <h2><%= id %> </h2></td>  
 <td><h2><%= session.getAttribute("id_client") %> </h2></td>
 <td><h2><%= session.getAttribute("firstname") %> </h2></td>
 <td><h2><%= session.getAttribute("lastname") %> </h2></td>
                </tr>
                </tbody>
                </table>
     
   
     <form name= "frmWthdraw" action="Withdraw" method ="post">
        <table border="0">
             <tbody>
                <tr>
                 <td><h2> How much do you want Withdorws:</h2></td>
                <td>
                <input type="text" name="sacar" /></td>
                </tr>
                <tr>
                 <td> 
                <input type="reset" value="clear" name="Clear"/>
                <input type="submit" value="sutmit" name="Submit"/>
                </td>
                </tr>
                </tbody>
                </table>
                 </form>
                   
  </div>      
   </tbody>
        </table> 
</div>                 
</body>
</html>
