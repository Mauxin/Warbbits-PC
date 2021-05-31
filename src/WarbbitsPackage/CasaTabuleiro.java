package WarbbitsPackage;

import java.awt.Color; 
import javax.swing.JButton;

/*Interna ao tabuleiro controler - controler da casa do Tabueiro*/

public class CasaTabuleiro extends JButton {

	private static final long serialVersionUID = 5211261785636994072L;
	
	public Coelho coelho;

	public CasaTabuleiro(Color cor) {
		super();
		this.setBackground(cor);
		this.setOpaque(true);
		this.setBorderPainted(false);
	}

	public void SetCoelho(Coelho coelho) {
		this.coelho = coelho;
		this.setIcon(coelho.img);
	}

	public void RemoveCoelho() {
		this.coelho = null;
		this.setIcon(null);
	}

}
