<%@page import="java.util.ArrayList, java.util.List, senac.jp.dominio.Aluno" %>  
<html>
<head>
<meta charset="UTF-8">
<title>Alunos Cadastrados</title>
</head>
<body>
	
<br><br>
Clique <a href="cadastrarAluno.jsp">aqui</a> para cadastar um novo aluno

<%  List<Aluno> listaAlunos = (List<Aluno>) request.getAttribute("listaAlunos"); %>




<h2>Alunos Cadastrados</h2>
<table border="1">

	<tr> 
		<th> Detalhar </th>
		<th> Nome </th>
		<th> Idade </th>
		<th> Sexo </th>
		<th> Semestre </th>
		<th> Excluir </th>
	
	
	</tr>   
	
	<%  if (listaAlunos != null) {
			for (Aluno aluno : listaAlunos) { %>
		<tr>	
			<td> <a href="DetalharServlet?id=<%= aluno.getId() %>"> <%=aluno.getId() %></a></td>
			<td> <%= aluno.getNome() %>   </td>
			<td> <%= aluno.getIdade()  %>   </td>
			<td> <%= aluno.getGenero() %>   </td>
			<td> <%= aluno.getSemestre() %>   </td>
			<td> <a href="ExcluirServlet?id=<%= aluno.getId() %>">Excluir</a></td>
		</tr>
		<% } }%>
	
	



</table>










</body>
</html>