<%@page import="java.util.ArrayList, java.util.List, senac.jp.dominio.Aluno" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Aluno Cadastrado</h2>
	
	
  <%  Aluno aluno = (Aluno) request.getAttribute("aluno"); %>

	
	Id: <%= aluno.getId() %>
	<br><br>
	
	Nome: <%= aluno.getNome() %>
	<br><br>
	
	Idade: <%= aluno.getIdade() %>
	<br><br>
	
	Genero: <%= aluno.getGenero() %>
	<br><br>
	
	
	Semestre: <%= aluno.getSemestre() %>
	<br><br>
	
	
	<!--  a href="listarAlunos.jsp">Voltar</a>	-->	
	
	
	
		
	<input type="button"  onclick="javascript:location.href='ListarServlet'"  value="Voltar">
	
 	<!--<input type="button"  onclick="javascript:location.href='listarAlunos.jsp'"  value="Voltar">-->	
	<a href="AlterarServlet?id=<%=aluno.getId()%>">Alterar</a>
	

	
	
	
	<br><br>
	
	
</body>
</html>