package classes;

public class PlacaVideo extends Produto {
	//Atributos da classe "PlacaVideo"
	private String qtdMemoriaDeVideo;

	//Construtor da classe "PlacaVideo" herdando atributos da classe-m�e "Produto"
	public PlacaVideo(String marca, String modelo, String fabricante, String codigoProduto, String preco, String qtdMemoriaDeVideo) {
		super(marca, modelo, fabricante, codigoProduto, preco);
		this.qtdMemoriaDeVideo = qtdMemoriaDeVideo;
	}
	
	//M�todo
	public String mostrarProduto() {
		return "\nMarca do Produto: " + this.marca + "\nModelo do Produto: " + this.modelo + "\nFabricante do Produto: " + this.fabricante + "\nC�digo do Produto: " + this.codigoProduto + "\nQuantidade de Mem�ria de V�deo: " + this.qtdMemoriaDeVideo + "\nPre�o do Produto: R$" + this.preco + "\n******************************************************";
	}

	//Getters e Setters
	public String getQtdMemoriaDeVideo() {
		return qtdMemoriaDeVideo;
	}

	public void setQtdMemoriaDeVideo(String qtdMemoriaDeVideo) {
		this.qtdMemoriaDeVideo = qtdMemoriaDeVideo;
	}
	
	
	
}
