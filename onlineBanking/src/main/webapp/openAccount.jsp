<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Open Account Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 50%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        form {
            width: 80%;
            margin: 0 auto;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Open Account Page</h1>
        <form action="openAccount" method="post">
            <input type="text" name="C_id" placeholder="Enter Customer ID">
            <input type="text" name="C_name" placeholder="Enter Customer Name">
            <input type="text" name="C_accno" placeholder="Enter Account Number">
            <input type="text" name="C_acctype" placeholder="Enter Account Type">
            <input type="text" name="C_pno" placeholder="Enter Phone Number">
            <input type="text" name="C_balance" placeholder="Enter Minimum Balance">
            <input type="text" name="C_pass" placeholder="Enter Customer Password">
            <button type="submit">Open Account</button>
        </form>
    </div>
</body>
</html>
