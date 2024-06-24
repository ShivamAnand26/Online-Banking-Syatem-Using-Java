
<%@page import="in.sp.datahandlers.allCustomers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="in.sp.datahandlers.Statement" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Statement</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        h1, h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .div {
    
    display: flex;
    justify-content: center; /* Center horizontally */
    align-items: center; /* Center vertically */
    
}
        
    </style>
</head>
<body>
<div class="div">
<form action="showcustomer" method="post">
<button type="submit">Show All Customers</button>
</form>
</div>
<h1>All Customers </h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Account Number</th>
        <th>Account Type</th>
        <th>Balance</th>
        <th>Phone Number</th>
        <th>Password</th>
    </tr>
    <% 
    List<allCustomers> customers = (List<allCustomers>) request.getAttribute("allCustomer");
    if (customers != null) {
        for (allCustomers customer : customers) {
    %>
  <tr>
    <td><%= customer.getId() %></td>
    <td><%= customer.getName() %></td>
    <td><%= customer.getAccno() %></td>
    <td><%= customer.getAcctype() %></td>
    <td><%= customer.getBalance() %></td>
    <td><%= customer.getPno() %></td>
    <td><%= customer.getPass() %></td>
</tr>
  
    <% 
        }
    }
    %>
</table>

</body>
</html>
