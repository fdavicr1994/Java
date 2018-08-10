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

<!-- Condicional(IF,ELSE) usando JTLS -->

<c:set var="numero" value="${100/2}"></c:set>
<c:choose>
	<c:when test="${numero > 50}">
		<c:out value="${'Maior que 50'}"></c:out>
	</c:when>
	
	<c:when test="${numero < 50}">
		<c:out value="${'Menor que 50'}"></c:out>
	</c:when>
	
	<c:otherwise>
		<c:out value="${'Não encontrou valor correto'}"></c:out>
	</c:otherwise>
</c:choose>
<br>
<!-- FOR usando JTLS -->

<c:forEach var="n" begin="1" end="${numero}">
	Item : ${n}
</c:forEach>

<p/>
<p/>
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