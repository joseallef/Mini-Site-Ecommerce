package beans;

public class Produto {
	private int codigo;
	private String produto;
	private String preco;
	private String categoria;
	private String descricao;
	private String foto;

	public Produto() {}

	public Produto(int codigo, String produto, String preco,String categoria, String foto, String descricao) {
		this.codigo = codigo;
		this.produto = produto;
		this.preco = preco;
		this.categoria= categoria;
		this.foto = foto;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco= preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria= categoria;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	
	public String toString() {
		
		
		return foto + " - "+codigo+ " - " + produto +  " - " + preco + "-" +categoria + "(" + descricao + ")"; 
	}
}