package classes;

import java.io.Serializable;

public abstract class Produto implements Serializable{
	//Atributos da classe "Produto"
	protected String marca, modelo, fabricante, codigoProduto, preco;
	
	//Construtor
	public Produto(String marca, String modelo, String fabricante, String codigoProduto, String preco) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.codigoProduto = codigoProduto;
		this.preco = preco;
	}
	
	//Método
	public String mostrarProduto() {
		return "Marca do Produto: " + this.marca + "\nModelo do Produto: " + this.modelo + "\nFabricante do Produto: " + this.fabricante + "\nCódigo do Produto: " + this.codigoProduto + "\nPreço do Produto: " + this.preco;
	}

	//Getters e Setters
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}	
	
	
	
	
}
