package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.TextField;
import java.awt.Label;

public class Tela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setTitle("Urna Eletr\u00F4nica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(357, 44, 49, 47);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBounds(416, 44, 49, 47);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(475, 44, 49, 47);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(357, 102, 49, 47);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(416, 102, 49, 47);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(475, 102, 49, 47);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(357, 160, 49, 47);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(416, 160, 49, 47);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(475, 160, 49, 47);
		contentPane.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(416, 218, 49, 47);
		contentPane.add(btn0);
		
		JButton btnBranco = new JButton("Branco");
		btnBranco.setBackground(Color.WHITE);
		btnBranco.setBounds(315, 294, 80, 29);
		contentPane.add(btnBranco);
		
		JButton btnCorrige = new JButton("Corrige");
		btnCorrige.setBounds(405, 294, 80, 29);
		contentPane.add(btnCorrige);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.setBounds(494, 276, 80, 47);
		contentPane.add(btnConfirma);
		
		TextField txtNomeCandidato = new TextField();
		txtNomeCandidato.setBounds(22, 142, 228, 22);
		contentPane.add(txtNomeCandidato);
		
		Label label = new Label("Canditado");
		label.setBounds(22, 114, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("N\u00FAmero");
		label_1.setBounds(22, 44, 62, 22);
		contentPane.add(label_1);
		
		TextField txtIDCandidato = new TextField();
		txtIDCandidato.setBounds(22, 72, 228, 22);
		contentPane.add(txtIDCandidato);
	}
}
