package senac.jp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import senac.jp.db.DB;
import senac.jp.db.DbException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/ExcluirServlet")
public class ExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("------------- Passei no servlet de excluir ------------");
		
		// Recupera o id do aluno que deve ser excluido
		String id = request.getParameter("id");		
		
		// Acessar o banco de dados
		Connection conn = null;			
		PreparedStatement st = null;		

		try {
			conn = DB.getConnection();
			
			
			String delete = "Delete FROM aluno WHERE (Id = ?)";
			
			st = conn.prepareStatement(delete);
			
			st.setInt(1, Integer.parseInt(id)); 
			
			st.executeUpdate();			

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
//			DB.closeConnection();
		}			
		

		// Encaminhar a requisição para o JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarServlet");
		dispatcher.forward(request, response);
		
		
	}

	

}
