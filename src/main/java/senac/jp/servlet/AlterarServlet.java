package senac.jp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import senac.jp.db.DB;
import senac.jp.dominio.Aluno;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/AlterarServlet")
public class AlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("------------- Passei no servlet de alterar ------------");
		
		// Recupera o atributo id do aluno que seve ser alterado
		String id = request.getParameter("id");	
		
		// Acessar o banco de dados
		Connection conn = null;			
		PreparedStatement st = null;
		ResultSet rs = null;

		String query = "SELECT * FROM aluno";
		try {

			conn = DB.getConnection();
			st = conn.prepareStatement(query);
			rs = st.executeQuery();

			// Percorer os dados
			while (rs.next() == true) {

				
				if (Integer.parseInt(id) == rs.getInt("Id")) {
					
					String name = rs.getString("Nome");
					String idade = rs.getString("Idade");
					String semestre = rs.getString("Semestre");
					String genero = rs.getString("Genero");
					
					// Guardar no objeto aluno
					Aluno aluno = new Aluno(rs.getInt("Id"), name, idade, semestre, genero);
					
					// Adiciona o aluno no request, para exibir seus dados na pagina de alterar
					request.setAttribute("aluno", aluno);	
				}				

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);

		}	
		
		// Encaminhar a requisição para o JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("alterarAluno.jsp");
		dispatcher.forward(request, response);
		
		
	}

	

}
