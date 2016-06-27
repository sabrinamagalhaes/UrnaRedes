package model;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;	

public class Cliente {
	
	private Socket socketCliente;
    private String hostname = "cosmos.lasdpc.icmc.usp.br";
    private int porta = 40005; 
    
    private ObjectOutputStream dadosAEnviar;
	
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
}