package metaprogramming.cap4.ex1;

public class App {

	public static void main(String[] args) {
		SystemProperties sp = SystemPropertiesRetriever.criar(SystemProperties.class);

		System.out.println(sp.getUserHome());
		System.out.println(sp.getUserCountry());
		System.out.println(sp.getUserLanguage());
		System.out.println(sp.getFileSeparator());
		System.out.println(sp.getJavaHome());
		System.out.println(sp.getJavaVmSpecificationVersion());
	}
}
