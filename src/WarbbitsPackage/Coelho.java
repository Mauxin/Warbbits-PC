package WarbbitsPackage;

import java.awt.Image;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Coelho {

	public TipoCoelho tipo;
	public Equipe equipe;
	public Icon img;

	public Icon imgEscondidoVermelho;
	public Icon imgEscondidoAzul;

	public Coelho( Equipe equipe) {
		this.equipe = equipe;
		this.tipo = sorteiaCoelho();
		this.img = setImagem();
		
		equipe.adicionaCoelho(tipo);
		System.out.println("Tipo de coelho>" + tipo);
	}

	private Icon setImagem() {

		Image iconImgV = new ImageIcon(this.getClass().getResource("/pecavermelha.png")).getImage()
				.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
		imgEscondidoVermelho = new ImageIcon(iconImgV);

		Image iconImgA = new ImageIcon(this.getClass().getResource("/pecaazul.png")).getImage().getScaledInstance(75,
				75, java.awt.Image.SCALE_SMOOTH);
		imgEscondidoAzul = new ImageIcon(iconImgA);

		if (equipe.time == TipoEquipe.Vermelha)
			return imgEscondidoVermelho;
		else
			return imgEscondidoAzul;

	}
	
	private TipoCoelho sorteiaCoelho () {
		TipoCoelho[] tCoelho = null;
		
		tCoelho = equipe.getCoelhosFaltantes();
		 
		System.out.println("tamanho:" + equipe.coelhosFaltantesLenght);
		
		
		return tCoelho[new Random().nextInt(equipe.coelhosFaltantesLenght)];
	}

}
