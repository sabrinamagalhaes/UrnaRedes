package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial {

	private JFrame frmUrna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frmUrna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUrna = new JFrame();
		frmUrna.setTitle("Vota\u00E7\u00E3o");
		frmUrna.setBounds(100, 100, 621, 400);
		frmUrna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUrna.getContentPane().setLayout(null);
		
		JButton btnVotar = new JButton("Votar");
		btnVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Tela urna = new Tela();
				urna.setVisible(true);
				frmUrna.dispose();
			}
		});
		btnVotar.setBounds(243, 86, 105, 79);
		frmUrna.getContentPane().add(btnVotar);
		
		JButton btnVotos = new JButton("Votos");
		btnVotos.setBounds(243, 176, 105, 79);
		frmUrna.getContentPane().add(btnVotos);
	}
}
