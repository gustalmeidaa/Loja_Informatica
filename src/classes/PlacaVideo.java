package classes;

public class PlacaVideo extends Produto {
	//Atributos da classe "PlacaVideo"
	private String qtdMemoriaDeVideo;

	//Construtor da classe "PlacaVideo" herdando atributos da classe-mãe "Produto"
	public PlacaVideo(String marca, String modelo, String fabricante, String codigoProduto, String preco, String qtdMemoriaDeVideo) {
		super(marca, modelo, fabricante, codigoProduto, preco);
		this.qtdMemoriaDeVideo = qtdMemoriaDeVideo;
	}
	
	//Método
	public String mostrarProduto() {
		return "\nMarca do Produto: " + this.marca + "\nModelo do Produto: " + this.modelo + "\nFabricante do Produto: " + this.fabricante + "\nCódigo do Produto: " + this.codigoProduto + "\nQuantidade de Memória de Vídeo: " + this.qtdMemoriaDeVideo + "\nPreço do Produto: R$" + this.preco + "\n******************************************************";
	}

	//Getters e Setters
	public String getQtdMemoriaDeVideo() {
		return qtdMemoriaDeVideo;
	}

	public void setQtdMemoriaDeVideo(String qtdMemoriaDeVideo) {
		this.qtdMemoriaDeVideo = qtdMemoriaDeVideo;
	}
	
	
	
}
