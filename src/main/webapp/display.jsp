<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Display</title>
</head><body>

<div id="container">
    <div align="center">    
      <img src="investment_files/eugBank.jpg"/><br/>
      </div>
    <table border="0" bgcolor="cccccc">
      <tbody><tr><td>
   <br>
       
       <br>
       <div id="navigation">
        <ul>
        <li><a href=" sacar.jsp ">WITHDROW </a></li>
        <li><a href=" deposit.jsp ">DEPOSIT </a></li>
        <li><a href=" balanco.jsp ">BALANCE </a></li>
        <li><a href=" historical.jsp ">RECENT TRANSACTIONS </a></li>
        <li><a href=" LogOut.java ">LOGOUT</a></li>
        </ul>
 </div>

 <div id="content">
<table border="O">

<TR><TD ALIGN="center">
<FORM METHOD="POST" ACTION="" >
<INPUT TYPE="submit" VALUE="WITHDRAWN" >
<INPUT TYPE="text"  NAME="sacar" >
</FORM>

<TR><TD ALIGN="center">
<FORM METHOD="POST" ACTION="Deposito">
<INPUT TYPE="submit" VALUE="DEPOSITED">
<INPUT TYPE="text"  NAME="deposito" >
</FORM>

<TR><TD ALIGN="center">
<FORM METHOD="POST" ACTION="Balance" >
<INPUT TYPE="submit" VALUE="BALANCE" NAME="ba1ance">
</FORM>

<TR><TD ALIGN="center">
<FORM METHOD="POST" ACTION="LogOut" >
<INPUT TYPE="submit" VALUE="LOGOUT">
</FORM> 
</TABLE>
</div>
</td>
                </tr>
                </tbody>
                </tablet>
</body>
</div>
</html>