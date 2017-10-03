<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <li><a href=" sacar.jsp ">DEPOSIT</a></li>
        <li><a href=" balanco.jsp ">BALANCE</a></li>
        <li><a href=" historical.jsp ">RECENT TRANSACTIONS</a></li>
        <li><a href=" LogOut.java ">LOGOUT</a></li>
    </ul>
 </div>
 <p>
   <%  
    //   String nomeUsuario = (String) session.getAttribute("usuarioautenticado");
   //  if(nomeUsuario == null)
    //	 throw new ServletException("Nenhum Usuário Logado");
     %>
     
 
   <div id="head"> 
   <p><br> 
    <center><h2>Hi !</h2></center>
    </div>
    <table>
    <tbody>
    <% String id = (String) session.getAttribute("id_client");
    System.out.print("--ESSE E' id --"+ id);
     %>
<tr><td><h2><%= session.getAttribute("id_client") %></h2><h2><%= session.getAttribute("firstname") %> </h2></td>
</tr> 

<tr><td><h2>After your WITHDROWS : $<%= session.getAttribute("sacar") %>,00</h2></td>
 </tr>
 <tr><td><h2>Your Balanco ANTERIOR is : $<%= session.getAttribute("balanco") %></h2></td>
 </tr>
 <tr><td><h2> NOW is: $<%= session.getAttribute("som") %></h2></td>
 </tr>
 <tr><td><h2>What we can do more for you ?</h2>
 </td></tr>
 </tbody>
 </table>
 </div>
 </td>
                </tr>
                </tbody>
                </tablet>
                
                <table>
                <tbody>
                <tr>
                  <td>  </td>
                </tr>
                
                </tbody>
                </tablet>
</body>

</html>