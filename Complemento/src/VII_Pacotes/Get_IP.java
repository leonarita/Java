package VII_Pacotes;

import java.net.InetAddress;

public class Get_IP {

	public static void main(String[] args) throws Exception {
		InetAddress myIP = InetAddress.getLocalHost();
		System.out.println("My IP Address is:");
		System.out.println(myIP.getHostAddress());
	}
}
