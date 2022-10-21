package classes;

public class Fonte extends Produto {
	//Atributos da classe "Fonte"
	private String capacidade;

	//Construtor da classe "Fonte" herdando atributos da classe "Produto"
	public Fonte(String marca, String modelo, String fabricante, String codigoProduto, String preco, String capacidade) {
		super(marca, modelo, fabricante, codigoProduto, preco);
		this.capacidade = capacidade;
	}
	
	//Métodos
	public String mostrarProduto() {
		return "\nMarca do Produto: " + this.marca + "\nModelo do Produto: " + this.modelo + "\nFabricante do Produto: " + this.fabricante + "\nCódigo do Produto: " + this.codigoProduto + "\nCapacidade de Saída: " + this.capacidade + "\nPreço do Produto: R$" + this.preco + "\n******************************************************";

		}
	
   //Getters e Setters
	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
}

