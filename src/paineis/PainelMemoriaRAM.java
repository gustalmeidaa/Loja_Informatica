package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import classes.MemoriaRAM;
import classes.Produto;

public class PainelMemoriaRAM extends JPanel {
	//Atributos
	private JLabel jlMarca, jlModelo, jlFabricante, jlPreco, jlQtdMemoria, jlTitulo, jlCodigoProduto;
	private JTextField jtfPreco, jtfModelo, jtfCodigoProduto;
	private JRadioButton jrbHyperX, jrbAdata, jrbFabAdata, jrbKingston, jrb2GB, jrb4GB, jrb8GB;
	private JButton jbCadastrar, jbAlterar;
	private MemoriaRAM memoriaRAM;
	private ButtonGroup bgMarca, bgQtdMemoria, bgFabricante;
	private ImageIcon imagemFundo;
	private JLabel jlImagem;
	private List<Produto> produtos;
	
	//Construtor
	public PainelMemoriaRAM(List<Produto> produtos) {
		super();
		setSize(400, 400);
		setLayout(null);
		setBackground(new Color(104, 249, 187));
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		jlTitulo = new JLabel("Memória RAM"); //Título do painel
		jlTitulo.setHorizontalAlignment(JLabel.CENTER); //Alinha o texto horizontalmente ao centro
		jlTitulo.setFont(new Font("Arial", Font.ITALIC, 18)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(0, 0, 0)); //Setando a cor da fonte
		jlTitulo.setBackground(Color.WHITE); //Setando uma cor de fundo
		jlTitulo.setOpaque(true);
		
		//Plano de fundo do painel
		imagemFundo = new ImageIcon(getClass().getResource("/img/memoriaram.png"));
		jlImagem = new JLabel(imagemFundo);
		jlImagem.setSize(400, 400);
		
		//Configuração da primeira linha
		jlMarca = new JLabel("Marca");
		jrbAdata = new JRadioButton("Adata",true);
		jrbAdata.setOpaque(false);
		jrbHyperX = new JRadioButton("HyperX");
		jrbHyperX.setOpaque(false);
		bgMarca = new ButtonGroup();
		
		jlFabricante = new JLabel("Fabricante");
		jrbFabAdata = new JRadioButton("Adata",true);
		jrbFabAdata.setOpaque(false);
		jrbKingston = new JRadioButton("Kingston");
		jrbKingston.setOpaque(false);
		bgFabricante = new ButtonGroup();
		
		jlQtdMemoria = new JLabel("Quantidade de Memória");
		jrb2GB = new JRadioButton("2GB",true);
		jrb2GB.setOpaque(false);
		jrb4GB = new JRadioButton("4GB");
		jrb4GB.setOpaque(false);
		jrb8GB = new JRadioButton("8GB");
		jrb8GB.setOpaque(false);
		bgQtdMemoria = new ButtonGroup();
		
		//Configuração da segunda linha
		jlModelo = new JLabel("Modelo");
		jtfModelo = new JTextField();
		
		jlPreco = new JLabel("Preço");
		jtfPreco = new JTextField();
		
		jlCodigoProduto = new JLabel("Código do Produto");
		jtfCodigoProduto = new JTextField();
		
		//Configuração da terceira linha
		jbCadastrar = new JButton("Cadastrar");
		jbAlterar = new JButton("Alterar");
		
		//Adicionando os botões a seus respectivos grupos
		bgMarca.add(jrbAdata);
		bgMarca.add(jrbHyperX);
		
		bgQtdMemoria.add(jrb2GB);
		bgQtdMemoria.add(jrb4GB);
		bgQtdMemoria.add(jrb8GB);
		
		bgFabricante.add(jrbFabAdata);
		bgFabricante.add(jrbKingston);
		
		
		//Adicionando os componentes à tela
		add(jlTitulo);
		add(jlMarca);
		add(jrbAdata);
		add(jrbHyperX);
		add(jlFabricante);
		add(jrbFabAdata);
		add(jrbKingston);
		add(jlQtdMemoria);
		add(jrb2GB);
		add(jrb4GB);
		add(jrb8GB);
		add(jlModelo);
		add(jtfModelo);
		add(jlPreco);
		add(jtfPreco);
		add(jlCodigoProduto);
		add(jtfCodigoProduto);
		add(jbCadastrar);
		add(jbAlterar);
		add(jlImagem);
		
		//Dimensionando os componentes
		jlTitulo.setBounds(0, 0, 400, 20); //Coluna, linha, largura, altura
		jlMarca.setBounds(50, 40, 60, 20); 
		jrbAdata.setBounds(50, 60, 70, 20);
		jrbHyperX.setBounds(50, 80, 80, 20);
		jlFabricante.setBounds(130, 40, 60, 20);
		jrbFabAdata.setBounds(130, 60, 60, 20);
		jrbKingston.setBounds(130, 80, 80, 20);
		jlQtdMemoria.setBounds(210, 40, 150, 20);
		jrb2GB.setBounds(210, 60, 60, 20);
		jrb4GB.setBounds(210, 80, 60, 20);
		jrb8GB.setBounds(210, 100, 60, 20);
		jlModelo.setBounds(50, 140, 60, 20);
		jtfModelo.setBounds(50, 160, 60, 20);
		jlPreco.setBounds(130, 140, 60, 20);
		jtfPreco.setBounds(130, 160, 60, 20);
		jlCodigoProduto.setBounds(210, 140, 110, 20);
		jtfCodigoProduto.setBounds(210, 160, 100, 20);
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
					String marca, modelo, fabricante, codigoProduto = null, preco, qtdMemoria = null;
					
					modelo = jtfModelo.getText();
					codigoProduto = jtfCodigoProduto.getText();
					preco = jtfPreco.getText().trim();
					
					if (jrbAdata.isSelected()) {
						marca = "Adata";
					} else {
						marca = "HyperX";
					}
					
					if (jrbFabAdata.isSelected()) {
						fabricante = "Adata";
					} else {
						fabricante = "Kingston";
					}
					
					if (jrb2GB.isSelected()) qtdMemoria = "2GB";
					if (jrb4GB.isSelected()) qtdMemoria = "4GB";
					if (jrb8GB.isSelected()) qtdMemoria = "8GB";
					
					produtos.add(new MemoriaRAM(marca, modelo, fabricante, codigoProduto, preco, qtdMemoria));
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
				if (jrbAdata.isSelected()) marca = "Adata";
				if (jrbHyperX.isSelected()) marca = "HyperX";
				memoriaRAM.setMarca(marca);
				
				String fabricante = null;
				if (jrbFabAdata.isSelected()) fabricante = "Adata";
				if (jrbKingston.isSelected()) fabricante = "Kingston";
				memoriaRAM.setFabricante(fabricante);
				
				String qtdMemoria = null;
				if (jrb2GB.isSelected()) qtdMemoria = "2GB";
				if (jrb4GB.isSelected()) qtdMemoria = "4GB";
				if (jrb8GB.isSelected()) qtdMemoria = "8GB";
				memoriaRAM.setQtdMemoria(qtdMemoria);
				
				memoriaRAM.setModelo(jtfModelo.getText());
				memoriaRAM.setPreco(jtfPreco.getText());
				memoriaRAM.setCodigoProduto(jtfCodigoProduto.getText());
				
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
				
			}
	
		});
		
		
	}

	public void preencherDados() {
		jbCadastrar.setVisible(false);
		try {
			int indice = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do produto que deseja alterar"));
			
			//Setando a Marca do Produto
			if (produtos.get(indice - 1).getMarca().equals("Adata")) 
				jrbAdata.setSelected(true);
			if (produtos.get(indice - 1).getMarca().equals("HyperX"))
				jrbHyperX.setSelected(true);
			
			//Setando o Fabricante do Produto
			if (produtos.get(indice -1).getFabricante().equals("Adata")) 
				jrbFabAdata.setSelected(true);
			if (produtos.get(indice - 1).getFabricante().equals("Kingston")) 
				jrbKingston.setSelected(true);
			
			//Setando a quantidade de memória
			memoriaRAM = (MemoriaRAM) produtos.get(indice - 1);
			if(memoriaRAM.getQtdMemoria().equals("2GB"))
				jrb2GB.setSelected(true);
			if (memoriaRAM.getQtdMemoria().equals("4GB"))
				jrb4GB.setSelected(true);
			if(memoriaRAM.getQtdMemoria().equals("8GB"))
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
