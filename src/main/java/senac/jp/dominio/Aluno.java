package senac.jp.dominio;

public class Aluno {

	private Integer id;
	private String nome;
	private String idade;
	private String genero;
	private String semestre;

	public Aluno() {
	}

	public Aluno(Integer id, String nome, String idade, String genero, String semestre) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.semestre = semestre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", idade=" + idade + ", genero=" + genero + ", semestre="
				+ semestre + "]";
	}
	
	

}
