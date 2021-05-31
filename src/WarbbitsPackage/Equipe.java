package WarbbitsPackage;

public class Equipe {

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
		coelhosFaltantesLenght=0;
		
		if (qntIceFightersAtual < numIceFighters) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Gelo;
			coelhosFaltantesLenght ++;
		}
		if (qntFireFightersAtual < numFireFighters) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Fogo;
			coelhosFaltantesLenght ++;
		}
		if (qntWaterFightersAtual < numWaterFighters) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Agua;
			coelhosFaltantesLenght ++;
		}
		if (qntBandeiraAtual < numBandeira) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Bandeira;
			coelhosFaltantesLenght ++;
		}
		
		if (qntArmadilhasAtual < numArmadilhas) {
			coelhosFaltantes[coelhosFaltantesLenght] = TipoCoelho.Armadilha;
			coelhosFaltantesLenght ++;
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

}
