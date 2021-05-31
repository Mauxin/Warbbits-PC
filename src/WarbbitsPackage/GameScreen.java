package WarbbitsPackage;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class GameScreen extends JFrame {

	private static final long serialVersionUID = -629738671347410712L;

	JPanel tela;
	JPanel tabuleiroView;
	TabuleiroController tabuleiro;
	
	Conexao conexao; 

	Equipe equipeVermelha;
	Equipe equipeAzul;

	Icon iconV;
	Icon iconA;
	
	public String ip = "localhost";
	public int port = 1234;

	public GameScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 620);
		tela = new JPanel();
		tela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tela);
		tela.setLayout(null);

		this.tabuleiroView = new JPanel();
		tabuleiroView.setBounds(20, 20, 560, 560);
		tela.add(tabuleiroView);
		tabuleiroView.setLayout(new GridLayout(6, 6));
		tabuleiroView.setBackground(Color.BLACK);
		
		conexao = new Conexao (ip, port);
		
		if (!conexao.conecta())
			conexao.iniciaServer();

		tabuleiro = new TabuleiroController(CriaTabuleiro(tabuleiroView));
		
	}

	private CasaTabuleiro[][] CriaTabuleiro(JPanel tabuleiro) {

		equipeVermelha = new Equipe(TipoEquipe.Vermelha);
		equipeAzul = new Equipe(TipoEquipe.Azul);
		

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
				if (linha == 0 || linha == 1)
					casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeVermelha);

				if (linha == 4 || linha == 5)
					casas[coluna][linha] = CriaCasa(casas[coluna][linha], equipeAzul);

				casas[coluna][linha].addActionListener(e -> {
					// TODO: OQ FAZER AO CLICAR NA CASA
				});

				tabuleiro.add(casas[coluna][linha]);
			}
		}

		return casas;
	}

	private CasaTabuleiro CriaCasa(CasaTabuleiro casa, Equipe equipe) {

		casa.SetCoelho(new Coelho(equipe));

		return casa;
	}

}
