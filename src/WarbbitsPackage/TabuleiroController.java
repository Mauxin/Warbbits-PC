package WarbbitsPackage;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class TabuleiroController implements Runnable {

	Equipe equipeVermelha;
	Equipe equipeAzul;

	TipoEquipe meuTime = null;

	String Player;

	JPanel Jtab;
	Conexao conexao;

	int coluna;
	int linha;

	private CasaTabuleiro tabuleiro[][];
	CasaTabuleiro casas[][];

	public boolean seuTurno = true;

	public boolean primeiroClique = false;
	public CasaTabuleiro casaSource = null;

	public TabuleiroController(JPanel Jtab, Conexao conexao) {
		this.conexao = conexao;
		this.tabuleiro = CriaTabuleiro(Jtab);
		this.Jtab = Jtab;

		Thread thread = new Thread(this);
		thread.start();
	}

	private CasaTabuleiro[][] CriaTabuleiro(JPanel Jtab) {
		if (conexao.Player.equals("Host")) {
			equipeVermelha = new Equipe(TipoEquipe.VermelhaOponente);
			equipeAzul = new Equipe(TipoEquipe.Azul);
			meuTime = equipeAzul.time;
		} else {
			equipeVermelha = new Equipe(TipoEquipe.Vermelha);
			equipeAzul = new Equipe(TipoEquipe.AzulOponente);
			meuTime = equipeVermelha.time;
			seuTurno = false;
		}

		CasaTabuleiro casas[][] = new CasaTabuleiro[7][6];

		for (linha = 0; linha < 6; linha++) {
			for (coluna = 0; coluna < 7; coluna++) {
				// Pintando Botao
				// new Color(233, 240, 204) Amarelo
				// new Color(213, 241, 209) Verdinho
				// new Color(52, 116, 44); Verdao

				Color cor = ((linha + coluna) % 2) == 0 ? new Color(213, 241, 209) : new Color(105, 184, 95);
				casas[coluna][linha] = new CasaTabuleiro(cor, linha, coluna, this);

				// CRIANDO OS TIMES
				if (linha == 2 || linha == 3)
					casas[coluna][linha] = CriaCasa(casas[coluna][linha], null);

				if (conexao.Player.equals("Host")) {

					if (linha == 0 || linha == 1)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeVermelha);

					if (linha == 2 || linha == 3)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], null);

					if (linha == 4 || linha == 5)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeAzul);

				} else {

					if (linha == 0 || linha == 1)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeAzul);

					if (linha == 2 || linha == 3)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], null);

					if (linha == 4 || linha == 5)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeVermelha);

				}

				Jtab.add(casas[coluna][linha]);
			}
		}

		return casas;
	}

	private CasaTabuleiro CriaCasa(CasaTabuleiro casa, Equipe equipe) {

		if (equipe != null)
			casa.SetCoelho(new Coelho(equipe));

		else
			casa.SetCoelho(null);

		return casa;
	}

	public void enablePrimeiroClique(CasaTabuleiro casa) {

		primeiroClique = true;
		this.casaSource = casa;

		System.out.println("salvou aqui o coelho.");
		System.out.println("Tipo do coelho: " + casaSource.coelho.tipo);

	}

	public void disablePrimeiroClique() {
		primeiroClique = false;
		casaSource = null;

	}

	public void moveCoelho(CasaTabuleiro casaTarget) {
		// regras: move para os lados com apenas uma casa de dist�ncia
		/*
		 * para esquerda : casaTarget.coluna < casaSource.coluna && casaTarget.linha ==
		 * casaSource.linha para direita : casaTarget.coluna > casaSource.coluna &&
		 * casaTarget.linha == casaSource.linha para cima : casaTarget.coluna ==
		 * casaSource.coluna && casaTarget.linha < casaSource.linha para baixo :
		 * casaTarget.coluna == casaSource.coluna && casaTarget.linha > casaSource.linha
		 * 
		 * 
		 * 
		 */

		System.out.println("move coelho");

		if ((casaTarget.coluna == casaSource.coluna + 1 && casaTarget.linha == casaSource.linha)
				|| (casaTarget.coluna == casaSource.coluna - 1 && casaTarget.linha == casaSource.linha)
				|| (casaTarget.coluna == casaSource.coluna && casaTarget.linha == casaSource.linha + 1)
				|| (casaTarget.coluna == casaSource.coluna && casaTarget.linha == casaSource.linha - 1)) {
			casaTarget.SetCoelho(casaSource.coelho);
			casaSource.SetCoelho(null);
		} else
			System.out.println("movimento impossivel");

	}

	public void perdeCoelho() {

	}

	private CasaTabuleiro fogoXgelo(CasaTabuleiro Target, CasaTabuleiro Source) {

		if (Target.coelho.tipo == TipoCoelho.Fogo)
			return Target;
		else
			return Source;
	}

	private CasaTabuleiro geloXagua(CasaTabuleiro Target, CasaTabuleiro Source) {

		if (Target.coelho.tipo == TipoCoelho.Gelo)
			return Target;
		else
			return Source;
	}

	private CasaTabuleiro aguaXfogo(CasaTabuleiro Target, CasaTabuleiro Source) {

		if (Target.coelho.tipo == TipoCoelho.Agua)
			return Target;
		else
			return Source;
	}

	public void batalhaCoelho(CasaTabuleiro casaTarget) {
		CasaTabuleiro CasaVencedora = null;

		// Fogo x Gelo : Fogo derrete o gelo, portanto Ganha
		// *Gelo x Agua : Gelo congela a agua, portanto Ganha
		// *Agua x Fogo : Agua apaga o fogo, portanto Ganha
		// *Todas as pe�as perdem para a Pe�a Armadilha
		// *Todas as pe�as ganham ao batalhar com a pe�a Bandeira

		if ((casaTarget.coelho.tipo == TipoCoelho.Fogo || casaSource.coelho.tipo == TipoCoelho.Fogo)
				&& (casaTarget.coelho.tipo == TipoCoelho.Gelo || casaSource.coelho.tipo == TipoCoelho.Gelo))
			CasaVencedora = fogoXgelo(casaTarget, casaSource);

		else if ((casaTarget.coelho.tipo == TipoCoelho.Agua || casaSource.coelho.tipo == TipoCoelho.Agua)
				&& (casaTarget.coelho.tipo == TipoCoelho.Gelo || casaSource.coelho.tipo == TipoCoelho.Gelo))
			CasaVencedora = geloXagua(casaTarget, casaSource);

		else if ((casaTarget.coelho.tipo == TipoCoelho.Agua || casaSource.coelho.tipo == TipoCoelho.Agua)
				&& (casaTarget.coelho.tipo == TipoCoelho.Fogo || casaSource.coelho.tipo == TipoCoelho.Fogo))
			CasaVencedora = aguaXfogo(casaTarget, casaSource);

		else if (casaTarget.coelho.tipo == TipoCoelho.Bandeira)
			ganhaJogo();

		else if (casaTarget.coelho.tipo == TipoCoelho.Armadilha)
			casaSource.SetCoelho(null);

		if (CasaVencedora != null)
			moveCoelho(CasaVencedora);

	}

	private void ganhaJogo() {
		// TODO Auto-generated method stub

	}
	boolean unableToCommunicateWithOpponent = false;
	@Override
	public void run() {
		while (true) {
			if (conexao.erros >= 10) {
				unableToCommunicateWithOpponent = true;
				System.out.println("conexao perdida");}
			
			if (!unableToCommunicateWithOpponent) {
				System.out.println("tamoai");
				int response = conexao.disLeMovimento();
				System.out.println("novo in: " + response);
				seuTurno = true;
			}

			if (conexao.Player.equals("Host") && !conexao.conexaoAceita)
				conexao.aguardaServerRequest();

		}

	}
}
