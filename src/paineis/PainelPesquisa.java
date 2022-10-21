package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import classes.Produto;

public class PainelPesquisa extends JPanel {
	//Atributos
	private JLabel jlTitulo, jlCodigoProduto;
	private JTextField jtfCodigoProduto;
	private JTextArea jtaMostrar;
	private JScrollPane jsMostrar;
	private JButton jbPesquisar;
	private List<Produto> produtos;
	
	//Construtor
	public PainelPesquisa(List<Produto> produtos) {
		super();
		setSize(400, 400);
		setLayout(null);
		this.produtos = produtos;
		setBackground(new Color(132, 250, 233));
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		jlTitulo = new JLabel("Pesquisa"); //Título do painel
		jlTitulo.setHorizontalAlignment(JLabel.CENTER);
		jlTitulo.setFont(new Font("Arial", Font.ITALIC, 18)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(255, 255, 255)); //Setando a cor da fonte
		jlTitulo.setBackground(new Color(5, 134, 140));
		jlTitulo.setOpaque(true);
		jlCodigoProduto = new JLabel("Código do Produto");
		jtfCodigoProduto = new JTextField();
		jbPesquisar = new JButton("Pesquisar");
		jtaMostrar = new JTextArea();
		jsMostrar = new JScrollPane(jtaMostrar);
		
		//Adicionando os componentes à tela
		add(jlTitulo);
		add(jlCodigoProduto);
		add(jtfCodigoProduto);
		add(jbPesquisar);
		add(jsMostrar);
		
		//Dimensionando os componentes na tela
		jlTitulo.setBounds(0, 0, 400, 20); //Coluna, linha, largura, altura
		jlCodigoProduto.setBounds(40, 40, 120, 20);
		jtfCodigoProduto.setBounds(40, 60, 80, 20);
		jbPesquisar.setBounds(40, 100, 100, 20);
		jsMostrar.setBounds(40, 140, 300, 180);
		
	}

	private void criarEventos() {
		jbPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean achou = false;
				for (Produto produto : produtos) {
					if (produto.getCodigoProduto().equals(jtfCodigoProduto.getText())) {
						jtaMostrar.append("\n"+(produtos.indexOf(produto)+1)+"- Índice do Produto"+produto.mostrarProduto());
						achou = true;
						break;
					} 
				}
				if (!achou) JOptionPane.showMessageDialog(null, "Produto não encontrado!", "ERRO", JOptionPane.WARNING_MESSAGE); 
			
			}
		});
		
	}
	
	
}
