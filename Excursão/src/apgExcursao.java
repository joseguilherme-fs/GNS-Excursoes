import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class apgExcursao {

	private JFrame frmGnExcurses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					apgExcursao window = new apgExcursao();
					window.frmGnExcurses.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public apgExcursao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		frmGnExcurses = new JFrame();
		frmGnExcurses.setIconImage(Toolkit.getDefaultToolkit().getImage(apgExcursao.class.getResource("/Imagens/icone1.png")));
		frmGnExcurses.setTitle("GN Excursões");
	
		frmGnExcurses.setResizable(false);
		frmGnExcurses.setBounds(100, 100, 370, 280);
		frmGnExcurses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGnExcurses.getContentPane().setLayout(null);
		
		Font fontP = null;
		Font font2 = null;
		Font font3 = null;

		InputStream fontStream = apgExcursao.class.getResourceAsStream("/Fontes/Strawberry Blossom.ttf");
		InputStream fontStream2 = apgExcursao.class.getResourceAsStream("/Fontes/seguiemj.ttf");
		InputStream fontStream3 = apgExcursao.class.getResourceAsStream("/Fontes/seguiemj.ttf");

		try {
		    fontP = Font.createFont(Font.TRUETYPE_FONT, fontStream);
		    fontP = fontP.deriveFont(Font.BOLD, 45); 
		    
		    font2 = Font.createFont(Font.TRUETYPE_FONT, fontStream2);
		    font2 = font2.deriveFont(Font.PLAIN, 12);
		    
		    font3 = Font.createFont(Font.TRUETYPE_FONT, fontStream3);
		    font3 = font3.deriveFont(Font.PLAIN, 10);
		    
		} catch (FontFormatException | IOException e) {
		    e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("GN Excursões");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(fontP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(41, 85, 272, 69);
		frmGnExcurses.getContentPane().add(lblNewLabel);
		
		JLabel foto = new JLabel("New label");
		foto.setBounds(114, 11, 125, 129);
		frmGnExcurses.getContentPane().add(foto);
		
		ImageIcon icon = new ImageIcon(apgExcursao.class.getResource("/Imagens/bus.gif"));
		icon.setImage(icon.getImage().getScaledInstance(foto.getWidth(),foto.getHeight(),Image.SCALE_DEFAULT));
		foto.setIcon(icon);
		
		
		
		JButton btnNewButton = new JButton("Entrar ➡");
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		        janelaPrincipal.getJanelaRE().setVisible(true);
		        frmGnExcurses.dispose();
		    }
		});
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton.setBounds(127, 176, 99, 31);
		frmGnExcurses.getContentPane().add(btnNewButton);
		
		
					
		JLabel lblNewLabel_1 = new JLabel("Seja bem-vindo(a)!❤");
		lblNewLabel_1.setFont(font2);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(76, 151, 202, 14);
		frmGnExcurses.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("💻 by José Guilherme & Nirielly Brito");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(font3);
		lblNewLabel_1_1.setBounds(76, 227, 202, 14);
		frmGnExcurses.getContentPane().add(lblNewLabel_1_1);
		
		
		
		// Obtém as dimensões da tela principal
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Obtém as dimensões da janela
		Dimension windowSize = frmGnExcurses.getSize();

		// Calcula a posição da janela no centro da tela
		int x = (screenSize.width - windowSize.width) / 2;
		int y = (screenSize.height - windowSize.height) / 2;

		// Define a posição da janela no centro da tela
		frmGnExcurses.setLocation(x, y);
		frmGnExcurses.setBounds(x, y, windowSize.width, windowSize.height);
	}
	
		

}
