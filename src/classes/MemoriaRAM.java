package classes;

public class MemoriaRAM extends Produto{
	//Atributos da classe "MemoriaRAM"
	private String qtdMemoria;
	
	//Construtor da classe "MemoriaRAM" herdando atributos da classe "Produto"
	public MemoriaRAM(String marca, String modelo, String fabricante, String codigoProduto, String preco, String qtdMemoria) {
		super(marca, modelo, fabricante, codigoProduto, preco);
		this.qtdMemoria = qtdMemoria;
	}
	
	//Métodos
	public String mostrarProduto() {
		return "\nMarca do Produto: " + this.marca + "\nModelo do Produto: " + this.modelo + "\nFabricante do Produto: " + this.fabricante + "\nCódigo do Produto: " + this.codigoProduto + "\nQuantidade de Memória: " + this.qtdMemoria + "\nPreço do Produto: R$" + this.preco + "\n******************************************************";

	}

	//Getters e Setters
	public String getQtdMemoria() {
		return qtdMemoria;
	}

	public void setQtdMemoria(String qtdMemoria) {
		this.qtdMemoria = qtdMemoria;
	}
		
	
	
	
}
