package WarbbitsPackage;

import java.awt.Color;
import java.awt.Image;
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
	
	Icon iconV;
	Icon iconA;

	public GameScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		tela = new JPanel();
		tela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tela);
		tela.setLayout(null);
		
		this.tabuleiroView = new JPanel();
		tabuleiroView.setBounds(65, 50, 625, 675);
		tela.add(tabuleiroView);
		tabuleiroView.setLayout(new GridLayout(6, 6));
		tabuleiroView.setBackground(Color.BLACK);
		
	    Image iconImgV = new ImageIcon(this.getClass().getResource("/pecavermelha.png")).getImage().getScaledInstance( 75, 75, java.awt.Image.SCALE_SMOOTH); 
	    iconV = new ImageIcon( iconImgV );
	    
		Image iconImgA = new ImageIcon(this.getClass().getResource("/pecaazul.png")).getImage().getScaledInstance( 75, 75, java.awt.Image.SCALE_SMOOTH); 
	    iconA = new ImageIcon(iconImgA);
		
		TabuleiroController tabuleiro = new TabuleiroController(CriaTabuleiro(tabuleiroView));
	}
	
	private CasaTabuleiro[][] CriaTabuleiro(JPanel tabuleiro) {
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
					casas[coluna][linha] = CriaCasaVermelha(casas[coluna][linha]);
				
				if (linha == 4 || linha == 5)
					casas[coluna][linha] = CriaCasaAzul(casas[coluna][linha]); 
				
				casas[coluna][linha].addActionListener(e ->
				{
					//TODO: OQ FAZER AO CLICAR NA CASA
				});
				
				tabuleiro.add(casas[coluna][linha]);
			}
		}
		
		return casas;
	}
	
	private CasaTabuleiro CriaCasaVermelha(CasaTabuleiro casa) {		
	    casa.setIcon(iconV);
		
		return casa;
	}
	
	private CasaTabuleiro CriaCasaAzul(CasaTabuleiro casa) {
	    
	    casa.setIcon(iconA);
		
		return casa;
	}
}
