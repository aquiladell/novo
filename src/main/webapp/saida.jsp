<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
  <title>EugenioBank Error</title>
  
</head><body>
<div id="container">
      <div align="center">    
      <img src="investment_files/eugBank.jpg"/><br/>
      </div>
 <table border="0" bgcolor="silver">
             <tbody>
                <tr>
                 <td>
<div id="head">
  <div id="navigation">
     <ul>
        <li><a href=" index.html ">HOME</a></li>
        <li><a href="NewAccount.html  ">NEW ACCOUNT</a></li>
        <li><a href=" contact.jsp ">CONTACT US</a></li>
        </ul>
 </div>
 <div id="content">
<div align="center">


      <h1>Welcome !</h1>            
      <h2>EugenioBank</h2>
      
      <img src=""investment_files/eugBank.jpg"/><br/>
     <table bgcolor="silver">
  
 <tr><td>  </td><td> <h3>You just Log Out. Thank you, have a nice day !</h3></td><td>  </td></tr>
 </table>
 
      <h2>Please enter your:</h2>
      
  <form name= "frmLoginCheck" action="LoginCheck" method ="post">              

 
 <table>
  
 <tr><td><h2>USER ID:</h2></td>
 <td> <input type ="text" name = "username"/></td>
 </tr>
 <tr><td> <h2>PASSWORD:</h2></td>
 <td><input type="password" name = "senha"/></td>
 </tr>
  <tr>
  <td colspan="1" align="center"> 
  <input type ="submit"  value = "Submit" onclick="validarLogin()"/> 
  </td></tr>
 </table>
 </form>
              
 <h3>If you don't have Account click on "New Account Button".</h3>
                
  <form action = "NewAccount.html" method ="get">
 <table>
  <tr><td colspan="1" align="center"> 
  <input type ="submit"  value = "New Account">
  </td></tr>
 </table>
 </form>     
       
        
</section>
</div>
</div>
</td>
                </tr>
                </tbody>
                </tablet>
</body>
</div>

</html>