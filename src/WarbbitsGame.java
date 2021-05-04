import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class WarbbitsGame {

	private JFrame frmWarbbits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarbbitsGame window = new WarbbitsGame();
					window.frmWarbbits.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WarbbitsGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWarbbits = new JFrame();
		frmWarbbits.setTitle("Warbbits");
		frmWarbbits.setBackground(Color.WHITE);
		frmWarbbits.setBounds(0, 0, 860, 645);
		frmWarbbits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWarbbits.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Warbbits Game!");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 132, 600, 100);
		frmWarbbits.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("JOGAR");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBounds(326, 335, 221, 69);
		btnNewButton.addActionListener(e ->
		{
			frmWarbbits.setVisible(false);
	        new GameScreen().setVisible(true);
		});
		frmWarbbits.getContentPane().add(btnNewButton);
	}
}
