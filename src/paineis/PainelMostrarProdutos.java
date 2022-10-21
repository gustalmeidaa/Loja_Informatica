package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import classes.Fonte;
import classes.MemoriaRAM;
import classes.PlacaMae;
import classes.PlacaVideo;
import classes.Processador;
import classes.Produto;

public class PainelMostrarProdutos extends JPanel {
	//Atributos
	private JLabel jlTitulo;
	private JButton jbPlacaMae, jbFonte, jbMemoriaRAM, jbProcessador, jbPlacaVideo;
	private JTextArea jtaMostrar;
	private JScrollPane jsMostrar;
	private List<Produto> produtos; //Atributo para guardar o endereço do objeto lista de produtos

	//Construtor
	public PainelMostrarProdutos(List<Produto> produtos) {
		super();
		setSize(400, 400);
		setLayout(null);
		this.produtos = produtos;
		setBackground(new Color(230, 0, 0));
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		jlTitulo = new JLabel("Mostrar Produto"); //Título do painel
		jlTitulo.setFont(new Font("Sans-Serif", Font.BOLD, 14)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(178, 102, 255)); //Setando a cor da fonte
		jbPlacaMae = new JButton("Placa-Mãe");
		jbPlacaMae.setForeground(new Color(245, 245, 245)); //Setando a cor da fonte
		jbPlacaMae.setBackground(Color.BLUE);
		jbFonte = new JButton("Fonte");
		jbFonte.setForeground(new Color(178, 102, 255)); //Setando a cor da fonte
		jbFonte.setBackground(Color.DARK_GRAY);
		jbMemoriaRAM = new JButton("Memória RAM");
		jbMemoriaRAM.setForeground(new Color(0, 0, 0)); //Setando a cor da fonte
		jbMemoriaRAM.setBackground(Color.WHITE);
		jbProcessador = new JButton("Processador");
		jbProcessador.setForeground(new Color(255, 255, 255)); //Setando a cor da fonte
		jbProcessador.setBackground(new Color(0, 200, 0));
		jbPlacaVideo = new JButton("Placa de Vídeo");
		jbPlacaVideo.setForeground(new Color(178, 102, 255)); //Setando a cor da fonte
		jbPlacaVideo.setBackground(Color.BLACK);
		jtaMostrar = new JTextArea();
		jsMostrar = new JScrollPane(jtaMostrar);
		
		//Adicionando os componentes à tela
		add(jbPlacaMae);
		add(jbFonte);
		add(jbMemoriaRAM);
		add(jbProcessador);
		add(jbPlacaVideo);
		add(jsMostrar);
		
		//Dimensionando os componentes da tela
		jlTitulo.setBounds(140, 5, 130, 20); //Coluna, linha, largura, altura
		jbPlacaMae.setBounds(80, 10, 100, 20);
		jbFonte.setBounds(80, 50, 100, 20);
		jbMemoriaRAM.setBounds(200, 10, 115, 20);
		jbProcessador.setBounds(200, 50, 115, 20);
		jbPlacaVideo.setBounds(80, 85, 120, 20);
		jsMostrar.setBounds(20, 120, 340, 210);
	}

	private void criarEventos() {
		jbPlacaMae.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("***************************Placa Mãe****************************");
				for (Produto produto : produtos) {
					if (produto instanceof PlacaMae) {
						jtaMostrar.append(produto.mostrarProduto()); 
					}
				}
				
			}
		});
		
		jbFonte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("****************************Fonte********************************");
				for (Produto produto : produtos) {
					if (produto instanceof Fonte) {
						jtaMostrar.append(produto.mostrarProduto()); 
					}
				}
			}
		});
		
		jbMemoriaRAM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("***************************Memória RAM*************************");
				for (Produto produto : produtos) {
					if (produto instanceof MemoriaRAM) {
						jtaMostrar.append(produto.mostrarProduto()); 
					}
				}
			}
		});
		
		jbProcessador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("*************************Processador****************************");
				for (Produto produto : produtos) {
					if (produto instanceof Processador) {
						jtaMostrar.append(produto.mostrarProduto()); 
					}
				}
			}
		});
		
		jbPlacaVideo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("***********************Placa de Vídeo***************************");
				for (Produto produto : produtos) {
					if (produto instanceof PlacaVideo) {
						jtaMostrar.append(produto.mostrarProduto()); 
					}
				}
			}
		});
		
	}
	
	
}
