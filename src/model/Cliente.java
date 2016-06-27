package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;	

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
	
	public void enviaVotos(ArrayList<Candidato> candidatos){
		try {
            File arq = new File("Candidatos.dat");
            arq.createNewFile();
            FileOutputStream canoOut = new FileOutputStream(arq);
            ObjectOutputStream serializador = new ObjectOutputStream(canoOut);
            serializador.writeObject(candidatos);
            serializador.flush();
            serializador.close();
            canoOut.close();
            
            dadosAEnviar = new ObjectOutputStream(socketCliente.getOutputStream());
            FileInputStream file = new FileInputStream("Candidatos.dat"); 
            
            byte[] buf = new byte[4062];
            int i = 0;
            while(true){
                int len = file.read(buf);
                if(len == -1) break;
                dadosAEnviar.write(buf, i, len);
                i++;
            }
            dadosAEnviar.flush();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public ArrayList<Candidato> recebeCandidatos(){
		ArrayList<Candidato> candidatos = new ArrayList<>();
        try {
            File arq = new File("Candidatos.dat");
            FileInputStream canoIn = new FileInputStream(arq);
            ObjectInputStream serializador = new ObjectInputStream(canoIn);
            candidatos = (ArrayList<Candidato>) serializador.readObject();
            serializador.close();
            canoIn.close();            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candidatos;
    }
}