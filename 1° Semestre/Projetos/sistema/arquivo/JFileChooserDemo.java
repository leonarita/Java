package sistema.arquivo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFileChooserDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	// exibe o conteúdo do arquivo
	private final JTextArea outputArea; 
	
	// configura a GUI
	public JFileChooserDemo() throws IOException {
		super("JFileChooser Demo");
		outputArea = new JTextArea();
		
		// outputArea é rolável
		add(new JScrollPane(outputArea));

		// obtém o Path do usuário e exibe informações
		analyzePath(); 
	}
	
	// exibe informações sobre o arquivo ou diretório que o usuário especifica
	public void analyzePath() throws IOException {
		
		// obtém o Path para o arquivo ou diretório selecionado pelo usuário
		Path path = getFileOrDirectoryPath();
	
		// se existir, exibe as informações
		if (path != null && Files.exists(path))  {
			
			// coleta as informações sobre o arquivo (ou diretório)
			StringBuilder builder = new StringBuilder();
			
			builder.append(String.format("%s:%n", path.getFileName()));
			builder.append(String.format("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not"));
			builder.append(String.format("%s an absolute path%n", path.isAbsolute() ? "Is" : "Is not"));
			builder.append(String.format("Last modified: %s%n", Files.getLastModifiedTime(path)));
			builder.append(String.format("Size: %s%n", Files.size(path)));
			builder.append(String.format("Path: %s%n", path));
			builder.append(String.format("Absolute path: %s%n", path.toAbsolutePath()));
			
			// listagem de diretório de saída
			if (Files.isDirectory(path)) {
				builder.append(String.format("%nDirectory contents:%n"));
			
				// objeto para iteração pelo conteúdo de um diretório
				DirectoryStream<Path> directoryStream =
				Files.newDirectoryStream(path);
				
				for (Path p : directoryStream)
					builder.append(String.format("%s%n", p));
			}
			
			outputArea.setText(builder.toString()); // exibe o conteúdo de String
		}
		
		// Path não existe
		else 
		{
			JOptionPane.showMessageDialog(this, path.getFileName() + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// permite que o usuário especifique o nome de arquivo ou diretório
	private Path getFileOrDirectoryPath() {
		
		// configura o diálogo permitindo a seleção de um arquivo ou diretórioÿ
		JFileChooser fileChooser = new JFileChooser(); 
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
		int result = fileChooser.showOpenDialog(this); 
		
		// se o usuário clicou no botão Cancel no diálogo, retorna
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		// retorna o Path representando o arquivo selecionado
		return fileChooser.getSelectedFile().toPath();
	}
} 
