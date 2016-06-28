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

public class Cliente{
	
	private Socket socketCliente;
    private String hostname = "cosmos.lasdpc.icmc.usp.br";
    private int porta = 40005; 
    private int opcao; 
    private ObjectOutputStream dadosAEnviar;
    private ArrayList<Candidato> listaCandidatos;
    
    public Cliente(int opcao){
    	this.opcao = opcao;
    }
	
    public void run(){
    	this.criarConexao();
    	switch(opcao){
    	case 0:
    		enviaOpcao("999");
    		this.setListaCandidatos(this.recebeCandidatos());
    		break;
    	case 1:
    		enviaOpcao("888");
    		enviaVotos(listaCandidatos);
    		break;    		
    	}
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
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public ArrayList<Candidato> recebeCandidatos(){
		ArrayList<Candidato> candidatos = new ArrayList<>();
        try {        	
        	//Recebe o array do servidor contendo os dados dos candidatos
        	ObjectInputStream entrada = new ObjectInputStream(socketCliente.getInputStream());
        	candidatos = (ArrayList<Candidato>) entrada.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candidatos;
    }

	public ArrayList<Candidato> getListaCandidatos() {
		return listaCandidatos;
	}

	public void setListaCandidatos(ArrayList<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}
}