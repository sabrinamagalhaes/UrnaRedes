package model;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PopulateFile{

	public static void main(String args[]) throws IOException{
		ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
		
		candidatos.add(new Candidato(1111,"Caio","PT",0));
		candidatos.add(new Candidato(2222,"Sabrina","PSDB",0));
		candidatos.add(new Candidato(3333,"Thomás","PSOL",0));
		candidatos.add(new Candidato(0000,"Branco","",0));

		File arq = new File("/home/grupo05bsi/CandidatosServidor.dat");
    	arq.createNewFile();
		FileOutputStream canoOut = new FileOutputStream("/home/grupo05bsi/CandidatosServidor.dat");
		ObjectOutputStream serializador = new ObjectOutputStream(canoOut);
		serializador.writeObject(candidatos);
		serializador.flush();
		serializador.close();
		canoOut.close();
	}

}
