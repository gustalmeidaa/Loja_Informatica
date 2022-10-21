package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import classes.Fonte;
import classes.Produto;

public class PainelFonte extends JPanel {
	//Atributos
	private JLabel jlMarca, jlModelo, jlFabricante, jlPreco, jlCapacidadeSaida, jlTitulo, jlCodigoProduto;
	private JTextField jtfPreco, jtfModelo, jtfCodigoProduto;
	private JRadioButton jrbAzza, jrbCougar, jrbMancer, jrbAsus, jrb500W, jrb550W, jrb600W;
	private JButton jbCadastrar, jbAlterar;
	private ButtonGroup bgMarca, bgCapacidadeSaida, bgFabricante;
	private Fonte fonte;
	private ImageIcon imagemFundo;
	private JLabel jlImagem;
	private List<Produto> produtos;
	
	//Construtor
	public PainelFonte(List<Produto> produtos) {
		super();
		setSize(400, 400);
		setLayout(null);
		setBackground(new Color(222, 254, 143));
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		jlTitulo = new JLabel("Fonte"); //Título do painel
		jlTitulo.setHorizontalAlignment(JLabel.CENTER); //Alinha o texto horizontalmente ao centro
		jlTitulo.setFont(new Font("Arial", Font.ITALIC, 18)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(178, 102, 255)); //Setando a cor da fonte
		jlTitulo.setBackground(Color.DARK_GRAY);
		jlTitulo.setOpaque(true);
		
		//Plano de fundo do painel
		imagemFundo = new ImageIcon(getClass().getResource("/img/fonte.png"));
		jlImagem = new JLabel(imagemFundo);
		jlImagem.setSize(400, 400);
		
		//Configuração da primeira linha do programa
		jlMarca = new JLabel("Marca");
		jrbAzza = new JRadioButton("Azza",true);
		jrbAzza.setOpaque(false);
		jrbCougar = new JRadioButton("Cougar");
		jrbCougar.setOpaque(false);
		bgMarca = new ButtonGroup();
		
		jlFabricante = new JLabel("Fabricante");
		jrbMancer = new JRadioButton("Mancer",true);
		jrbMancer.setOpaque(false);
		jrbAsus = new JRadioButton("Asus");
		jrbAsus.setOpaque(false);
		bgFabricante = new ButtonGroup();
		
		jlCapacidadeSaida = new JLabel("Capacidade de Saída");
		jrb500W = new JRadioButton("500W",true);
		jrb500W.setOpaque(false);
		jrb550W = new JRadioButton("550W");
		jrb550W.setOpaque(false);
		jrb600W = new JRadioButton("600W");
		jrb600W.setOpaque(false);
		bgCapacidadeSaida = new ButtonGroup();
		
		//Configuração da segunda linha do programa
		jlModelo = new JLabel("Modelo");
		jtfModelo = new JTextField();
		
		jlPreco = new JLabel("Preço");
		jtfPreco = new JTextField();
		
		jlCodigoProduto = new JLabel("Código do Produto");
		jtfCodigoProduto = new JTextField();
		
		jbCadastrar = new JButton("Cadastrar");
		jbAlterar = new JButton("Alterar");
		
		//Adicionando os botões em seus respectivos grupos
		bgMarca.add(jrbAzza);
		bgMarca.add(jrbCougar);
		
		bgFabricante.add(jrbMancer);
		bgFabricante.add(jrbAsus);
				
		bgCapacidadeSaida.add(jrb500W);
		bgCapacidadeSaida.add(jrb550W);
		bgCapacidadeSaida.add(jrb600W);
		
		//Adicionando os componentes à tela
		add(jlTitulo);
		add(jlMarca);
		add(jrbAzza);
		add(jrbCougar);
		add(jlModelo);
		add(jtfModelo);
		add(jlFabricante);
		add(jrbMancer);
		add(jrbAsus);
		add(jlPreco);
		add(jtfPreco);
		add(jlCodigoProduto);
		add(jtfCodigoProduto);
		add(jlCapacidadeSaida);
		add(jrb500W);
		add(jrb550W);
		add(jrb600W);
		add(jbCadastrar);
		add(jbAlterar);
		add(jlImagem);
	    
		//Dimensionando os componentes à tela
		
		jlTitulo.setBounds(0, 0, 400, 20); //Coluna, linha, largura, altura
		jlMarca.setBounds(80, 40, 60, 20); 
		jrbAzza.setBounds(80, 60, 70, 20);
		jrbCougar.setBounds(80, 80, 80, 20);
		jlFabricante.setBounds(160, 40, 60, 20);
		jrbMancer.setBounds(160, 60, 80, 20);
		jrbAsus.setBounds(160, 80, 60, 20);
		jrbAsus.setBounds(160, 80, 60, 20);
		jlCapacidadeSaida.setBounds(240, 40, 150, 20);
		jrb500W.setBounds(240, 60, 60, 20);
		jrb550W.setBounds(240, 80, 60, 20);
		jrb600W.setBounds(240, 100, 60, 20);
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
					String marca, modelo, fabricante, codigoProduto = null, preco, capacidade = null;
					
					modelo = jtfModelo.getText();
					codigoProduto = jtfCodigoProduto.getText();
					preco = jtfPreco.getText().trim();
					
					if (jrbAzza.isSelected()) {
						marca = "Azza";
					} else {
						marca = "Cougar";
					}
					
					if (jrbMancer.isSelected()) {
						fabricante = "Mancer";
					} else {
						fabricante = "Asus";
					}
					
					if (jrb500W.isSelected()) capacidade = "500W";
					if (jrb550W.isSelected()) capacidade = "550W";
					if (jrb600W.isSelected()) capacidade = "600W";
					
					produtos.add(new Fonte(marca, modelo, fabricante, codigoProduto, preco, capacidade));
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
				if (jrbAzza.isSelected()) marca = "Azza";
				if (jrbCougar.isSelected()) marca = "Cougar";
				fonte.setMarca(marca);
				
				String fabricante = null;
				if (jrbMancer.isSelected()) fabricante = "Mancer";
				if (jrbAsus.isSelected()) fabricante = "Asus";
				fonte.setFabricante(fabricante);
				
				String capacidade = null;
				if (jrb500W.isSelected()) capacidade = "500W";
				if (jrb550W.isSelected()) capacidade = "550W";
				if (jrb600W.isSelected()) capacidade = "600W";
				fonte.setCapacidade(capacidade);
				
				fonte.setModelo(jtfModelo.getText());
				fonte.setPreco(jtfPreco.getText());
				fonte.setCodigoProduto(jtfCodigoProduto.getText());
				
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
				
			}
	
		});
		
	}

	public void preencherDados() {
		jbCadastrar.setVisible(false);
		try {
			int indice = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do produto que deseja alterar"));
			
			//Setando a Marca do Produto
			if (produtos.get(indice - 1).getMarca().equals("Azza")) 
				jrbAzza.setSelected(true);
			if (produtos.get(indice - 1).getMarca().equals("Cougar"))
				jrbCougar.setSelected(true);
			
			//Setando o Fabricante do Produto
			if (produtos.get(indice -1).getFabricante().equals("Mancer")) 
				jrbMancer.setSelected(true);
			if (produtos.get(indice - 1).getFabricante().equals("Asus")) 
				jrbAsus.setSelected(true);
			
			//Setando a capacidade de saída
			fonte = (Fonte) produtos.get(indice - 1);
			if(fonte.getCapacidade().equals("500W"))
				jrb500W.setSelected(true);
			if (fonte.getCapacidade().equals("550W"))
				jrb550W.setSelected(true);
			if(fonte.getCapacidade().equals("600W"))
				jrb600W.setSelected(true);
			
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
	
