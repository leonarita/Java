package g.composite;

public class Main {
	
	public static void main(String[] args) throws Exception {
		TrechoSimples ts1 = new TrechoSimples("São Paulo", "Brasília", 500);
		TrechoSimples ts2 = new TrechoSimples("Brasília", "Recife", 300);
		TrechoSimples ts3 = new TrechoSimples("Recife","Natal", 350);
		
		TrechoComposto tc1 = new TrechoComposto(ts2, ts3, 30);
		TrechoComposto tc2 = new TrechoComposto(ts1, tc1, 50);
	}

}
