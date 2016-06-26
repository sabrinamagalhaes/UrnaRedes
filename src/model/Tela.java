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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;

public class Tela extends JFrame {
	//string que contém o id do candidato e deverá ser enviada para o servidor
	String textoVotoID="";
		
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
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("1");
		btn1.setEnabled(false);
		btn1.setBounds(449, 44, 49, 47);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setEnabled(false);
		btn2.setBounds(508, 44, 49, 47);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setEnabled(false);
		btn3.setBounds(567, 44, 49, 47);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setEnabled(false);
		btn4.setBounds(449, 102, 49, 47);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setEnabled(false);
		btn5.setBounds(508, 102, 49, 47);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setEnabled(false);
		btn6.setBounds(567, 102, 49, 47);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setEnabled(false);
		btn7.setBounds(449, 160, 49, 47);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setEnabled(false);
		btn8.setBounds(508, 160, 49, 47);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setEnabled(false);
		btn9.setBounds(567, 160, 49, 47);
		contentPane.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setEnabled(false);
		btn0.setBounds(508, 218, 49, 47);
		contentPane.add(btn0);
		
		JButton btnBranco = new JButton("Branco");
		btnBranco.setEnabled(false);
		btnBranco.setBackground(Color.WHITE);
		btnBranco.setBounds(407, 294, 80, 29);
		contentPane.add(btnBranco);
		
		JButton btnCorrige = new JButton("Corrige");
		btnCorrige.setEnabled(false);
		btnCorrige.setBackground(SystemColor.desktop);
		btnCorrige.setBounds(497, 294, 80, 29);
		contentPane.add(btnCorrige);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.setEnabled(false);
		btnConfirma.setBackground(new Color(34, 139, 34));
		btnConfirma.setBounds(586, 276, 88, 47);
		contentPane.add(btnConfirma);
		
		TextField txtNomeCandidato = new TextField();
		txtNomeCandidato.setEditable(false);
		txtNomeCandidato.setBounds(226, 142, 174, 22);
		contentPane.add(txtNomeCandidato);
		
		Label label = new Label("Canditado");
		label.setBounds(226, 114, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("N\u00FAmero");
		label_1.setBounds(226, 44, 62, 22);
		contentPane.add(label_1);
		
		TextField txtIDCandidato = new TextField();
		txtIDCandidato.setEditable(false);
		txtIDCandidato.setBounds(226, 72, 174, 22);
		contentPane.add(txtIDCandidato);
		
		JLabel lblAperte = new JLabel("Aperte ");
		lblAperte.setBounds(226, 276, 46, 14);
		contentPane.add(lblAperte);
		
		JLabel lblVerdeParaConfirmar = new JLabel("VERDE para CONFIRMAR");
		lblVerdeParaConfirmar.setBounds(226, 295, 155, 14);
		contentPane.add(lblVerdeParaConfirmar);
		
		JLabel lblLaranjaParaCorrigir = new JLabel("LARANJA para CORRIGIR");
		lblLaranjaParaCorrigir.setBounds(226, 311, 155, 14);
		contentPane.add(lblLaranjaParaCorrigir);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 72, 174, 251);
		contentPane.add(textPane);
		
		JButton btnListarCandidatos = new JButton("Listar Candidatos");
		btnListarCandidatos.setBounds(10, 43, 174, 23);
		contentPane.add(btnListarCandidatos);
		
		JButton btnFinalizarVotao = new JButton("Finalizar Vota\u00E7\u00E3o");
		btnFinalizarVotao.setEnabled(false);
		btnFinalizarVotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnFinalizarVotao.setBounds(497, 395, 177, 55);
		contentPane.add(btnFinalizarVotao);
		
		JButton btnVerificar = new JButton("Verificar");
	
		btnVerificar.setEnabled(false);
		btnVerificar.setBounds(226, 199, 174, 47);
		contentPane.add(btnVerificar);
		
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn1.isEnabled()){
					textoVotoID += '1';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn2.isEnabled()){
					textoVotoID += '2';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn3.isEnabled()){
					textoVotoID += '3';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn4.isEnabled()){
					textoVotoID += '4';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn5.isEnabled()){
					textoVotoID += '5';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn6.isEnabled()){
					textoVotoID += '6';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn7.isEnabled()){
					textoVotoID += '7';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn8.isEnabled()){
					textoVotoID += '8';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn9.isEnabled()){
					textoVotoID += '9';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btn0.isEnabled()){
					textoVotoID += '0';
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btnCorrige.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnCorrige.isEnabled()){
					textoVotoID ="";
					txtIDCandidato.setText(textoVotoID);
				}
			}
		});
		
		btnFinalizarVotao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnFinalizarVotao.isEnabled()){
					ContagemVotos vt = new ContagemVotos();
					vt.setVisible(true);
				     dispose();
				}

			}
		});
		
		btnListarCandidatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btn0.setEnabled(true);
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
				btnBranco.setEnabled(true);
				btnCorrige.setEnabled(true);
				btnVerificar.setEnabled(true);

			}
		});
		
		btnConfirma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnConfirma.isEnabled()){
					//colocar o codigo do botão confirma aqui, no caso, para evento click
					if(!btnFinalizarVotao.isEnabled()){
						btnFinalizarVotao.setEnabled(true);
					}
					
					//exibe uma mensagem dizendo que o voto foi confirmado
			        JOptionPane.showMessageDialog(null, "Voto Confirmado!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			        
			        //seta o textbox do codigo e a string textoVotoID
			        textoVotoID ="";
					txtIDCandidato.setText(textoVotoID);	
					
				}
			}
		});
		
		btnBranco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnBranco.isEnabled()){
					//colocar o codigo do botão branco aqui
					if(!btnFinalizarVotao.isEnabled()){
						btnFinalizarVotao.setEnabled(true);
					}
				}
			}
		});
		
		btnVerificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnConfirma.setEnabled(true);
			}
		});
	}
}
