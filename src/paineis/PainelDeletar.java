package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import classes.Produto;

public class PainelDeletar extends JPanel {
	//Atributos
	private JLabel jlTitulo, jlIndice;
	private JTextField jtfIndice;
	private JButton jbDeletar;
	private List<Produto> produtos;
	
	//Construtor
	public PainelDeletar(List<Produto> produtos) {
		super();
		setSize(400, 400);
		setLayout(null);
		this.produtos = produtos;
		setBackground(new Color(250, 174, 158));
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		//Criando os objetos de cada componente
		jlTitulo = new JLabel("DELETAR"); //Título do painel
		jlTitulo.setHorizontalAlignment(JLabel.CENTER); //Alinha o texto horizontalmente ao centro
		jlTitulo.setFont(new Font("Arial", Font.BOLD, 18)); //Setando uma fonte, tipo da fonte e tamanho
		jlTitulo.setForeground(new Color(255, 0, 0)); //Setando a cor da fonte
		jlTitulo.setBackground(Color.WHITE);
		jlTitulo.setOpaque(true);
		jlIndice = new JLabel("Índice do Produto");
		jtfIndice = new JTextField();
		jbDeletar = new JButton("Deletar");
		
		//Adicionando os componentes à tela
		add(jlTitulo);
		add(jlIndice);
		add(jtfIndice);
		add(jbDeletar);
		
		//Dimensionando os componentes na tela
		jlTitulo.setBounds(0, 0, 400, 20); //Coluna, linha, largura, altura
		jlIndice.setBounds(150, 80, 100, 20);
		jtfIndice.setBounds(150, 110, 40, 20);
		jbDeletar.setBounds(145, 150, 100, 20);
		
	}

	private void criarEventos() {
		//Evento do botão "DELETAR"
				jbDeletar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int indice = Integer.parseInt(jtfIndice.getText());
							int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar?", "Deletar", JOptionPane.YES_NO_OPTION);
							if (resposta == 0) {
								produtos.remove(indice-1);
								JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!", "Exclusão Concluída", JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Preencha o campo com números", "Deletar", JOptionPane.ERROR_MESSAGE);
						} catch (IndexOutOfBoundsException e2) {
							JOptionPane.showMessageDialog(null, "Índice Inválido", "Deletar", JOptionPane.ERROR_MESSAGE);

						}
					
					}
				});
		
	}
	
	
}
