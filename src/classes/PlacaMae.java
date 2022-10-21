package classes;

public class PlacaMae extends Produto {
	//Atributos da classe "PlacaMae"
	private String tipoPlacaMae;

	//Construtor da classe "PlacaMae" herdando atributos da classe "Produto"
	public PlacaMae(String marca, String modelo, String fabricante, String codigoProduto, String preco, String tipoPlacaMae) {
		super(marca, modelo, fabricante, codigoProduto, preco);
		this.tipoPlacaMae = tipoPlacaMae;
	}
	
	//M�todos
	public String mostrarProduto() {
		return "\nMarca do Produto: " + this.marca + "\nModelo do Produto: " + this.modelo + "\nFabricante do Produto: " + this.fabricante + "\nC�digo do Produto: " + this.codigoProduto + "\nTipo da Placa-M�e: " + this.tipoPlacaMae + "\nPre�o do Produto: " + this.preco + "\n******************************************************";

	}
	
	//Getters e Setters
	public String getTipoPlacaMae() {
		return tipoPlacaMae;
	}

	public void setTipoPlacaMae(String tipoPlacaMae) {
		this.tipoPlacaMae = tipoPlacaMae;
	}
	
	
}
