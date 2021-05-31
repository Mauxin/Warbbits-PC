package WarbbitsPackage;
 

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Equipe {

	Icon imgPecaAzul;
	Icon imgFireFighterBlue;
	Icon imgIceFighterBlue;
	Icon imgWaterFighterBlue;
	Icon imgPecaVermelha;
	Icon imgFireFighterRed;
	Icon imgIceFighterRed;
	Icon imgWaterFighterRed;
	
	
	// quantidade final de cada coelho permitido
	final int numCoelhos = 14;
	final int numFireFighters = 4;
	final int numWaterFighters = 4;
	final int numIceFighters = 4;
	final int numBandeira = 1;
	final int numArmadilhas = 1;

	// quantidade existente de cada coelho na partida
	public int qntCoelhosAtual;
	public int qntFireFightersAtual;
	public int qntWaterFightersAtual;
	public int qntIceFightersAtual;
	public int qntBandeiraAtual;
	public int qntArmadilhasAtual;

	public int coelhosFaltantesLenght;

	TipoEquipe time;

	public Equipe(TipoEquipe time) {

		this.time = time;

		qntCoelhosAtual = 0;
		qntFireFightersAtual = 0;
		qntWaterFightersAtual = 0;
		qntIceFightersAtual = 0;
		qntBandeiraAtual = 0;
		qntArmadilhasAtual = 0;

	}

	public boolean checaTipo(TipoCoelho tcoelho) {

		if ((tcoelho != null) && ((tcoelho == TipoCoelho.Gelo && qntIceFightersAtual < numIceFighters)
				|| (tcoelho == TipoCoelho.Fogo && qntFireFightersAtual < numFireFighters)
				|| (tcoelho == TipoCoelho.Agua && qntWaterFightersAtual < numWaterFighters)
				|| (tcoelho == TipoCoelho.Bandeira && qntBandeiraAtual < numBandeira)
				|| (tcoelho == TipoCoelho.Armadilha && qntArmadilhasAtual < numArmadilhas))) {

			adicionaCoelho(tcoelho);
			return true;
		}
		return false;

	}

	public TipoCoelho[] getCoelhosFaltantes() {
		TipoCoelho[] coelhosFaltantes = new TipoCoelho[5];
		coelhosFaltantesLenght = 0;

		if (qntIceFightersAtual < numIceFighters) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Gelo;
			coelhosFaltantesLenght++;
		}
		if (qntFireFightersAtual < numFireFighters) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Fogo;
			coelhosFaltantesLenght++;
		}
		if (qntWaterFightersAtual < numWaterFighters) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Agua;
			coelhosFaltantesLenght++;
		}
		if (qntBandeiraAtual < numBandeira) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Bandeira;
			coelhosFaltantesLenght++;
		}

		if (qntArmadilhasAtual < numArmadilhas) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Armadilha;
			coelhosFaltantesLenght++;
		}

		return coelhosFaltantes;
	}

	public void adicionaCoelho(TipoCoelho tcoelho) {

		switch (tcoelho) {

		case Gelo:
			qntIceFightersAtual++;
			break;
		case Fogo:
			qntFireFightersAtual++;
			break;
		case Agua:
			qntWaterFightersAtual++;
			break;
		case Armadilha:
			qntArmadilhasAtual++;
			break;
		case Bandeira:
			qntBandeiraAtual++;
			break;

		}

	}

	

	public void carregaImagens() {
		// TODO : arrumar para que carreguem as imagens antes de chamar
		imgPecaAzul = new ImageIcon(new ImageIcon(this.getClass().getResource("/pecaazul.png")).getImage()
				.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		imgFireFighterBlue = new ImageIcon(new ImageIcon(this.getClass().getResource("/FireFighterBlue.png"))
				.getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		imgIceFighterBlue = new ImageIcon(new ImageIcon(this.getClass().getResource("/IceFighterBlue.png"))
				.getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		imgWaterFighterBlue = new ImageIcon(new ImageIcon(this.getClass().getResource("/WaterFighterBlue.png"))
				.getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		imgPecaVermelha = new ImageIcon(new ImageIcon(this.getClass().getResource("/pecavermelha.png")).getImage()
				.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		imgFireFighterRed = new ImageIcon(new ImageIcon(this.getClass().getResource("/FireFighterRed.png"))
				.getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		imgIceFighterRed = new ImageIcon(new ImageIcon(this.getClass().getResource("/IceFighterRed.png"))
				.getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

		imgWaterFighterRed = new ImageIcon(new ImageIcon(this.getClass().getResource("/WaterFighterRed.png"))
				.getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

	}
	


}
