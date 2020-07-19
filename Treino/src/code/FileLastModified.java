package code;

import java.io.File;
import java.util.Date;

public class FileLastModified {

	public static void main (String[] args) {
		
		try {
			File f = new File("C:/Users/leo_n/agenda");
			
			boolean bool = f.exists();
			
			if (bool) {
				long millisec = f.lastModified();
				Date dt = new Date(millisec);
				String path = f.getPath();
				
				System.out.println("\n" + path + " last modified at: " + dt + "\n");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
