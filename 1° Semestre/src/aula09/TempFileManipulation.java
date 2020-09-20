package aula09;

import java.io.File;
import java.io.IOException;

public class TempFileManipulation {

	public static void createTempFile(String file) {
        try {
            File temp = File.createTempFile(file, ".tmp");
            System.out.println("Temp file: " + temp.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
