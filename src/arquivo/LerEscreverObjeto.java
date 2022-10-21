package arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Produto;

public class LerEscreverObjeto {
	public void escreverObjeto(List<Produto> produtos) {
		FileOutputStream saida;
		try {
			saida = new FileOutputStream("Produtos.bin"); //Nome do arquivo
			ObjectOutputStream objeto = new ObjectOutputStream(saida) ;
			objeto.writeObject(produtos);
			objeto.close();
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Arquivo", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo corrompido!", "Arquivo", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
	}
	
	public List<Produto> lerArquivo() {
		List<Produto> produtos = null;
		try {
			FileInputStream entrada = new FileInputStream("Produtos.bin");
			ObjectInputStream objeto = new ObjectInputStream(entrada);
			produtos = (List<Produto>) objeto.readObject();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Arquivo", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo corrompido!", "Arquivo", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe não encontrada", "Arquivo", JOptionPane.ERROR_MESSAGE);
		}
		return produtos;
	}
	
}
