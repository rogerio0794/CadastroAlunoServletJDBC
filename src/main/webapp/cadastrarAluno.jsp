<%@page import="java.util.ArrayList, java.util.List, senac.jp.dominio.Aluno" %>  
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Aluno</title>
</head>
<body>
	<h1>Cadastro de Aluno</h1>	
	
	

	
	
	
    <form action="ConfirmarCadastroServlet" method="post">
    
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" ><br><br>
        
        <label for="idade">Idade:</label>
        <input type="number" id="idade" name="idade" ><br><br>
        
        <label for="semestre">Semestre:</label>
        <select id="semestre" name="semestre">
            <option value="Primeiro">Primeiro</option>
            <option value="Segundo">Segundo</option>          
        </select><br><br>
        
        <label>G�nero:</label>
        <input type="radio" id="generoM" name="genero" value="Masculino">
        <label for="generoM">Masculino</label>
        <input type="radio" id="generoF" name="genero" value="Feminino">
        <label for="generoF">Feminino</label><br><br>
        
        <input type="submit" value="Confirmar Cadastro">
        <a href="listarAlunos.jsp">Voltar</a>
    </form>





</body>
</html>