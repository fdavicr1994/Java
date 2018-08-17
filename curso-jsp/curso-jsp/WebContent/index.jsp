<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login - Servlet</title>
</head>
<body>

<c:out value="${'Bem vindo ao JSTL'}"></c:out>

<p/>
<p/>


	<h1>Curso de JSP - Teste de Login</h1>
	
	<form action="LoginServlet" method="post">
		Login:
		<input type='text' id='login' name='login'>
		<br>
		Senha:
		<input type='text' id='senha' name='senha'>
		<br>
		<input type='submit' value='Enviar'>
	</form>
</body>
</html>