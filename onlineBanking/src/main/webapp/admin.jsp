<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminPage</title>
<link rel="stylesheet" type="text/css" href="css/adminPage.css">

<script >

function openAccount(){
    window.location.href='openAccount.jsp';
}
function showCustomer(){
    window.location.href='showcustomer.jsp';
}
function editCustomer(){
    window.location.href='FindCustomer.jsp';
}
function closeAccount(){
    window.location.href='closeAccount.jsp';
}

</script>

</head>
<body>
<div class="main">
 
    <div class="outer-div">
        <div class="inner-div">
         <h1> ODBC BANK </h1>
        <h3> Welcome Admin</h3>
            <h3>Date</h3>
            <h3>Time</h3>-

            <input type="button" value="Open Account" onclick="openAccount()"/>
            <input type="button" value="Show customer"  onclick="showCustomer()" />
            <input type="button" value="Edit customer Details" onclick="editCustomer()" />
            <input type="button" value="Close Account"  onclick="closeAccount()" />
             
        </div>
    </div>

</div>

</body>
</html>
