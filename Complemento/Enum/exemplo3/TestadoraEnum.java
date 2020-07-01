package exemplo3;

public class TestadoraEnum {

	public static void comparaEnum(OpcoesMenu opcao) {
		
        if(opcao.equals(OpcoesMenu.SALVAR))
            System.out.println("Foi escolhido a opção Salvar");
        
        else if(opcao.equals(OpcoesMenu.ABRIR))
            System.out.println("Foi escolhido a opção ABRIR");
        
        else if(opcao.equals(OpcoesMenu.FECHAR))
            System.out.println("Foi escolhido a opção FECHAR");
    }
     
    public static void main(String[] args) {
        comparaEnum(OpcoesMenu.SALVAR);
    }
}
