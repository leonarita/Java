package teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProgramacaoFuncional_3 {

	public static void main(String[] args) {
		fluxoAleatorio();
		System.out.println();
		//streamOfLines()
	}
	
	public static void fluxoAleatorio() {
		SecureRandom random = new SecureRandom();

		System.out.printf("%-6s%s%n", "Face", "Frequency");
		
		random.ints(6_000_000, 1, 7).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.forEach((face, frequency) -> System.out.printf("%-6d%d%n", face, frequency));
	}
	
	public static void streamOfLines() throws IOException {
		Pattern pattern = Pattern.compile("\\s+");

		Map<String, Long> wordCounts = Files.lines(Paths.get("Chapter2Paragraph.txt"))
				.map(line -> line.replaceAll("(?!')\\p{P}", "")).flatMap(line -> pattern.splitAsStream(line))
				.collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));
		
		wordCounts.entrySet().stream().collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0), TreeMap::new, Collectors.toList()))
				.forEach((letter, wordList) -> {
					System.out.printf("%n%C%n", letter);
					wordList.stream().forEach(word -> System.out.printf("%13s: %d%n", word.getKey(), word.getValue()));
				});
	}
}
