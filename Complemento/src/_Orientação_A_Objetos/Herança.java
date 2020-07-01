package _Orienta��o_A_Objetos;

//Importando a classe JOptionPane
import javax.swing.JOptionPane;
//import javax.swing.*;

//Definir a classe

//Super classe
class Fornecedor 
{
	//Criando os atributos
	//Visibilidade - diretiva
	private String nome;
	private String fone;

	//M�todo construtor
	Fornecedor()
	{   this ("sem nome", "(00)0000-0000");    
	}

	Fornecedor (String nome, String fone)
	{   this.nome = nome;
	    this.fone = fone;
	}
	  
	//setters
	  
	//tipo nome (par�metro)
	public void setNome (String nome)
	{   //atributo = conteudo da vari�vel comum
		this.nome = nome;
	}
	  
	public void setFone (String fone)
	{    this.fone = fone;
	}
	  
	//getters
	  
	public String getNome ()
	{    return this.nome;
	}
	
	public String getFone ()
	{   return fone;
	}
}

//criar a classe filha
class FornecedorPessoa extends Fornecedor
{
	//Atributos
	private String rg;
	private String cpf;

	FornecedorPessoa ()
	{   //this -> referencia pr�pria classe
		this (" ", " ", " ", " ");
	}

	FornecedorPessoa (String nome, String fone, String rg, String cpf)
	{
		//super -> referencia classe m�e
		super (nome, fone);
		this.rg = rg;
		this.cpf = cpf;
	}

	//setters
	public void setRg (String rg)
	{   this.rg = rg;
	}

	public void setCpf (String cpf)
	{   this.cpf = cpf;
	}

	//getters

	public String getRg ()
	{   return this.rg;
	}

	public String getCpf ()
	{   return cpf;
	}
}

class FornecedorEmpresa extends Fornecedor
{
	//Atributos
	private String ie;
  private String cnpj;
  
  FornecedorEmpresa ()
  {   //this -> referencia pr�pria classe
      this (" ", " ", " ", " ");
  }
  
  FornecedorEmpresa (String nome, String fone, String ie, String cnpj)
  {
      //super -> referencia classe m�e
      super (nome, fone);
      this.ie = ie;
      this.cnpj = cnpj;
  }
  
  //setters
  public void setIe (String ie)
  {   this.ie = ie;
  }
  
  public void setCnpj (String cnpj)
  {   this.cnpj = cnpj;
  }
  
  //getters
  
  public String getIe ()
  {   return this.ie;
  }
  
  public String getCnpj ()
  {   return cnpj;
  }
}

public class Heran�a 
{
	//M�todo principal
  public static void main (String args[])
  {
      //Criar e instanciar os objetos
      //classe objeto = new m�todo construtor
      Fornecedor objFornecedor = new Fornecedor();
      
      //Inserir informa��es
      objFornecedor.setNome (new String ("Ana Caroline"));
      objFornecedor.setFone (new String("(11)99984-1254"));
      
      //Criando vari�vel para agregar valores
      String st = "Dados Fornecedor \n" + "\nNome     :  " + objFornecedor.getNome() + "\nFone      :  " + objFornecedor.getFone();
      
      //Exibindo o resultado
      JOptionPane.showMessageDialog(null, st, "Mensagem", 3);
      
//--------------------------------------------------------------------------------------------        
      
      //Criando e instanciando o objeto
      FornecedorPessoa objFornecedorPessoa = new FornecedorPessoa();
      
      //objeto.m�todo
      objFornecedorPessoa.setNome(new String ("Paulo Santos"));
      objFornecedorPessoa.setFone(new String ("(11) 9875-1235"));
      objFornecedorPessoa.setRg("18.125.765-9");
      objFornecedorPessoa.setCpf ("132.654.987.89");
      
      //Criando vari�vel para agregar valores
      String te = "Dados Fornecedor \n" + "\nNome     :  " + objFornecedorPessoa.getNome() 
                                        + "\nFone     :  " + objFornecedorPessoa.getFone()
                                        + "\nRG       :  " + objFornecedorPessoa.getRg()
                                        + "\nCPF      :  " + objFornecedorPessoa.getCpf();
              
      //Exibindo o resultado
      JOptionPane.showMessageDialog(null, te, "Mensagem", 1);
      
//--------------------------------------------------------------------------------------------   
      
    //Criando e instanciando o objeto
      FornecedorEmpresa objFornecedorEmpresa = new FornecedorEmpresa();
      
      //objeto.m�todo
      objFornecedorEmpresa.setNome(new String ("IFSP"));
      objFornecedorEmpresa.setFone(new String ("(11) 9875-1235"));
      objFornecedorEmpresa.setIe("18.125.765-9");
      objFornecedorEmpresa.setCnpj ("132.654.0001/78");
      
      //Criando vari�vel para agregar valores
      String text = "Dados Fornecedor \n" + "\nNome     :  " + objFornecedorEmpresa.getNome() 
                                        + "\nFone     :  " + objFornecedorEmpresa.getFone()
                                        + "\nIE       :  " + objFornecedorEmpresa.getIe()
                                        + "\nCNPJ     :  " + objFornecedorEmpresa.getCnpj();
              
      //Exibindo o resultado
      JOptionPane.showMessageDialog(null, text, "Mensagem", 2);
      
      System.exit(0);
  }
}
