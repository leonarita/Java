package aula12.model.cargo;

// Classe de domínio da entidade Cargo.
// Juntas, as classes de domínio modelam a estrutura de negócio da aplicação.
// Possuem basicamente atributos e seus respectivos métodos get e set, 
// usados para recuperação e atribuição de valores aos seus dados.

// DICA: Para criar automaticamente os métodos get e set para os atributos da classe, no editor 
// de código, clique com o botão direito do mouse no código >> Source >> Generate Getters and Setters.

public class Cargo { // Classe de domínio da entidade Cargo.
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
	
	// Sobrescreve o método toString da classe Object, para que ele retorne o valor do atributo Descricao.
	// Com isso, o JComboBox do formulário de cadastro de funcionários mostrará apenas a descrição dos cargos.
	
	// Object é a raiz da hierarquia de classes do Java. Ela é superclasse de todas as demais classes, 
	// inclusive das classes criadas pelo usuário. Sendo a base para todas as classes, Object define alguns 
	// comportamentos comuns que todos objetos devem ter, como a habilidade de serem comparados uns com os outros, 
	// utilizando equals(), e poderem ser representados como texto, com o método toString().
	@Override
    public String toString() {
        return descricao;
    }
}