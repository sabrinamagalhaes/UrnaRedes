package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
	        		//Atualizar o numero de votos dos candidatos
	        		break;
	        	case "999":
	        		enviarArquivos("Caminho do arquivo com nome dos candidatos");
	        		break;
        		default:
        			
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
    
}
