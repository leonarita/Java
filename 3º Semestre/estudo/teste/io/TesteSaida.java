package teste.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class TesteSaida {

	public static void main(String[] args) throws IOException {
		
		// sa�da com OutputStream
		
		OutputStream os = new FileOutputStream("saida.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("Testando a escrita em arquivo");
		bw.newLine();
		bw.write("Conte�do na pr�xima linha");
		bw.close();
		
		// sa�da com PrintStream
		
		PrintStream out = new PrintStream("saida02.txt");
		out.println("Testando a escrita em arquivo");
		out.println("Conte�do na pr�xima linha");
		out.close();
	}
}