package senac.jp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import senac.jp.db.DB;
import senac.jp.dominio.Aluno;

@WebServlet("/ConfirmarCadastroServlet")
public class ConfirmarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("------------- Passei no servlet de confirmar cadastro ------------");
		
	
		// Recuperar os valores informados
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		
		
		Connection conn = null;
		PreparedStatement st = null;		
		
		List<Aluno> listaAlunos = new ArrayList<>();

		// Inserir dados
		try {
			conn = DB.getConnection();		
			

			// O ponto de interroação será onde vamos preencher depois
			st = conn.prepareStatement("INSERT INTO aluno " + "(Nome, Idade, Semestre, Genero) "
					+ "VALUES " + "(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);	

			st.setString(1, nome);
			st.setString(2, idade);
			st.setString(3, semestre);
			st.setString(4, genero);			

			// Realizar o comando executeUpdate() para realizar a inserção, ele retorna o
			// numero de linhas que foram afetadas
			st.executeUpdate();		
			
			ResultSet generatedKeys  = st.getGeneratedKeys();
			
			if (generatedKeys.next()) {
                int chaveGerada = generatedKeys.getInt(1);                
                
             // Guardar no objeto aluno
    			Aluno aluno = new Aluno(chaveGerada, nome, idade, genero, semestre);
    			
    			// Guarda o aluno na requisição para mostrar na pagina de detalhes		
    			request.setAttribute("aluno", aluno);
            }
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
//			DB.closeConnection();
		}
		
		
		
		// Encaminhar a requisição para o JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("detalharAluno.jsp");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("ListaServlet");
		dispatcher.forward(request, response);

	}

}
