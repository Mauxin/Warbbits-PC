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
		this.img = setImagem(tipo);
		
		equipe.adicionaCoelho(tipo);
		System.out.println("Tipo de coelho>" + tipo);
	}

	private Icon setImagem(TipoCoelho tipo) {


		if (equipe.time == TipoEquipe.Vermelha) {
			if (tipo == TipoCoelho.Agua)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/WaterFighterRed.png")).getImage().getScaledInstance(75,
				75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Gelo)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/IceFighterRed.png")).getImage().getScaledInstance(75,
						75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Fogo)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/FireFighterRed.png")).getImage().getScaledInstance(75,
						75, java.awt.Image.SCALE_SMOOTH));
			else 
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/pecavermelha.png")).getImage().getScaledInstance(75,
						75, java.awt.Image.SCALE_SMOOTH));
			
		} 
		else if (equipe.time == TipoEquipe.Azul) { //TimeAzul
			
			if (tipo == TipoCoelho.Agua)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/WaterFighterBlue.png")).getImage().getScaledInstance(75,
				75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Gelo)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/IceFighterBlue.png")).getImage().getScaledInstance(75,
						75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Fogo)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/FireFighterBlue.png")).getImage().getScaledInstance(75,
						75, java.awt.Image.SCALE_SMOOTH));
			else 
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/pecaazul.png")).getImage().getScaledInstance(75,
						75, java.awt.Image.SCALE_SMOOTH));
 		}
		
		return null;

	}
	
	private TipoCoelho sorteiaCoelho () {
		TipoCoelho[] tCoelho = null;
		
		tCoelho = equipe.getCoelhosFaltantes();
		 
		System.out.println("tamanho:" + equipe.coelhosFaltantesLenght);
		
		
		return tCoelho[new Random().nextInt(equipe.coelhosFaltantesLenght)];
	}

}
