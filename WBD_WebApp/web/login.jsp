<%-- 
    Document   : login
    Created on : Nov 8, 2016, 12:42:08 AM
    Author     : ASUS-A451LB
--%>
<%--
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
--%>

<!DOCTYPE html>
<html>
	<head>
		<title>login</title>
		<%--<link rel="stylesheet" type="text/css" href="../css/style.css">--%>
	</head>
	<body>
		<center><div class="title">Sale<span class="bluetext">Project</span></div></center><br><br>
		<div class="subtitle">Please Login</div>
		<hr><br>
		<form action="http://localhost:8082/WBD_IdentityService/login_servlet" method="post" name="login_form"">
                        <input type="hidden" name="URLvalid" value="http://localhost:8080/WBD_WebApp/catalog.jsp">
                        <input type="hidden" name="URLinvalid" value="http://localhost:8080/WBD_WebApp/login.jsp">
			Email or Username<br>
			<input type="text" name="user_id" class="text_input">
			<p id="id_warning" class="warning"></p><br>
			Password<br>
			<input type="password" name="user_password" class="text_input">
			<p id="pass_warning" class="warning"></p><br>
			<input type="submit" value="LOGIN" class="button">
                        
		</form>
		<div class="redtext">
			<p class="warning"></p>
		
		<br><br><br>
		<div>Don't have an account yet? Register <a href="register.jsp" class="bluetext">here</a></div>
		<%--<script src="../js/formvalidation.js"></script>--%>
	</body>
</html>