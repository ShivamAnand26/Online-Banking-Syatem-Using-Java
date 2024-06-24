<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer Profile</title>
</head>
<body>
  <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        .main {            
            margin: 0 auto;
		    max-width: 800px;
		    padding: 20px;
		    background-color: #fff;
		    border-radius: 10px;
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            
        }

        .inner-div {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
        }

        h3 {
            margin-bottom: 10px;
            color: #555;
        }

        input[type="text"],
        button[type="submit"] {
            margin: 5px;
            padding: 10px;
            width: 80%;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
        }

        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
<div class="main">
 
    <div class="outer-div">
        <div class="inner-div">
         <h1> ODBC BANK </h1>
        <h3> Welcome Admin</h3>
         <form action="FindCustomer" method="post">

			<input type="text" name="id" " placeholder="Enter  UserId"/>
			<button type="submit">Search User</button>
		</form>
        </div>
    </div>

</div>



</body>
</html>