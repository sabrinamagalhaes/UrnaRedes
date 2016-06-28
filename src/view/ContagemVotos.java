package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Candidato;

import javax.swing.JLabel;
import javax.swing.JTextPane;

public class ContagemVotos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContagemVotos frame = new ContagemVotos();
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
	public ContagemVotos(ArrayList<Candidato> listaCandidatos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResultadoDaVotao = new JLabel("Resultado da Vota\u00E7\u00E3o:");
		lblResultadoDaVotao.setBounds(26, 11, 227, 14);
		contentPane.add(lblResultadoDaVotao);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(26, 36, 637, 398);
		contentPane.add(textPane);
		
		String candidatoNome;
		int candidatoNumero;
		int candidatoVotos;
		String candidatoPartido;
		String TextoExibido="";
		int i = 0;
		
		
		while(i != listaCandidatos.size()){
			candidatoNome = listaCandidatos.get(i).getNomeCandidato();
			candidatoNumero = listaCandidatos.get(i).getCodigoVotacao();
			candidatoPartido = listaCandidatos.get(i).getPartido();
			candidatoVotos = listaCandidatos.get(i).getNumVotos();
			TextoExibido +="Nome: "+candidatoNome +" Nº: "+candidatoNumero
					+" Partido: "+candidatoPartido+" NºVotos: "+candidatoVotos+"\n";
			i++;
		}
		textPane.setText(TextoExibido);
	}
}
