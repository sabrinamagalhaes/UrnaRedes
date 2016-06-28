package model;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PopulateFile{

	public static void main(String args[]) throws IOException{
		ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
		
		candidatos.add(new Candidato(1111,"Caio","PQP",0));
		candidatos.add(new Candidato(1112,"Caiolino","GAP",0));
		candidatos.add(new Candidato(1113,"Caiuu","GOT",0));
		candidatos.add(new Candidato(0000,"Branco","S/P",0));

		File arq = new File("CandidatosServidor.dat");
    	arq.createNewFile();
		FileOutputStream canoOut = new FileOutputStream("CandidatosServidor.dat");
		ObjectOutputStream serializador = new ObjectOutputStream(canoOut);
		serializador.writeObject(candidatos);
		serializador.flush();
		serializador.close();
		canoOut.close();
	}

}
