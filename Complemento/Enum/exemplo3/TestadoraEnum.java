package exemplo3;

public class TestadoraEnum {

	public static void comparaEnum(OpcoesMenu opcao) {
		
        if(opcao.equals(OpcoesMenu.SALVAR))
            System.out.println("Foi escolhido a op��o Salvar");
        
        else if(opcao.equals(OpcoesMenu.ABRIR))
            System.out.println("Foi escolhido a op��o ABRIR");
        
        else if(opcao.equals(OpcoesMenu.FECHAR))
            System.out.println("Foi escolhido a op��o FECHAR");
    }
     
    public static void main(String[] args) {
        comparaEnum(OpcoesMenu.SALVAR);
    }
}
