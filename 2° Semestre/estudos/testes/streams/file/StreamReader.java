package testes.streams.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamReader {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream geek = new FileInputStream("C:\\Teste\\ABC.txt");
		
		InputStreamReader in_strm = new InputStreamReader(geek);
		
//		BufferedReader buf = new BufferedReader(in_strm);
		
		int index = 0;
		char[] buffer=new char[10];
		
		while(in_strm.read(buffer, 0, buffer.length) != -1) {
			
			System.out.println(++index);
			System.out.println(buffer);
		}
		
		in_strm.close();
		geek.close();
	}

}
