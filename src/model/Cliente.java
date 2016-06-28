package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;	

public class Cliente extends Thread{
	
	private Socket socketCliente;
    private String hostname = "cosmos.lasdpc.icmc.usp.br";
    private int porta = 40005; 
    
    private ObjectOutputStream dadosAEnviar;
	
    public void run(){
    	this.criarConexao();
    }
    
	public int criarConexao() {

        try {
			this.socketCliente = new Socket (this.hostname, this.porta);
			
			System.out.println("Cliente conectado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return 0;	
	}
	
	public void enviaOpcao(String opcao){
        try {
        	dadosAEnviar = new ObjectOutputStream(socketCliente.getOutputStream());
            dadosAEnviar.flush();
            dadosAEnviar.writeObject(opcao);
            dadosAEnviar.flush();
            dadosAEnviar.close();
        } catch (Exception e) {
            System.out.println("Erro 6: " + e.getMessage());
        }
	}
	
	public void enviaVotos(ArrayList<Candidato> candidatos){
		try {
			//Coloca o array com os dados e votos dos candidatos em um arquivo
            ObjectOutputStream saida = new ObjectOutputStream(socketCliente.getOutputStream());            
            saida.writeObject(candidatos);
            saida.flush();
            saida.close();            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public ArrayList<Candidato> recebeCandidatos(){
		ArrayList<Candidato> candidatos = new ArrayList<>();
        try {        	
        	//Recebe o array do servidor contendo os dados dos candidatos
        	ObjectInputStream entrada = new ObjectInputStream(socketCliente.getInputStream());
        	System.out.println("AQUI");
        	candidatos = (ArrayList<Candidato>) entrada.readObject();
        	entrada.close();           
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candidatos;
    }
}