package testes.streams.file;

public class TextGenerator {

	public static String getHTML() {
		return "<html>"
				+ "<body>"
				+ "<h1>CLASSES PARA ESTUDAR</h1>"
				+ "<ol>"
				+ "<h2><li>InputStream</h2></li>"
				+ "<ul>"
				+ "<li>FileInputStream</li>"
				+ "<li>ByteArrayInputStream</li>"
				+ "<li>FilterInputStream <ul><li>BufferedInputStream</li><li>DataInputStream</li></ul></li>"
				+ "<li>ObjectInputStream</li>"
				+ "</ul> <br><br>"
				+ "<h2><li>OutputStream</li></h2>"
				+ "<ul>"
				+ "<li>FileOutputStream</li>"
				+ "<li>ByteArrayOutputStream</li>"
				+ "<li>FilterOutputStream <ul><li>BufferedOutputStream</li><li>DataOutputStream</li></ul></li>"
				+ "<li>ObjectOutputStream</li>"
				+ "</ul>"
				+ "</ol>"
				+ "</body>"
				+ "</html>";
	}
}
