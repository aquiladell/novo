<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link rel="stylesheet" href="style.css" type="text/css">
      <title> BALANCE</title>
    </head><body >
    <div id="container">
    
        <div align="center">    
      <img src="investment_files/eugBank.jpg"/><br/>
      </div>
<div id="navigation">
     <ul>
        <li><a href=" deposit.jsp ">DEPOSIT</a></li>
        <li><a href=" balanco.jsp ">BALANCE</a></li>
        <li><a href=" historical.jsp ">RECENT TRANSACTIONS</a></li>
        <li><a href=" LogOut.java ">LOGOUT</a></li>
        </ul>
 </div>
 
 <div id="head">
  <h1>Balance Date</h1>
   </div>
     <%!
        public class Bank{
         String URL = "jdbc:mysql://localhost:3306/eugenio";
         String USERNAME = "root";
         String PASSWORD = "rafael12";

          Connection connection = null;
          PreparedStatement selectBank = null;
          ResultSet resultSet = null;

          public Bank(){
             try{

         connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
              selectBank = connection.prepareStatement(
             "SELECT id_client, firstname, balanco, dia FROM essecliente ");	  
          //   "SELECT id_client, firstname FROM clientes ");
          //  "SELECT balanco, dia FROM clientes ");       
               }catch (SQLException e){
        	              System.out.print("---Catch do Statement---- "+ e);
                                           }
                }

              public ResultSet getBanks(){
         	     try{
        	          resultSet = selectBank.executeQuery();       	  
        	        }catch (SQLException e){
   	                         System.out.print("---Catch do executeQuery---- "+ e);
                                          }         
                return resultSet;
          }  
     }
     %>
     <% 
      Bank bank = new Bank();
      ResultSet banks = bank.getBanks();
     %>         
 
   <% String id = (String) session.getAttribute("id_client");
        System.out.print("--ESSE E' id --"+ id);
     %>
     <div id="content"> 
        <table border="0">
             <tbody>
                <tr>
                 <td><h2> ID:</h2></td>
                 <td> <h2>Firstname:</h2> </td>
                 <td><h2> Balance: </h2></td>
                 <td><h2> Data: </h2></td>
                </tr>                        
                 <% while (banks.next()) { %>
                 <% if (banks.getString("id_client").trim().equals(id)) { %>          
                <tr>
                 <td><h2> <%=  banks.getString("id_client")%> </h2> </td>
                 <td><h2> <%=  banks.getString("firstname")%> </h2> </td>
                 <td><h2> <%=  banks.getString("balanco")%> </h2> </td>
                 <td><h2> <%=  banks.getString("dia")%> </h2> </td>
                </tr>
                 <% }else{%>  
                 <%  System.out.print("--DEU ERRROORRR--");%>  
                 <% }%>  
                 <% }%> 
                </tbody>
                </table>
               
    

  </div>           
 </div>
</body>
</html>