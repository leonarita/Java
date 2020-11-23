package teste;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteData {
	
	public static void main (String[] args) {

		SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(s.format(new Date()));
	}	
}
