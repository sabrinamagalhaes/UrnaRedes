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
    private BufferedReader entrada; //gera fluxo de entrada vindo do cliente ( cliente --> servidor )
    private ObjectOutputStream saida; //gera fluxo de saida do servidor para o cliente ( servidor --> cliente )

         
    public Servidor(Socket umCliente) {
    	this.conexao = umCliente;
	}

	public void run(){
    	processarConexao();
    }
	  
    public int processarConexao() {

        try {
            
        	entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        	String str = entrada.readLine();//opcode
        	
        	switch(str){
	        	case "888":
	        		atualizaVotosCandidatos();
	        		break;
	        	case "999":
	        		enviarArquivos("/home/grupo05bsi/");
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
    
    public void enviarArquivos(String caminho) {
    	  
        try {
                        
            FileInputStream file = new FileInputStream(caminho); 
            
            byte[] buf = new byte[4062];
            int i = 0;
            while(true){
                int len = file.read(buf);
                if(len == -1) break;
                saida.write(buf, i, len);
                i++;
            }
            
            file.close();
            saida.flush();

        } catch (Exception e) {
            System.out.println("Erro 6: " + e.getMessage());
        }//fim catch
    }//fim enviarDados
    
    public synchronized void atualizaVotosCandidatos(){    	
		try {
			//Recebe o arquivo do cliente contendo os votos dos candidatos
	    	int i = 0, len = 0;
	    	byte[] buf = new byte[4062];
	    	FileOutputStream file;
			file = new FileOutputStream("CandidatosCliente.dat");
			ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
	    	while(true){
	            len = entrada.read(buf);
	            if(len == -1) break;
	            file.write(buf, i, len);
	            i++;   
	        }
	    	file.close();
	    	entrada.close();
	    	
	    	//Le o arquivo recebido do cliente e coloca os dados dos candidatos em um array
            ArrayList<Candidato> votosCliente = new ArrayList<>();
	    	File arq = new File("CandidatosCliente.dat");
            FileInputStream canoIn = new FileInputStream(arq);
            ObjectInputStream serializador = new ObjectInputStream(canoIn);
            votosCliente = (ArrayList<Candidato>) serializador.readObject();
            serializador.close();
            canoIn.close(); 
            arq.delete();
            
            //Le o arquivo de dados dos candidatos armazenado no servidor e coloca os dados dos candidatos em um array
            ArrayList<Candidato> candidatosServidor = new ArrayList<>();
	    	File arq2 = new File("CandidatosServidor.dat");
            FileInputStream canoIn2 = new FileInputStream(arq2);
            ObjectInputStream serializador2 = new ObjectInputStream(canoIn2);
            candidatosServidor = (ArrayList<Candidato>) serializador2.readObject();
            serializador2.close();
            canoIn2.close();
            
            //Limpa o arquivo de candidatos armazenado no servidor
            PrintWriter pw = new PrintWriter("CandidatosServidor.dat");
            pw.close();
            
            //Incrementa numero de votos dos candidatos
            for(i = 0; i < candidatosServidor.size(); i++){
            	candidatosServidor.get(i).setNumVotos(candidatosServidor.get(i).getNumVotos() + votosCliente.get(i).getNumVotos());
            }
            
            //Reescreve o arquivo do servidor
            File arqNovo = new File("CandidatosServidor.dat");
            FileOutputStream canoOut3 = new FileOutputStream(arqNovo);
            ObjectOutputStream serializador3 = new ObjectOutputStream(canoOut3);
            serializador3.writeObject(candidatosServidor);
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
