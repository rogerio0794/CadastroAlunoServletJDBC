package senac.jp.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private static Connection conn = null;

	
	// criar metodo estaticos para conectar com o banco de dados
	public static Connection getConnection() {
		if (conn == null) {
			try {	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastroalunos","aluno","aluno");
				System.out.println("Conectado");
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	// Fechar a conex�o
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Conexão com o banco de dados encerrada");

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

	}

	// Fechar o ResultSET
	public static void closeResultSet(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

	}
	
	// Fechar o Statement
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

	}

}
