package VII_Pacotes;

import java.io.*;

public class Shutdown_PC {

	public static void main(String[] args) throws IOException {

		Runtime runtime = Runtime.getRuntime();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter no. of seconds after which you want your computer to shutdown: ");
		long a = Long.parseLong(br.readLine());
		
		Process proc = runtime.exec("shutdown -s -t " + a);
		
		System.exit(0);
	}
}
