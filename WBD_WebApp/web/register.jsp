<%-- 
    Document   : register
    Created on : Nov 13, 2016, 1:51:04 AM
    Author     : ASUS-A451LB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Register</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	
	<body>
	<center><div class="title">Sale<span class="bluetext">Project</span></div></center><br><br>
		<br>
		<div class="subtitle">Please Register</div><hr><br>
                <%String errmsg = "<div></div>"; %>
                <%
                    if(request.getParameter("error")!=null) {
                        if(request.getParameter("error") == "username") {
                        errmsg = "<div class=\"warning\">Username is not available</div>";
                        }
                        if(request.getParameter("error") == "email") {
                        errmsg = "<div class=\"warning\">Email is not available</div>";
                        }
                        if(((String) request.getParameter("error")).equals("password")) {
                        errmsg = "<div class=\"warning\">Password didn't match</div>";
                        }
                    }
                %>
                <%=errmsg%>
		<form method=post action="http://localhost:8082/WBD_IdentityService/register_servlet" onsubmit="return validateRegistration();" name="registration">
                        <input type="hidden" name="URLvalid" value="http://localhost:8080/WBD_WebApp/catalog.jsp">
                        <input type="hidden" name="URLinvalid" value="http://localhost:8080/WBD_WebApp/register.jsp">
			Full Name</br>
			<input type=text name=Full_Name class="text_input"><br>
			<div id="fullname_warning" class="warning"></div>
			Username<br>
			<input type=text name=Username class="text_input"><br>
			<div id="username_warning" class="warning"></div>
                        
			Password<br>
			<input type=password name=Password class="text_input"><br>
			<div id="password_warning" class="warning"></div>
			Confirm Password<br>
			<input type=password name=Confirm_Password class="text_input"><br>
			<div id="confirm_warning" class="warning"></div>
			Email<br>
			<input type=text name=Email class="text_input"><br>
			<div id="email_warning" class="warning"></div>
			Full Address<br>
			<textarea name=Full_Address class="text_input__long"></textarea><br>
			<div id="address_warning" class="warning"></div>
			Postal Code<br>
			<input type=text name=Postal_Code class="text_input"><br>
			<div id="postal_warning" class="warning"></div>
			Phone Number<br>
			<input type=text name=Phone_Number class="text_input"><br>
			<div id="phone_warning" class="warning"></div>
			<br>
			<div align="right"><input type=submit value="REGISTER" class="button"></div>
		</form>
		<br><br>
		<b>Already registered? Login <a href="login.jsp">Here</a>
		<script src="../js/formvalidation.js"></script>
	</body>
</html>