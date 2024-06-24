<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - ODBC BANK</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="mynav">
        <h1>Welcome to PBLJ BANK</h1>
        </div>
    <div class="main">
    
        <div class="login-container">
        
        <h2 >Login</h2>
        
            
            <form action="Login" method="post">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" placeholder="Enter username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Enter password" required>
                </div>
                <button type="submit" class="login-button">Login</button>
            </form>
        </div>
    </div>
</body>
</html>
