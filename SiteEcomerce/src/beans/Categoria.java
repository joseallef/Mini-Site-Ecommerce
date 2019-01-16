package beans;

public class Categoria {
	private String nome;
	private int codigo;
	private String linha;
	private String faixa;

	public Categoria() {}

	public Categoria(String nome, int codigo, String linha, String faixa) {
		this.nome = nome;
		this.codigo = codigo;
		this.linha = linha;
		this.faixa = faixa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getFaixa() {
		return faixa;
	}

	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}


	
	public String toString() {
		
		
		return nome + " - " + codigo +  " - " + linha +  "(" + faixa + ")"; 
	}
}