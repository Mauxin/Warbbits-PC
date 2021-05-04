import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GameScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameScreen game = new GameScreen();
					game.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public GameScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 860, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 104, 512, 512);
		contentPane.add(panel);
		
		ImageIcon icon = new ImageIcon("../res/tabuleiro.png"); 
	    panel.setLayout(null);
	    JLabel label = new JLabel(); 
	    label.setBounds(0, 0, 512, 512);
	    label.setIcon(new ImageIcon("/Users/murilo.dias/PrivateProjects/Warbbits-PC/res/tabuleiro.png")); 
	    panel.add(label);
	    this.getContentPane().add(panel); 
	    
	    JLabel lblNewLabel = new JLabel("Turno Vermelho");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(82, 49, 404, 16);
	    contentPane.add(lblNewLabel);
	}
}
