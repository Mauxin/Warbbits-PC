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

		conexao = new Conexao(ip, port);

		if (!conexao.conecta())
			conexao.iniciaServer();

		tabuleiro = new TabuleiroController(tabuleiroView, conexao);

	}

}
