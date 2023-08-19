package senac.jp.servlet;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("------------- Passei no servlet de login ------------");

		// Senha
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		// Encaminhar a requisição para o JSP
		if (nome.equals("admin") && senha.equals("admin")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("ListarServlet");
			dispatcher.forward(request, response);
		} else {

			request.setAttribute("mensagem", "Senha ou Login incorreto");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
