package atividade.administrador.log;

import java.io.IOException;

public class GravarErro {

	public static void relatarErro(String e) {
		try {
			GeradorLog.registrarLog(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
