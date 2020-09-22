package atividade.administrador.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GeradorLog {
	
	// Caminho relativo
	private static final String path = "./src/atividade/modelo/log/LOG.txt";
	private static final File arquivo = new File(path);

	public static boolean verificarExistenciaArquivo() {

		if(arquivo.exists()) {
			return true;
		}
		return false;
	}
	
	public static void registrarLog(String relato) throws IOException {
//		relato.replaceAll("\n", "");
//		relato.replaceAll("\t", "");
		
		// true -> permite append
		FileWriter fw = new FileWriter(path, true);

		BufferedWriter bw = new BufferedWriter(fw);
		
		if(!verificarExistenciaArquivo()) {
			arquivo.createNewFile();
		}

		bw.append(LocalDateTime.now() + " : " + relato + "\n");
		
		bw.close();
	}
}
