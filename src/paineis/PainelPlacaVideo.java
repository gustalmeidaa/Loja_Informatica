package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import classes.Produto;
import classes.PlacaVideo;

public class PainelPlacaVideo extends JPanel {
	//Atributos
	private JLabel jlMarca, jlModelo, jlFabricante, jlPreco, jlQtdMemoriaVideo, jlTitulo, jlCodigoProduto;
	private JTextField jtfPreco, jtfModelo, jtfCodigoProduto;
	private JRadioButton jrbNvidia, jrbAmd, jrbGalak, jrbAsus, jrb2GB, jrb4GB, jrb8GB;
	private JButton jbCadastrar, jbAlterar;
	private PlacaVideo placaVideo;
	private ButtonGroup bgMarca, bgQtdMemoriaVideo, bgFabricante;
	private ImageIcon imagemFundo;
	private JLabel jlImagem;
	private List<Produto> produtos;
	
	//Construtor
	public PainelPlacaVideo(List<Produto> produtos) {
		super();
		setSize(400, 400);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		jlTitulo = new JLabel("Placa de Vídeo"); //Título do painel
		jlTitulo.setHorizontalAlignment(JLabel.CENTER); //Alinha o texto horizontalmente ao centro
		jlTitulo.setFont(new Font("Arial", Font.ITALIC, 18)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(178, 102, 255)); //Setando a cor da fonte
		jlTitulo.setBackground(Color.BLACK);
		jlTitulo.setOpaque(true);
		
		//Plano de fundo do painel
		imagemFundo = new ImageIcon(getClass().getResource("/img/placa_video.png"));
		jlImagem = new JLabel(imagemFundo);
		jlImagem.setSize(400, 400);
		
		//Configuração da primeira linha 
		bgMarca = new ButtonGroup();
		jlMarca = new JLabel("Marca");
		jrbNvidia = new JRadioButton("NVIDIA", true);
		jrbNvidia.setOpaque(false);
		jrbAmd = new JRadioButton("AMD");
		jrbAmd.setOpaque(false);
		bgFabricante = new ButtonGroup();
		jlFabricante = new JLabel("Fabricante");
		jrbGalak = new JRadioButton("Galak",true);
		jrbGalak.setOpaque(false);
		jrbAsus = new JRadioButton("Asus");
		jrbAsus.setOpaque(false);
		bgQtdMemoriaVideo = new ButtonGroup();
		jlQtdMemoriaVideo = new JLabel("Memória de Vídeo");
		jrb2GB = new JRadioButton("2GB",true);
		jrb2GB.setOpaque(false);
		jrb4GB = new JRadioButton("4GB");
		jrb4GB.setOpaque(false);
		jrb8GB = new JRadioButton("8GB");
		jrb8GB.setOpaque(false);
		
		//Configuração da segunda linha
		jlModelo = new JLabel("Modelo");
		jtfModelo = new JTextField();
		jlPreco = new JLabel("Preço");
		jtfPreco = new JTextField();
		jlCodigoProduto = new JLabel("Código do Produto");
		jtfCodigoProduto = new JTextField();
		
		//Configuração da terceira linha
		jbCadastrar = new JButton("Cadastrar");
		jbCadastrar.setForeground(new Color(178, 102, 255));
		jbCadastrar.setBackground(new Color(0, 0, 0));
		jbAlterar = new JButton("Alterar");
		jbAlterar.setForeground(new Color(178, 102, 255));
		jbAlterar.setBackground(new Color(0, 0, 0));
		
		//Adicionando os botões em seus respectivos grupos
		bgMarca.add(jrbNvidia);
		bgMarca.add(jrbAmd);
		
		bgQtdMemoriaVideo.add(jrb2GB);
		bgQtdMemoriaVideo.add(jrb4GB);
		bgQtdMemoriaVideo.add(jrb8GB);
		
		bgFabricante.add(jrbGalak);
		bgFabricante.add(jrbAsus);
		
		//Adicionando os componentes à tela
		add(jlTitulo);
		add(jlMarca);
		add(jrbNvidia);
		add(jrbAmd);
		add(jlModelo);
		add(jtfModelo);
		add(jlFabricante);
		add(jrbGalak);
		add(jrbAsus);
		add(jlPreco);
		add(jtfPreco);
		add(jlQtdMemoriaVideo);
		add(jrb2GB);
		add(jrb4GB);
		add(jrb8GB);
		add(jlCodigoProduto);
		add(jtfCodigoProduto);
		add(jbCadastrar);
		add(jbAlterar);
		add(jlImagem);
		
		//Dimensionando os componentes à tela
		
		jlTitulo.setBounds(0, 0, 400, 20); //Coluna, linha, largura, altura
		jlMarca.setBounds(80, 40, 60, 20); 
		jrbNvidia.setBounds(80, 60, 70, 20);
		jrbAmd.setBounds(80, 80, 80, 20);
		jlFabricante.setBounds(160, 40, 60, 20);
		jrbGalak.setBounds(160, 60, 60, 20);
		jrbAsus.setBounds(160, 80, 60, 20);
		jlQtdMemoriaVideo.setBounds(240, 40, 150, 20);
		jrb2GB.setBounds(240, 60, 60, 20);
		jrb4GB.setBounds(240, 80, 60, 20);
		jrb8GB.setBounds(240, 100, 60, 20);
		jlModelo.setBounds(80, 140, 60, 20);
		jtfModelo.setBounds(80, 160, 60, 20);
		jlPreco.setBounds(160, 140, 60, 20);
		jtfPreco.setBounds(160, 160, 60, 20);
		jlCodigoProduto.setBounds(240, 140, 110, 20);
		jtfCodigoProduto.setBounds(240, 160, 100, 20);
		jbCadastrar.setBounds(145, 230, 100, 30);
		jbAlterar.setBounds(145, 230, 100, 30);
		
	}

	private void criarEventos() {
		//Evento do botão "Cadastrar"
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!jtfModelo.getText().isEmpty() &&
					!jtfPreco.getText().isEmpty()) {
					String marca, modelo, fabricante, codigoProduto = null, preco, qtdMemoriaDeVideo = null;
					
					modelo = jtfModelo.getText();
					codigoProduto = jtfCodigoProduto.getText();
					preco = jtfPreco.getText().trim();
					
					if (jrbNvidia.isSelected()) {
						marca = "NVIDIA";
					} else {
						marca = "AMD";
					}
					
					
					if (jrbGalak.isSelected()) {
						fabricante = "Galak";
					} else {
						fabricante = "Asus";
					}
					
					if (jrb2GB.isSelected()) qtdMemoriaDeVideo = "2GB";
					if (jrb4GB.isSelected()) qtdMemoriaDeVideo = "4GB";
					if (jrb8GB.isSelected()) qtdMemoriaDeVideo = "8GB";
					
					produtos.add(new PlacaVideo(marca, modelo, fabricante, codigoProduto, preco, qtdMemoriaDeVideo));
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Cadastro bem-sucedido", JOptionPane.INFORMATION_MESSAGE);
					jtfModelo.setText("");
					jtfPreco.setText("");
					jtfCodigoProduto.setText("");
					
				} else {
					JOptionPane.showMessageDialog(null, "Erro! Preencha todos os campos.", "Erro no Processo", JOptionPane.ERROR_MESSAGE);

				}
				
				
			}
			
		});
		
		//Evento do botão "Alterar"
		jbAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String marca = null;
				if (jrbNvidia.isSelected()) marca = "NVIDIA";
				if (jrbAmd.isSelected()) marca = "AMD";
				placaVideo.setMarca(marca);
				
				String fabricante = null;
				if (jrbGalak.isSelected()) fabricante = "Galak";
				if (jrbAsus.isSelected()) fabricante = "Asus";
				placaVideo.setFabricante(fabricante);
				
				String qtdMemoriaDeVideo = null;
				if (jrb2GB.isSelected()) qtdMemoriaDeVideo = "2GB";
				if (jrb4GB.isSelected()) qtdMemoriaDeVideo = "4GB";
				if (jrb8GB.isSelected()) qtdMemoriaDeVideo = "8GB";
				placaVideo.setQtdMemoriaDeVideo(qtdMemoriaDeVideo);
				
				placaVideo.setModelo(jtfModelo.getText());
				placaVideo.setPreco(jtfPreco.getText());
				placaVideo.setCodigoProduto(jtfCodigoProduto.getText());
				
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
				
			}
	
		});
		
	}

	public void preencherDados() {
		jbCadastrar.setVisible(false);
		try {
			int indice = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do produto que deseja alterar"));
			
			//Setando a Marca do Produto
			if (produtos.get(indice - 1).getMarca().equals("NVIDIA")) 
				jrbNvidia.setSelected(true);
			if (produtos.get(indice - 1).getMarca().equals("AMD"))
				jrbAmd.setSelected(true);
			
			//Setando o Fabricante do Produto
			if (produtos.get(indice -1).getFabricante().equals("Galak")) 
				jrbGalak.setSelected(true);
			if (produtos.get(indice - 1).getFabricante().equals("Asus")) 
				jrbAsus.setSelected(true);
			
			//Setando a capacidade de saída
			placaVideo = (PlacaVideo) produtos.get(indice - 1);
			if(placaVideo.getQtdMemoriaDeVideo().equals("2GB"))
				jrb2GB.setSelected(true);
			if (placaVideo.getQtdMemoriaDeVideo().equals("4GB"))
				jrb4GB.setSelected(true);
			if(placaVideo.getQtdMemoriaDeVideo().equals("8GB"))
				jrb8GB.setSelected(true);
			
			jtfModelo.setText(produtos.get(indice - 1).getModelo());
			jtfPreco.setText(produtos.get(indice - 1).getPreco());
			jtfCodigoProduto.setText(produtos.get(indice - 1).getCodigoProduto());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Campo vazio ou preenchido incorretamente. Utilize apenas números.", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Índice inexistente!", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (ClassCastException e) {
			JOptionPane.showMessageDialog(null, "Este indice não pertence ao produto selecionado", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
}
