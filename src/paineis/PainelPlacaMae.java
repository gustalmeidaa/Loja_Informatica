package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import classes.PlacaMae;
import classes.Produto;

public class PainelPlacaMae extends JPanel {
	//Atributos
	private JLabel jlMarca, jlModelo, jlFabricante, jlPreco, jlTipoPlacaMae, jlTitulo, jlCodigoProduto;
	private JTextField jtfPreco, jtfModelo, jtfCodigoProduto;
	private JRadioButton jrbAsus, jrbGigabyte, jrbFabAsus, jrbFabGigabyte, jrbAtx, jrbMicroATX;
	private JButton jbCadastrar, jbAlterar;
	private ButtonGroup bgMarca, bgTipoPlacaMae, bgFabricante;
	private PlacaMae placaMae;
	private ImageIcon imagemFundo;
	private JLabel jlImagem;
	private List<Produto> produtos;
	
	//Construtor
	public PainelPlacaMae(List<Produto> produtos) {
		super();
		setSize(400, 400);
		setLayout(null);
		setBackground(new Color(36, 170, 196));
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		jlTitulo = new JLabel("Placa M�e"); //T�tulo do painel
		jlTitulo.setHorizontalAlignment(JLabel.CENTER); //Alinha o texto horizontalmente ao centro
		jlTitulo.setFont(new Font("Arial", Font.ITALIC, 18)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(245, 245, 245)); //Setando a cor da fonte
		jlTitulo.setBackground(Color.BLUE);
		jlTitulo.setOpaque(true);
		
		//Plano de fundo do painel
		imagemFundo = new ImageIcon(getClass().getResource("/img/placamae.png"));
		jlImagem = new JLabel(imagemFundo);
		jlImagem.setSize(400, 400);
		
		//Configura��o da primeira linha
		jlMarca = new JLabel("Marca");
		jrbAsus = new JRadioButton("Asus",true);
		jrbAsus.setOpaque(false);
		jrbGigabyte = new JRadioButton("Gigabyte");
		jrbGigabyte.setOpaque(false);
		bgMarca = new ButtonGroup();
		
		jlFabricante = new JLabel("Fabricante");
		jrbFabAsus = new JRadioButton("Asus",true);
		jrbFabAsus.setOpaque(false);
		jrbFabGigabyte = new JRadioButton("Gigabyte");
		jrbFabGigabyte.setOpaque(false);
		bgFabricante = new ButtonGroup();
		
		jlTipoPlacaMae = new JLabel("Tipo de Placa M�e");
		jrbAtx = new JRadioButton("ATX",true);
		jrbAtx.setOpaque(false);
		jrbMicroATX = new JRadioButton("Micro ATX");
		jrbMicroATX.setOpaque(false);
		bgTipoPlacaMae = new ButtonGroup();
		
		//Configura��o da segunda linha
		jlModelo = new JLabel("Modelo");
		jtfModelo = new JTextField();
		jlPreco = new JLabel("Pre�o");
		jtfPreco = new JTextField();
		jlCodigoProduto = new JLabel("C�digo do Produto");
		jtfCodigoProduto = new JTextField();
		
		//Configura��o da terceira linha
		jbCadastrar = new JButton("Cadastrar");
		jbCadastrar.setForeground(new Color(255, 255, 255));
		jbCadastrar.setBackground(new Color(0, 0, 255));
		jbAlterar = new JButton("Alterar");
		jbAlterar.setForeground(new Color(255, 255, 255));
		jbAlterar.setBackground(new Color(0, 0, 255));
		
		//Adicionando os bot�es em seus respectivos grupos
		bgMarca.add(jrbAsus);
		bgMarca.add(jrbGigabyte);
				
		bgTipoPlacaMae.add(jrbAtx);
		bgTipoPlacaMae.add(jrbMicroATX);
				
		bgFabricante.add(jrbFabAsus);
		bgFabricante.add(jrbFabGigabyte);
		
		//Adicionando os componentes � tela
		add(jlTitulo);
		add(jlMarca);
		add(jrbAsus);
		add(jrbGigabyte);
		add(jlModelo);
		add(jtfModelo);
		add(jlFabricante);
		add(jrbFabAsus);
		add(jrbFabGigabyte);
		add(jlPreco);
		add(jtfPreco);
		add(jlCodigoProduto);
		add(jtfCodigoProduto);
		add(jlTipoPlacaMae);
		add(jrbAtx);
		add(jrbMicroATX);
		add(jbCadastrar);
		add(jbAlterar);
		add(jlImagem);
	    
		//Dimensionando os componentes � tela
		
		jlTitulo.setBounds(0, 0, 400, 20); //Coluna, linha, largura, altura
		jlMarca.setBounds(80, 40, 60, 20); 
		jrbAsus.setBounds(80, 60, 70, 20);
		jrbGigabyte.setBounds(80, 80, 80, 20);
		jlFabricante.setBounds(160, 40, 60, 20);
		jrbFabAsus.setBounds(160, 60, 80, 20);
		jrbFabGigabyte.setBounds(160, 80, 80, 20);
		jlTipoPlacaMae.setBounds(240, 40, 150, 20);
		jrbAtx.setBounds(240, 60, 60, 20);
		jrbMicroATX.setBounds(240, 80, 90, 20);
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
		//Evento do bot�o "Cadastrar"
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!jtfModelo.getText().isEmpty() &&
					!jtfPreco.getText().isEmpty()) {
					String marca, modelo, fabricante, codigoProduto = null, preco, capacidade = null;
					
					modelo = jtfModelo.getText();
					codigoProduto = jtfCodigoProduto.getText();
					preco = jtfPreco.getText().trim();
					
					if (jrbAsus.isSelected()) {
						marca = "Asus";
					} else {
						marca = "Gigabyte";
					}
					
					if (jrbFabAsus.isSelected()) {
						fabricante = "Asus";
					} else {
						fabricante = "Gigabyte";
					}
					
					if (jrbAtx.isSelected()) capacidade = "ATX";
					if (jrbMicroATX.isSelected()) capacidade = "Micro ATX";
					
					produtos.add(new PlacaMae(marca, modelo, fabricante, codigoProduto, preco, capacidade));
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Cadastro bem-sucedido", JOptionPane.INFORMATION_MESSAGE);
					jtfModelo.setText("");
					jtfPreco.setText("");
					jtfCodigoProduto.setText("");
					
				} else {
					JOptionPane.showMessageDialog(null, "Erro! Preencha todos os campos.", "Erro no Processo", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
		});
		
		//Evento do bot�o "Alterar"
		jbAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String marca = null;
				if (jrbAsus.isSelected()) marca = "Asus";
				if (jrbGigabyte.isSelected()) marca = "Gigabyte";
				placaMae.setMarca(marca);
				
				String fabricante = null;
				if (jrbFabAsus.isSelected()) fabricante = "Asus";
				if (jrbFabGigabyte.isSelected()) fabricante = "Gigabyte";
				placaMae.setFabricante(fabricante);
				
				String tipoPlacaMae = null;
				if (jrbAtx.isSelected()) tipoPlacaMae = "ATX";
				if (jrbMicroATX.isSelected()) tipoPlacaMae = "Micro ATX";
				placaMae.setTipoPlacaMae(tipoPlacaMae);
				
				placaMae.setModelo(jtfModelo.getText());
				placaMae.setPreco(jtfPreco.getText());
				placaMae.setCodigoProduto(jtfCodigoProduto.getText());
				
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
				
			}
	
		});
		
	}

	public void preencherDados() {
		jbCadastrar.setVisible(false);
		try {
			int indice = Integer.parseInt(JOptionPane.showInputDialog("Digite o �ndice do produto que deseja alterar"));
			
			//Setando a Marca do Produto
			if (produtos.get(indice - 1).getMarca().equals("Azza")) 
				jrbAsus.setSelected(true);
			if (produtos.get(indice - 1).getMarca().equals("Cougar"))
				jrbGigabyte.setSelected(true);
			
			//Setando o Fabricante do Produto
			if (produtos.get(indice -1).getFabricante().equals("Mancer")) 
				jrbFabAsus.setSelected(true);
			if (produtos.get(indice - 1).getFabricante().equals("Asus")) 
				jrbFabGigabyte.setSelected(true);
			
			//Setando o tipo de Placa M�e
			placaMae = (PlacaMae) produtos.get(indice - 1);
			if(placaMae.getTipoPlacaMae().equals("ATX"))
				jrbAtx.setSelected(true);
			if (placaMae.getTipoPlacaMae().equals("Micro ATX"))
				jrbMicroATX.setSelected(true);
			
			jtfModelo.setText(produtos.get(indice - 1).getModelo());
			jtfPreco.setText(produtos.get(indice - 1).getPreco());
			jtfCodigoProduto.setText(produtos.get(indice - 1).getCodigoProduto());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Campo vazio ou preenchido incorretamente. Utilize apenas n�meros.", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "�ndice inexistente!", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (ClassCastException e) {
			JOptionPane.showMessageDialog(null, "Este indice n�o pertence ao produto selecionado", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
