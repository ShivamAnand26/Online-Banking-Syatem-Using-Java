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
    </style>
</head>
<body>
    <h1>Account Statement</h1>
    <h2>User Information</h2>
    <table>
        <tr>
            <th>From</th>
            
            <th>Amount</th>
            <th>Date</th>
            <th>To</th>
        </tr>
        <%
            List<Statement> transactions = (List<Statement>) request.getAttribute("transactions");
            if (transactions != null) {
                for (Statement transaction : transactions) {
        %>
            <tr>
                <td><%= transaction.getId() %></td>
                <td><%= transaction.getAmount() %></td>
                <td><%= transaction.getDate() %></td>
                <td><%= transaction.getAccount() %></td>
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
