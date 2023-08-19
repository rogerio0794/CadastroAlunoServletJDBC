<%@page import="senac.jp.dominio.Aluno" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> Alterar Aluno:</h2>


<%  Aluno aluno = (Aluno) request.getAttribute("aluno"); %>

<form action="ConfirmarAlteracaoServlet" method="post">

		
		<input type="hidden" name="id"  value="<%= aluno.getId()%>" >

		Nome: 
		<input type="text"  name="nome"  value="<%= aluno.getNome()%>" >
		<br><br>
		
		Idade:
		<input type="number" name="idade" value="<%= aluno.getIdade()%>" >
		<br><br>
		
		Semestre:		
        <select name="semestre">
            <option value="Primeiro" <%= aluno.getSemestre().equals("Primeiro") ? "selected" : "" %>	>Primeiro</option>
            <option value="Segundo"	<%= aluno.getSemestre().equals("Segundo") ? "selected" : "" %>		>Segundo	</option>          
        </select>
        <br><br>
		
		Gênero:
		<input type="radio" name="genero" value="Masculino" <%= aluno.getGenero().equals("Masculino") ? "checked" : "" %>  > Masculino
		<input type="radio" name="genero" value="Feminino" <%= aluno.getGenero().equals("Feminino") ? "checked" : "" %>> Feminino
		<br><br>
				
		<input type="submit" value="Confirmar Alteração">        
		<input type="button"  onclick="javascript:location.href='listarAlunos.jsp'"  value="Voltar">

</form> 
</body>
</html>