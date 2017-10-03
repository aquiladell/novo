

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Deposit</title>
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
        <li><a href=" balanco.jsp ">BALANCE</a></li>
        <li><a href=" historical.jsp ">RECENT TRANSACTIONS</a></li>
        <li><a href=" LogOut.java ">LOGOUT</a></li>
        </ul>
 </div>
 
 <div id="head">

  <h1>To Deposit</h1>
  </div>
 <div id="content">

  <h2><%= session.getAttribute("username") %> </h2>

     
      
   
      <form name="myForm" action=" Deposit" method="POST">
        <table border="0">
             <tbody>
                <tr>
                 <td><h2> How much do you want Deposit:</h2></td>
              <td><input type="text" name="deposito" value="" size="10" /></td>
                </tr>
                <tr>
                 <td> <input type="hidden" name="hidden" value=" " />
                <input type="reset" value="clear" name="Clear"/>
                <input type="submit" value="sutmit" name="Submit"/></td>
              <td></td>
                </tr>
                </tbody>
                </tablet>
                
                
                 </form>
</div>
      
 </div>  
 </td>
                </tr>
                </tbody>
                </tablet>       
</body>
</div>
</html>
