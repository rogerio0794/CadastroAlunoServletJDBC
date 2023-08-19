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
import java.sql.Statement;
import java.util.List;


@WebServlet("/ConfirmarAlteracaoServlet")
public class ConfirmarAlteracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("------------- Passei no servlet de confirmar alteração ------------");
		
		// Recuperar os valores informados	
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");		
		String semestre = request.getParameter("semestre");
		

		Connection conn = null;
		PreparedStatement st = null;

		// Atualizar dados
		try {
			conn = DB.getConnection();			
			
			String update = "UPDATE aluno SET Nome = ?, Idade = ?, Semestre = ?, Genero = ? WHERE Id = ?";
			
			st = conn.prepareStatement(update);	
			st.setString(1, nome); 
			st.setString(2, idade); 
			st.setString(3, semestre);
			st.setString(4, genero); 
			st.setInt(5, Integer.parseInt(id)); 		
			st.executeUpdate();	
			
			
         // Guardar no objeto aluno
			Aluno aluno = new Aluno(Integer.parseInt(id), nome, idade, genero, semestre);
			
			// Guarda o aluno na requisição para mostrar na pagina de detalhes		
			request.setAttribute("aluno", aluno);
			
			// Encaminhar a requisição para o JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("detalharAluno.jsp");
			dispatcher.forward(request, response);
            
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
//			DB.closeConnection();
		}
		
	}

	

}
