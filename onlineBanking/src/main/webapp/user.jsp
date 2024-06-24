<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <style>
    .tran-div{
    		
      	    width: 75%;
            margin: 10px auto;
            padding: 20px;
            background-color: light-grey;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
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

        .user-details {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            border: 1px solid #ddd;
            box-sizing: border-box;
        }

        .user-details h2 {
            margin-top: 0;
            font-size: 24px;
            color: #333;
        }

        .user-details p {
            margin-bottom: 10px;
            font-size: 16px;
            color: #555;
        }
    </style>
    
    
    <script type="text/javascript">
  
    </script>
</head>
<body>
<div class="mynav">
        <h1>Welcome to PBLJ BANK</h1>
        </div>
    <div class="container">
        <div class="user-details">
            <h2>User Information</h2>
            <p><strong>User ID:</strong> ${userId}</p>
            <p><strong>User Name:</strong> ${userName}</p>
            <p><strong>Account Number:</strong> ${accno}</p>
            <p><strong>Account Type:</strong> ${acctype}</p>
            <p><strong>Balance:</strong> ${balance}</p>
            <p><strong>Phone Number:</strong> ${pno}</p>
            <!-- Add more user details as needed -->
            
            
            
            
            <form action="History" method="post">
            
            <button value="${userId}" name="id" type=submit>DownLoad Statement</button>
            </form>
            
         
        </div>
        <div class="tran-div">
        
        
        
        
        
        <h3> Transaction</h3>
        
        <form action="transaction" method="post">
		<input type="text" name="id" value="${userId}" readonly placeholder="User ID">
		<br>
		<br>
		<input type="text" name="accno" value="${accno}" readonly placeholder="Your Account">
		<br>
		<br>
		<input type="text" name="n_id"  placeholder="Nominee id ">
		<br>
		<br>
		
		<input  type="number" name="amount" placeholder="Enter Amount ">
		<br>
		<br>
		<button type="submit">Transfer</button>


</form>
</div>    
 </div>
</body>
</html>
