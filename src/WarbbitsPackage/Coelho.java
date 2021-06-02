package WarbbitsPackage;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Coelho {

	public TipoCoelho tipo;
	public Equipe equipe;
	public Icon img;

	public Icon imgEscondidoVermelho;
	public Icon imgEscondidoAzul;

	public Coelho(Equipe equipe) {
		this.equipe = equipe;
		if (equipe != null) {
			this.tipo = sorteiaCoelho();
			this.img = setImagem(tipo);
			equipe.adicionaCoelho(tipo);
		}else {
			this.tipo = null;
			this.img = null;
		}
	}

	private Icon setImagem(TipoCoelho tipo) {
		// TODO : tem que criar a peça buraco e a peça bandeira e colocar aqui

		if (equipe.time == TipoEquipe.Vermelha || equipe.time == TipoEquipe.VermelhaOponente) {
			if (tipo == TipoCoelho.Agua)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/WaterFighterRed.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Gelo)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/IceFighterRed.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Fogo)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/FireFighterRed.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Bandeira)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/FlagFighterRed.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
			else
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/pecavermelha.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		} else if (equipe.time == TipoEquipe.Azul || equipe.time == TipoEquipe.AzulOponente ) { // TimeAzul

			if (tipo == TipoCoelho.Agua)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/WaterFighterBlue.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Gelo)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/IceFighterBlue.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Fogo)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/FireFighterBlue.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
			else if (tipo == TipoCoelho.Bandeira)
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/FlagFighterBlue.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
			else
				return new ImageIcon(new ImageIcon(this.getClass().getResource("/pecaazul.png")).getImage()
						.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		} 
		return null;

	}

	public TipoCoelho sorteiaCoelho() {

		TipoCoelho[] tCoelho = null;

		if (equipe!= null && (equipe.time == TipoEquipe.Vermelha || equipe.time == TipoEquipe.Azul)) {

			tCoelho = equipe.getCoelhosFaltantes();
			return tCoelho[new Random().nextInt(equipe.coelhosFaltantesLenght)];

		} else
			return TipoCoelho.Generico;

	}
}
