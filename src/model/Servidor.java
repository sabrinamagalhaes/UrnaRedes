package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor extends Thread{

    private Socket conexao = null; //conexao com o cliente
    private ObjectInputStream entrada; //gera fluxo de entrada vindo do cliente ( cliente --> servidor )
    private ObjectOutputStream saida; //gera fluxo de saida do servidor para o cliente ( servidor --> cliente )

         
    public Servidor(Socket umCliente) {
    	this.conexao = umCliente;
	}

	public void run(){
    	processarConexao();
    }
	  
    public int processarConexao() {

        try {
            
        	entrada = new ObjectInputStream(conexao.getInputStream());
        	String str = (String) entrada.readObject();//opcode
        	
        	switch(str){
	        	case "888":
	        		atualizaVotosCandidatos();
	        		break;
	        	case "999":
	        		enviarDados("/home/grupo05bsi/CandidatosServidor.dat");
	        		break;
        		default:
        			System.out.println("OPCode nao reconhecido!");
        	}
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro 4: " + e.getMessage());
        }//fim catch

        return 0;

    }//fim processarConexao
    
    public void enviarDados(String nomeArquivo) {
    	  
        try {                        
            FileInputStream file = new FileInputStream(nomeArquivo);
            ObjectInputStream leArquivo = new ObjectInputStream(file);
            ArrayList<Candidato> listaCandidatos = (ArrayList<Candidato>) leArquivo.readObject();
            
            ObjectOutputStream dadosAEnviar = new ObjectOutputStream(conexao.getOutputStream());
            dadosAEnviar.writeObject(listaCandidatos);
            
            dadosAEnviar.flush();
            dadosAEnviar.close();
            leArquivo.close();
        } catch (Exception e) {
            System.out.println("Erro 6: " + e.getMessage());
        }//fim catch
    }//fim enviarDados
    
    
    public synchronized void atualizaVotosCandidatos(){    	
		try {
			//Recebe o array do cliente contendo os votos dos candidatos
			ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
        	System.out.println("AQUI");
        	ArrayList<Candidato> candidatosCliente = (ArrayList<Candidato>) entrada.readObject();
        	entrada.close();    
            
            //Le o arquivo de dados dos candidatos armazenado no servidor e coloca os dados dos candidatos em um array
        	FileInputStream file = new FileInputStream("/home/grupo05bsi/CandidatosServidor.dat");
            ObjectInputStream leArquivo = new ObjectInputStream(file);
            ArrayList<Candidato> listaCandidatosServidor = (ArrayList<Candidato>) leArquivo.readObject();
            
            //Limpa o arquivo de candidatos armazenado no servidor
            PrintWriter pw = new PrintWriter("/home/grupo05bsi/CandidatosServidor.dat");
            pw.close();
            
            //Incrementa numero de votos dos candidatos
            for(int i = 0; i < listaCandidatosServidor.size(); i++){
            	listaCandidatosServidor.get(i).setNumVotos(listaCandidatosServidor.get(i).getNumVotos() + candidatosCliente.get(i).getNumVotos());
            }
            
            //Reescreve o arquivo do servidor
            File arqNovo = new File("/home/grupo05bsi/CandidatosServidor.dat");
            FileOutputStream canoOut3 = new FileOutputStream(arqNovo);
            ObjectOutputStream serializador3 = new ObjectOutputStream(canoOut3);
            serializador3.writeObject(listaCandidatosServidor);
            serializador3.flush();
            serializador3.close();
            canoOut3.close();           
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
