package senac.jp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@WebServlet("/ListarServlet")
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("------------- Passei no servlet de listar ------------");
		
		// Acessar o banco de dados
		Connection conn = null;			
		PreparedStatement st = null;
		ResultSet rs = null;

		String query = "SELECT * FROM aluno";
		try {

			conn = DB.getConnection();
			st = conn.prepareStatement(query);
			rs = st.executeQuery();

			List<Aluno> listaAlunos = new ArrayList<>();

			// Percorer os dados
			while (rs.next() == true) {

				int id = rs.getInt("Id");
				String name = rs.getString("Nome");
				String idade = rs.getString("Idade");
				String semestre = rs.getString("Semestre");
				String genero = rs.getString("Genero");

				// Guardar no objeto aluno
				Aluno aluno = new Aluno(id, name, idade, semestre, genero);
				listaAlunos.add(aluno);

			}

			request.setAttribute("listaAlunos", listaAlunos);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);

		}		 
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarAlunos.jsp");

		dispatcher.forward(request, response);

	}

}
