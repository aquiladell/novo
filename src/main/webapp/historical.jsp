<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link rel="stylesheet" href="style.css" type="text/css">
      <title> Withdraw Date</title>
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
  <h1>Withdraw Date</h1>
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
   //  "SELECT id_client, firstname, lastname, deposito,balanco, dia FROM essecliente");
              selectBank = connection.prepareStatement(
            "SELECT id_client, firstname, lastname, deposito, sacar, balanco, dia FROM essecliente ");		  
          //  "SELECT id_client.c, firstname.c, deposito.t, sacar.t, balanco.t, dia.t FROM clientes.c, trans.t ");
                   
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
   <h2><%= session.getAttribute("id_client") %></h2>
     <div id="content"> 
        <table border="0">
             <tbody>
                <tr>
                 <td> ID Cleint:</td>
                 <td> Firstname: </td>
                 <td> Lastname: </td>
                 <td> Deposit: </td>
                 <td> Sacar: </td>
                 <td> Balance: </td>
                 <td> Data: </td>
                </tr>                        
                 <% while (banks.next()) { %>
                 <% if (banks.getString("id_client").trim().equals(id)) { %>          
                <tr>
                 <td> <%=  banks.getString("id_client")%>  </td>
                 <td> <%=  banks.getString("firstname")%>  </td>
                 <td> <%=  banks.getString("lastname")%>  </td>
                 <td> <%=  banks.getString("deposito")%>  </td>
                 <td> <%=  banks.getString("sacar")%>  </td>
                 <td> <%=  banks.getString("balanco")%>  </td>
                 <td> <%=  banks.getString("dia")%>  </td>
                </tr>
                <td> <% }else{%>  </td>
                <td> <%  System.out.print("--ERRROORRR--");%>  </td>
                <td> <% }%>  </td>
                <td> <% }%>  </td>
                </tbody>
                </tablet>
               
    

  </div>           
 </div>
</body>
</html>