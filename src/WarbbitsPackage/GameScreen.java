package WarbbitsPackage;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class GameScreen extends JFrame {

	JPanel tela;
	JPanel tabuleiroView;
	TabuleiroController tabuleiro;
	
	Equipe equipeVermelha;
	Equipe equipeAzul;
	
	Icon iconV;
	Icon iconA;

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
		 
		TabuleiroController tabuleiro = new TabuleiroController(CriaTabuleiro(tabuleiroView));
	}
	
	private CasaTabuleiro[][] CriaTabuleiro(JPanel tabuleiro) {
		
		equipeVermelha = new Equipe(TipoEquipe.Vermelha);
		equipeAzul = new Equipe(TipoEquipe.Azul);
		
		CasaTabuleiro casas[][] = new CasaTabuleiro[7][6];
		
		for (int linha = 0; linha < 6; linha++) {
			for (int coluna = 0; coluna < 7; coluna++) {	
				//Pintando Botão
				//new Color(233, 240, 204) Amarelo
				//new Color(213, 241, 209) Verdinho
				// new Color(52, 116, 44); Verdao
				Color cor = ((linha + coluna) % 2) == 0 ? new Color(213, 241, 209) : new Color(52, 116, 44);
				casas[coluna][linha] = new CasaTabuleiro(cor);

				//CRIANDO OS TIMES
				if (linha == 0 || linha == 1)
					casas[coluna][linha] = CriaCasaVermelha(casas[coluna][linha], equipeVermelha);
				
				if (linha == 4 || linha == 5)
					casas[coluna][linha] = CriaCasaAzul(casas[coluna][linha], equipeAzul); 
				
				casas[coluna][linha].addActionListener(e ->
				{
					//TODO: OQ FAZER AO CLICAR NA CASA
				});
				
				tabuleiro.add(casas[coluna][linha]);
			}
		}
		
		return casas;
	}
	
	private CasaTabuleiro CriaCasaVermelha(CasaTabuleiro casa, Equipe equipeVermelha) {
		
		casa.SetCoelho(new Coelho(equipeVermelha));
		
		return casa;
	}
	
	private CasaTabuleiro CriaCasaAzul(CasaTabuleiro casa, Equipe equipeVermelha) {
	    
		casa.SetCoelho(new Coelho(equipeAzul));
		
		return casa;
	}
	
	
}
