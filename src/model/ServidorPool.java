package model;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPool {
	
	public static void main(String args[]){
		try{
			ServerSocket servidor = new ServerSocket(40005, 10);
			while(true){
				Socket SERVIDOR_SOCKET = servidor.accept();
				Servidor threadServidora =	new	Servidor(SERVIDOR_SOCKET);
				threadServidora.start();
			}			
			
		}
		catch(Exception e){
			
		}
	}
	
}
