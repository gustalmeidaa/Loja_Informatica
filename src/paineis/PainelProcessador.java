package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import classes.Processador;
import classes.Produto;

public class PainelProcessador extends JPanel {
	//Atributos
	private JLabel jlMarca, jlModelo, jlFabricante, jlPreco, jlGeracao, jlNucleos, jlTitulo, jlCodigoProduto;
	private JTextField jtfPreco, jtfModelo, jtfGeracao, jtfCodigoProduto;
	private JRadioButton jrbIntel, jrbAmd, jrbSingleCore, jrbDualCore, jrbQuadCore, jrbTSMC;
	private JButton jbCadastrar, jbAlterar;
	private Processador processador;
	private ButtonGroup bgMarca, bgNucleos, bgFabricante;
	private ImageIcon imagemFundo;
	private JLabel jlImagem;
	private List<Produto> produtos;
	
	//Construtor
	public PainelProcessador(List<Produto> produtos) {
		super();
		setSize(400, 400);
		setLayout(null);
		setBackground(new Color(196, 159, 246));
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		jlTitulo = new JLabel("Processador"); //Título do painel
		jlTitulo.setHorizontalAlignment(JLabel.CENTER); //Alinha o texto horizontalmente ao centro
		jlTitulo.setFont(new Font("Arial", Font.ITALIC, 18)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(255, 255, 255)); //Setando a cor da fonte
		jlTitulo.setBackground(new Color(0, 200, 0));
		jlTitulo.setOpaque(true);
		
		//Plano de Fundo do Painel
		imagemFundo = new ImageIcon(getClass().getResource("/img/processador.png"));
		jlImagem = new JLabel(imagemFundo);
		jlImagem.setSize(400, 400);
		
		//Configuração da primeira linha
		jlMarca = new JLabel("Marca");
		jrbIntel = new JRadioButton("Intel", true);
		jrbIntel.setOpaque(false);
		jrbAmd = new JRadioButton("AMD");
		jrbAmd.setOpaque(false);
		bgMarca = new ButtonGroup();
		jlFabricante = new JLabel("Fabricante");
		jrbTSMC = new JRadioButton("TSMC",true);
		jrbTSMC.setOpaque(false);
		bgFabricante = new ButtonGroup();
		jlGeracao = new JLabel("Geração");
		jtfGeracao = new JTextField();
		
		//Configuração da segunda linha
		jlModelo = new JLabel("Modelo");
		jtfModelo = new JTextField();
		jlNucleos = new JLabel("Nº de Núcleos");
		jrbSingleCore = new JRadioButton("Single Core");
		jrbSingleCore.setOpaque(false);
		jrbDualCore = new JRadioButton("Dual Core");
		jrbDualCore.setOpaque(false);
		jrbQuadCore = new JRadioButton("Quad Core");
		jrbQuadCore.setOpaque(false);
		bgNucleos = new ButtonGroup();
		jlPreco = new JLabel("Preço");
		jtfPreco = new JTextField();
		
		//Configuração da terceira linha
		jlCodigoProduto = new JLabel("Código do Produto");
		jtfCodigoProduto = new JTextField();
		jbCadastrar = new JButton("Cadastrar");
		jbCadastrar.setForeground(new Color(0, 0, 0));
		jbCadastrar.setBackground(Color.GREEN);
		jbAlterar = new JButton("Alterar");
		jbAlterar.setForeground(new Color(0, 0, 0));
		jbAlterar.setBackground(Color.GREEN);
		
		
		//Adicionando os botões em seus respectivos grupos
		bgMarca.add(jrbIntel);
		bgMarca.add(jrbAmd);
		
		bgNucleos.add(jrbSingleCore);
		bgNucleos.add(jrbDualCore);
		bgNucleos.add(jrbQuadCore);
		
		bgFabricante.add(jrbTSMC);
		
		//Adicionando os componentes à tela
		add(jlTitulo);
		add(jlMarca);
		add(jrbIntel);
		add(jrbAmd);
		add(jlModelo);
		add(jtfModelo);
		add(jlNucleos);
		add(jrbSingleCore);
		add(jrbDualCore);
		add(jrbQuadCore);
		add(jlFabricante);
		add(jrbTSMC);
		add(jlPreco);
		add(jtfPreco);
		add(jlGeracao);
		add(jtfGeracao);
		add(jlCodigoProduto);
		add(jtfCodigoProduto);
		add(jbCadastrar);
		add(jbAlterar);
		add(jlImagem);
		
		//Dimensionando os componentes na tela
		jlTitulo.setBounds(0, 0, 400, 20); //Coluna, linha, largura, altura
		jlMarca.setBounds(80, 40, 60, 20); 
		jrbIntel.setBounds(80, 60, 70, 20);
		jrbAmd.setBounds(80, 80, 80, 20);
		jlFabricante.setBounds(160, 40, 60, 20);
		jrbTSMC.setBounds(160, 60, 60, 20);
		jlNucleos.setBounds(240, 40, 150, 20);
		jrbSingleCore.setBounds(240, 60, 90, 20);
		jrbDualCore.setBounds(240, 80, 90, 20);
		jrbQuadCore.setBounds(240, 100, 90, 20);
		jlModelo.setBounds(80, 140, 60, 20);
		jtfModelo.setBounds(80, 160, 60, 20);
		jlPreco.setBounds(160, 140, 60, 20);
		jtfPreco.setBounds(160, 160, 60, 20);
		jlCodigoProduto.setBounds(240, 140, 110, 20);
		jtfCodigoProduto.setBounds(240, 160, 100, 20);
		jlGeracao.setBounds(80, 190, 60, 20);
		jtfGeracao.setBounds(80, 210, 60, 20);
		jbCadastrar.setBounds(145, 245, 100, 30);
		jbAlterar.setBounds(145, 245, 100, 30);
	}

	private void criarEventos() {
		//Evento do botão "Cadastrar"
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!jtfModelo.getText().isEmpty() &&
					!jtfPreco.getText().isEmpty()) {
					String marca, modelo, fabricante, codigoProduto = null, preco, geracao, nucleos = null;
					
					modelo = jtfModelo.getText();
					codigoProduto = jtfCodigoProduto.getText();
					preco = jtfPreco.getText().trim();
					geracao = jtfGeracao.getText();
					
					if (jrbIntel.isSelected()) {
						marca = "Intel";
					} else {
						marca = "AMD";
					}
					
					if (jrbTSMC.isSelected()) {
						fabricante = "Galak";
					} else {
						fabricante = "Asus";
					}
					
					if (jrbSingleCore.isSelected()) nucleos = "Single Core";
					if (jrbDualCore.isSelected()) nucleos = "Dual Core";
					if (jrbQuadCore.isSelected()) nucleos = "Quad Core";
					
					produtos.add(new Processador(marca, modelo, fabricante, codigoProduto, preco, geracao, nucleos));
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Cadastro bem-sucedido", JOptionPane.INFORMATION_MESSAGE);
					jtfModelo.setText("");
					jtfPreco.setText("");
					jtfGeracao.setText("");
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
				if (jrbIntel.isSelected()) marca = "Intel";
				if (jrbAmd.isSelected()) marca = "AMD";
				processador.setMarca(marca);
				
				String fabricante = null;
				if (jrbTSMC.isSelected()) fabricante = "TSMC";
				//if (jrbAsus.isSelected()) fabricante = "Asus";
				processador.setFabricante(fabricante);
				
				String nucleos = null;
				if (jrbSingleCore.isSelected()) nucleos = "Single Core";
				if (jrbDualCore.isSelected()) nucleos = "Dual Core";
				if (jrbQuadCore.isSelected()) nucleos = "Quad Core";
				processador.setNucleos(nucleos);
				
				processador.setModelo(jtfModelo.getText());
				processador.setPreco(jtfPreco.getText());
				processador.setCodigoProduto(jtfCodigoProduto.getText());
				processador.setGeracao(jtfGeracao.getText());
				
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
				
			}
	
		});
		
	}

	public void preencherDados() {
		jbCadastrar.setVisible(false);
		try {
			int indice = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do produto que deseja alterar"));
			
			//Setando a Marca do Produto
			if (produtos.get(indice - 1).getMarca().equals("Intel")) 
				jrbIntel.setSelected(true);
			if (produtos.get(indice - 1).getMarca().equals("AMD"))
				jrbAmd.setSelected(true);
			
			//Setando o Fabricante do Produto
			if (produtos.get(indice -1).getFabricante().equals("TSMC")) 
				jrbTSMC.setSelected(true);
			/*if (produtos.get(indice - 1).getFabricante().equals("Asus")) 
				jrbAsus.setSelected(true);*/
			
			//Setando o número de núcleos
			processador = (Processador) produtos.get(indice - 1);
			if(processador.getNucleos().equals("Single Core"))
				jrbSingleCore.setSelected(true);
			if(processador.getNucleos().equals("Dual Core"))
				jrbDualCore.setSelected(true);
			if(processador.getNucleos().equals("Quad Core"))
				jrbQuadCore.setSelected(true);
			
			jtfModelo.setText(produtos.get(indice - 1).getModelo());
			jtfPreco.setText(produtos.get(indice - 1).getPreco());
			jtfCodigoProduto.setText(produtos.get(indice - 1).getCodigoProduto());
			jtfGeracao.setText(produtos.get(indice - 1).getModelo());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Campo vazio ou preenchido incorretamente. Utilize apenas números.", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Índice inexistente!", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (ClassCastException e) {
			JOptionPane.showMessageDialog(null, "Este indice não pertence ao produto selecionado", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
}
