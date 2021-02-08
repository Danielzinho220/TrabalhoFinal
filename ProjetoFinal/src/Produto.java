
public class Produto {
	private String nome;
	private double preco;
	private int quantidade;
	private int codigo;

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {

		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {

		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getCodigo() {

		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Produto(String nome, double preco, int quantidade, int codigo) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.codigo = codigo;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

}