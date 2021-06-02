package WarbbitsPackage;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/*Interna ao tabuleiro controler - controler da casa do Tabueiro*/

public class CasaTabuleiro extends JButton implements ActionListener {

	public int coluna;
	public int linha;

	private static final long serialVersionUID = 5211261785636994072L;

	public Coelho coelho;
	public TabuleiroController tabuleiro;

	public CasaTabuleiro(Color cor, int coluna, int linha, TabuleiroController tab) {
		super();
		this.setBackground(cor);
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.coluna = coluna;
		this.linha = linha;
		this.tabuleiro = tab;

		addActionListener(this);
	}

	public void SetCoelho(Coelho coelho) {

		this.coelho = coelho;

		if (coelho != null)
			this.setIcon(coelho.img);
		else
			this.setIcon(null);
	}

	public void RemoveCoelho() {
		this.coelho = null;
		this.setIcon(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Seu turno: " +tabuleiro.seuTurno);
		if (tabuleiro.seuTurno) {
			if (tabuleiro.primeiroClique && coelho == null) {

				System.out.println(">>segundo clique");
				String jogada = tabuleiro.moveCoelho(this);
				tabuleiro.disablePrimeiroClique();
				tabuleiro.conexao.enviaJogada(jogada);
				tabuleiro.seuTurno = false;

			} else if (tabuleiro.primeiroClique && coelho != null && !coelho.equipe.time.equals(tabuleiro.meuTime)) {
				String jogada = tabuleiro.batalhaCoelho(this);
				tabuleiro.disablePrimeiroClique(); 
				tabuleiro.conexao.enviaJogada(jogada);
				tabuleiro.seuTurno = false;

			} else if (coelho != null && coelho.equipe.time.equals(tabuleiro.meuTime)) {
				if (!tabuleiro.primeiroClique) {
					System.out.println("> primeiro clique");
					tabuleiro.enablePrimeiroClique(this);

				} else {
					System.out.println(">>Voce nao pode batalhar com aliados");
					tabuleiro.disablePrimeiroClique();
				}

			} else {
				System.out.println("Voce nao tem permissao para mexer nessa casa");

			}

			
		}

	}

}
