package WarbbitsPackage;

import java.awt.Color;

import javax.swing.JPanel;

public class TabuleiroController {

	Equipe equipeVermelha;
	Equipe equipeAzul;

	String Player;

	JPanel Jtab;
	Conexao conexao;

	private CasaTabuleiro tabuleiro[][];

	public TabuleiroController(JPanel Jtab, Conexao conexao) {
		this.conexao = conexao;
		this.tabuleiro = CriaTabuleiro(Jtab);
		this.Jtab = Jtab;
	}

	private CasaTabuleiro[][] CriaTabuleiro(JPanel Jtab) {
		if (conexao.Player.equals("Host")) {
			equipeVermelha = new Equipe(TipoEquipe.VermelhaOponente);
			equipeAzul = new Equipe(TipoEquipe.Azul);

		} else {
			equipeVermelha = new Equipe(TipoEquipe.Vermelha);
			equipeAzul = new Equipe(TipoEquipe.AzulOponente);

		}

		CasaTabuleiro casas[][] = new CasaTabuleiro[7][6];

		for (int linha = 0; linha < 6; linha++) {
			for (int coluna = 0; coluna < 7; coluna++) {
				// Pintando Botao
				// new Color(233, 240, 204) Amarelo
				// new Color(213, 241, 209) Verdinho
				// new Color(52, 116, 44); Verdao

				Color cor = ((linha + coluna) % 2) == 0 ? new Color(213, 241, 209) : new Color(105, 184, 95);
				casas[coluna][linha] = new CasaTabuleiro(cor);

				// CRIANDO OS TIMES

				if (conexao.Player.equals("Host")) {

					if (linha == 0 || linha == 1)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeVermelha);

					if (linha == 4 || linha == 5)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeAzul);

				} else {

					if (linha == 0 || linha == 1)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeAzul);

					if (linha == 4 || linha == 5)
						casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeVermelha);

				}
				casas[coluna][linha].addActionListener(e -> {
					// TODO: OQ FAZER AO CLICAR NA CASA
				});

				Jtab.add(casas[coluna][linha]);
			}
		}

		return casas;
	}

	private CasaTabuleiro CriaCasa(CasaTabuleiro casa, Equipe equipe) {

		casa.SetCoelho(new Coelho(equipe));

		return casa;
	}
}
