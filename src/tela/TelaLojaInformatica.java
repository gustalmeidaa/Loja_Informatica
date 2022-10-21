package tela;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Container;
import java.awt.Font;

import javax.swing.*;

import arquivo.LerEscreverObjeto;
import classes.Produto;
import paineis.PainelDeletar;
import paineis.PainelEntrada;
import paineis.PainelFonte;
import paineis.PainelMemoriaRAM;
import paineis.PainelMostrarProdutos;
import paineis.PainelPesquisa;
import paineis.PainelPlacaMae;
import paineis.PainelPlacaVideo;
import paineis.PainelProcessador;

public class TelaLojaInformatica extends JFrame {
	//Atributos
	private Container contentPane;
	private JLabel jlTitulo, jlLogin, jlSenha;
	private JTextField jtfLogin;
	private JPasswordField jpfSenha;
	private JButton jbLogar, jbDica;
	private JMenuBar jmbBarra;
	private JMenu jmArquivo, jmCadastrar, jmExibir, jmAlterar, jmSobre;
	private JMenuItem jmiSair, jmiMostrarProdutos, jmiPesquisar, jmiDeletar, jmiPlacaVideo, jmiProcessador, jmiMemoriaRAM, jmiFonte, jmiPlacaMae, jmiAlterarPlacaVideo, jmiAlterarProcessador, jmiAlterarMemoriaRAM, jmiAlterarFonte, jmiAlterarPlacaMae, jmiAutor, jmiAplicativo;
	private ImageIcon imagemFundo;
	private JLabel jlImagem;
	private List<Produto> produtos = new ArrayList<>(); //Matriz dinâmica usando uma interface list da Java
	private LerEscreverObjeto objeto = new LerEscreverObjeto();
	
	//Construtor
	public TelaLojaInformatica(String title) throws HeadlessException {
		super(title);
		setSize(400, 400);
		setResizable(false); //Desabilita a função de ampliar a tela
		setLayout(null);
		abrirArquivo();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Impede o aplicativo de ser encerrado pelo "X" da janela
		iniciarComponentes();
		criarEventos();
	}
	
	private void abrirArquivo() {
		if (!(objeto.lerArquivo() == null)) {
			this.produtos = objeto.lerArquivo();
		}
															
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		
		//Plano de fundo da tela
		imagemFundo = new ImageIcon(getClass().getResource("/img/teclado.png"));
		jlImagem = new JLabel(imagemFundo);
		jlImagem.setSize(400, 400);
		
		//Campos de inserção do Login e Senha, botão para logar e botão de dica
		jlTitulo = new JLabel("Bem-Vindo"); //Título da tela
		jlTitulo.setHorizontalAlignment(JLabel.CENTER);  //Alinha o texto horizontalmente ao centro
		jlTitulo.setFont(new Font("Arial", Font.BOLD, 18)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(0, 0, 0)); //Setando a cor da fonte
		jlTitulo.setBackground(new Color(51, 233, 255)); //Setando a cor da fonte
		jlTitulo.setOpaque(true);
		jlLogin = new JLabel("Login:");
		jlLogin.setFont(new Font("Sans-Serif", Font.BOLD, 15));
		jlLogin.setForeground(new Color(0, 0, 0));
		jtfLogin = new JTextField();
	    jlSenha = new JLabel("Senha:");
	    jlSenha.setFont(new Font("Sans-Serif", Font.BOLD , 15));
		jlSenha.setForeground(new Color(10, 10, 10));
		jpfSenha = new JPasswordField();
		jbLogar = new JButton("Logar");
		jbLogar.setFont(new Font("Sans-Serif", Font.BOLD , 13));
		jbLogar.setForeground(new Color(0, 0, 0));
		jbLogar.setBackground(new Color(51, 233, 255));
		jbDica = new JButton("Dica");
		jbDica.setFont(new Font("Sans-Serif", Font.BOLD , 13));
		jbDica.setForeground(new Color(0, 0, 0));
		jbDica.setBackground(new Color(51, 233, 255));
		contentPane = getContentPane(); //Através do contentPane é possível manipular o painel
		
		//Configurando a barra de menu
		jmbBarra = new JMenuBar(); //Objeto da barra
		setJMenuBar(jmbBarra); //Insere a barra de menu na tela
		jmArquivo = new JMenu("Arquivo"); //Criando um objeto para o menu
		jmCadastrar = new JMenu("Cadastrar");
		jmExibir = new JMenu("Exibir");
		jmSobre = new JMenu("Sobre");
		jmAlterar = new JMenu("Alterar");

		//Criando o objeto de cada item de menu
		//Itens do menu "Arquivo"
		jmiSair = new JMenuItem("Sair"); //Criando um objeto que serve como item de menu para a opção "Arquivo"
		
		//Itens do menu "Cadastrar"
		jmiPlacaVideo = new JMenuItem("Placa de Vídeo");
		jmiProcessador = new JMenuItem("Processador");
		jmiMemoriaRAM = new JMenuItem("Memória RAM");
		jmiFonte = new JMenuItem("Fonte");
		jmiPlacaMae = new JMenuItem("Placa Mãe");
		
		//Itens do menu "Exibir"
		jmiMostrarProdutos = new JMenuItem("Mostrar Produtos");
		jmiPesquisar = new JMenuItem("Pesquisar");
		jmiDeletar = new JMenuItem("Deletar");
		
		//Itens do menu "Alterar" contido dentro do menu "Exibir"
		jmiAlterarPlacaVideo = new JMenuItem("Placa de Vídeo");
		jmiAlterarProcessador = new JMenuItem("Processador");
		jmiAlterarMemoriaRAM = new JMenuItem("Memória RAM");
		jmiAlterarFonte = new JMenuItem("Fonte");
		jmiAlterarPlacaMae = new JMenuItem("Placa Mãe");
		
		//Itens do menu "Sobre"
		jmiAutor = new JMenuItem("Autor");
		jmiAplicativo = new JMenuItem("Aplicativo");
		
		//Adicionando os menus na barra de menu
		jmbBarra.add(jmArquivo);
		jmbBarra.add(jmCadastrar);
		jmbBarra.add(jmExibir);
		jmbBarra.add(jmSobre);
		jmbBarra.setVisible(false);
		
		//Adicionando as opções dentro de cada item do Menu 
		jmArquivo.add(jmiSair); 
		jmCadastrar.add(jmiPlacaVideo);	
		jmCadastrar.add(jmiProcessador);
		jmCadastrar.add(jmiMemoriaRAM);
		jmCadastrar.add(jmiFonte);
		jmCadastrar.add(jmiPlacaMae);
		jmExibir.add(jmiMostrarProdutos);
		jmExibir.add(jmiPesquisar);
		jmExibir.add(jmiDeletar);
		jmExibir.add(jmAlterar);
		jmAlterar.add(jmiAlterarPlacaVideo);
		jmAlterar.add(jmiAlterarProcessador);
		jmAlterar.add(jmiAlterarMemoriaRAM);
		jmAlterar.add(jmiAlterarFonte);
		jmAlterar.add(jmiAlterarPlacaMae);
		jmSobre.add(jmiAutor);
		jmSobre.add(jmiAplicativo);
				
		//Adicionando os componentes à tela
		add(jlTitulo);
		add(jlLogin);
		add(jtfLogin);
		add(jlSenha);
		add(jpfSenha);
		add(jbLogar);
		add(jbDica);
		add(jlImagem);
				
		//Dimensionando os componentes
		jlTitulo.setBounds(0, 0, 400, 20);  //Coluna, linha, largura, altura
		jlLogin.setBounds(150, 100, 60, 20); 
		jtfLogin.setBounds(150, 120, 80, 20);
		jlSenha.setBounds(150, 160, 60, 20);
		jpfSenha.setBounds(150, 180, 80, 20);
		jbLogar.setBounds(140, 220, 100, 30);
		jbDica.setBounds(250, 300, 100, 30);
		
	}

	private void criarEventos() {
		//Evento da opção "Sair"
		jmiSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Deseja salvar e sair?");
				if (resp == 0) {
					objeto.escreverObjeto(produtos);
					System.exit(0);
				}
			
			}
		});
	
		//Evento do botão "Logar"
		jbLogar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = jtfLogin.getText();
				String senha = jpfSenha.getText();
				if (user.equals("admin") && senha.equals("123")) {
					JOptionPane.showMessageDialog(null, "Bem-Vindo ao sistema!", "Login efetuado com sucesso", JOptionPane.INFORMATION_MESSAGE);
					PainelEntrada entrada = new PainelEntrada();
					contentPane.removeAll();
					contentPane.add(entrada);
					contentPane.validate();
					jmbBarra.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Erro! Login ou senha incorretos.", "Erro no Processo", JOptionPane.ERROR_MESSAGE);
				} 
					
			}
		});
		
		//Evento do botão "Dica"
		jbDica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Login: admin" + "\nSenha: 123", "Dados de Login", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		//Evento do item "Placa de Vídeo"
		jmiPlacaVideo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				PainelPlacaVideo placaVideo = new PainelPlacaVideo(produtos);
				contentPane.removeAll();
				contentPane.add(placaVideo);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Processador"
		jmiProcessador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				PainelProcessador processador = new PainelProcessador(produtos);
				contentPane.removeAll();
				contentPane.add(processador);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Memória RAM"
		jmiMemoriaRAM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				PainelMemoriaRAM memoriaRAM = new PainelMemoriaRAM(produtos);
				contentPane.removeAll();
				contentPane.add(memoriaRAM);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Fonte"
		jmiFonte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				PainelFonte fonte = new PainelFonte(produtos);
				contentPane.removeAll();
				contentPane.add(fonte);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Placa Mãe"
		jmiPlacaMae.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				PainelPlacaMae placaMae = new PainelPlacaMae(produtos);
				contentPane.removeAll();
				contentPane.add(placaMae);
				contentPane.validate();
				
			}
		});
		
		//Evento do item "Mostrar Dados"
		jmiMostrarProdutos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				PainelMostrarProdutos mostrarProdutos = new PainelMostrarProdutos(produtos);
				contentPane.removeAll();
				contentPane.add(mostrarProdutos);
				contentPane.validate();
				
			}
			
			
		});
		
		//Evento do item "Pesquisar"
		jmiPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				PainelPesquisa pesquisa = new PainelPesquisa(produtos);
				contentPane.removeAll();
				contentPane.add(pesquisa);
				contentPane.validate();
				
			}
			
			
		});
		
		//Evento do item "Deletar"
		jmiDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelDeletar deletar = new PainelDeletar(produtos);
				repaint();
				contentPane.removeAll();
				contentPane.add(deletar);
				contentPane.validate();
				
			}

		});
		
		//Evento do item "Alterar Fonte"
		jmiAlterarFonte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelFonte fonte = new PainelFonte(produtos);
				fonte.preencherDados();
				repaint();
				contentPane.removeAll();
				contentPane.add(fonte);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Alterar Memória RAM"
		jmiAlterarMemoriaRAM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelMemoriaRAM memoriaRAM = new PainelMemoriaRAM(produtos);
				memoriaRAM.preencherDados();
				repaint();
				contentPane.removeAll();
				contentPane.add(memoriaRAM);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Placa de Vídeo"
		jmiAlterarPlacaVideo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelPlacaVideo placaVideo = new PainelPlacaVideo(produtos);
				placaVideo.preencherDados();
				repaint();
				contentPane.removeAll();
				contentPane.add(placaVideo);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Alterar Processador"
		jmiAlterarProcessador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelProcessador processador = new PainelProcessador(produtos);
				processador.preencherDados();
				repaint();
				contentPane.removeAll();
				contentPane.add(processador);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Alterar Placa Mãe"
		jmiAlterarPlacaMae.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelPlacaMae placaMae = new PainelPlacaMae(produtos);
				placaMae.preencherDados();
				repaint();
				contentPane.removeAll();
				contentPane.add(placaMae);
				contentPane.validate();
				
			}
			
		});
		
		//Evento do item "Sobre o Autor"
		jmiAutor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Desenvolvedor: Gustavo Heubel Almeida" + "\nAno: 2021" + "\nCurso: Técnico em Desenvolvimento de Sistemas" + "\nUnidade de Ensino: SENAI Professor Dr. Euryclides de Jesus Zerbini", "Sobre o Autor", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("/img/minhafoto.png")));
				
			}
		});
		
		//Evento do item "Sobre o Aplicativo"
		jmiAplicativo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicativo desenvolvido com o objetivo de realizar o cadastro de produtos" + "\ndo meio da informática, com opções de alterar e pesquisar os mesmos.", "Sobre o Aplicativo", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
				
	}
		
}
	
