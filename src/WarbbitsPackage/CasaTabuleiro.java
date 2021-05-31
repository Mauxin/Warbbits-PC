package WarbbitsPackage;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JButton;

/*Interna ao tabuleiro controler - controler da casa do Tabueiro*/

public class CasaTabuleiro extends JButton {

	public Coelho coelho;

	public CasaTabuleiro(Color cor) {
		super();
		this.setBackground(cor);
		this.setOpaque(true);
		this.setBorderPainted(false);
	}

	public void SetCoelho(Coelho coelho) {
		this.coelho = coelho;
		this.setIcon(coelho.img);
	}

	public void RemoveCoelho() {
		this.coelho = null;
		this.setIcon(null);
	}

}
