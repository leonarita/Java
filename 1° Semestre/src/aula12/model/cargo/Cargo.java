package aula12.model.cargo;

// Classe de dom�nio da entidade Cargo.
// Juntas, as classes de dom�nio modelam a estrutura de neg�cio da aplica��o.
// Possuem basicamente atributos e seus respectivos m�todos get e set, 
// usados para recupera��o e atribui��o de valores aos seus dados.

// DICA: Para criar automaticamente os m�todos get e set para os atributos da classe, no editor 
// de c�digo, clique com o bot�o direito do mouse no c�digo >> Source >> Generate Getters and Setters.

public class Cargo { // Classe de dom�nio da entidade Cargo.
	int idCargo;
	String descricao;
	String departamento;
	
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public int getIdCargo() {
		return idCargo;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getDepartamento() {
		return departamento;
	}
	
	// Sobrescreve o m�todo toString da classe Object, para que ele retorne o valor do atributo Descricao.
	// Com isso, o JComboBox do formul�rio de cadastro de funcion�rios mostrar� apenas a descri��o dos cargos.
	
	// Object � a raiz da hierarquia de classes do Java. Ela � superclasse de todas as demais classes, 
	// inclusive das classes criadas pelo usu�rio. Sendo a base para todas as classes, Object define alguns 
	// comportamentos comuns que todos objetos devem ter, como a habilidade de serem comparados uns com os outros, 
	// utilizando equals(), e poderem ser representados como texto, com o m�todo toString().
	@Override
    public String toString() {
        return descricao;
    }
}