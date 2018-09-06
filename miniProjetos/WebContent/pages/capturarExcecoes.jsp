<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<title>Captura de Exceções</title>
</head>
<body>
	<h1>Capturando exceções com JQuery</h1>
	<input type="text" value="Valor informado" id="txtvalor">
	<input type="button" onclick="testarExcecao();" value="Testar Exceção">
</body>

<script type="text/javascript">
	function testarExcecao(){
		valorInformado = $('#txtvalor').val();
		
		$.ajax({
			method: "POST",
			url:"CapturarExcecao",
			data:{valorParam: valorInformado}
		})
		.done(function(response){
			alert("Sucesso: "+response);
			
		})
		.fail(function(xhr, status, errorThrown){
			alert("Erro: "+xhr.responseText);
		});
	}
</script>

</html>