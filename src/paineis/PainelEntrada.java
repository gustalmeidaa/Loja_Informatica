package paineis;

import javax.swing.*;

public class PainelEntrada extends JPanel {
	//Atributos
	private ImageIcon imagemFundo;
	private JLabel jlImagem;
	
	//Construtor
	public PainelEntrada() {
		super();
		setSize(400, 400);
		setLayout(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		imagemFundo = new ImageIcon(getClass().getResource("/img/lojainfo.png"));
		jlImagem = new JLabel(imagemFundo);
		jlImagem.setSize(400, 400);
		add(jlImagem);
	}

}
