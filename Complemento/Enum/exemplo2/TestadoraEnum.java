package exemplo2;

public class TestadoraEnum {
	
	public static void main(String[] args) {
		
		MarcasEnum hp = MarcasEnum.HP;  
        MarcasEnum samsung = MarcasEnum. SAMSUNG;   
        
        System.out.println("Nome da Marca = " + hp.name());
        System.out.println("Nome da Marca = " + samsung.name());
    }
}
