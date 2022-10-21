package classes;

public class Processador extends Produto {
	//Atributos
	private String geracao, nucleos;
	
	//Construtor da classe "Processador" herdando 
	public Processador(String marca, String modelo, String fabricante, String codigoProduto, String preco, String geracao, String nucleos) {
		super(marca, modelo, fabricante, codigoProduto, preco);
		this.geracao = geracao;
		this.nucleos = nucleos;
	}
	
	//Métodos
	public String mostrarProduto() {
		return "\nMarca do Produto: " + this.marca + "\nModelo do Produto: " + this.modelo + "\nFabricante do Produto: " + this.fabricante + "\nCódigo do Produto: " + this.codigoProduto + "\nQuantidade de Núcleos: " + this.nucleos + "\nGeração do Processador: " + this.geracao + "\nPreço do Produto: R$" + this.preco + "\n******************************************************";

	}

	//Getters e Setters
	public String getGeracao() {
		return geracao;
	}

	public void setGeracao(String geracao) {
		this.geracao = geracao;
	}

	public String getNucleos() {
		return nucleos;
	}

	public void setNucleos(String nucleos) {
		this.nucleos = nucleos;
	}
	
	
	
	
}

	