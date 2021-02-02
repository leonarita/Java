package modelo.repositorio;

import javax.persistence.EntityTransaction;

import modelo.ContaEspecial;

public class ContaEspecialRepository extends PersistenceConfig {

	public boolean criarContaEspecial(ContaEspecial contaEspecial) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			getEntityManager().persist(contaEspecial);
			transaction.commit();
		}
		catch (Exception e) {

			System.out.println("Erro ao tentar persistir a conta especial! " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public ContaEspecial recuperarContaEspecialPorNumeroConta(long numeroConta) {

		ContaEspecial resultado = null;
		
		try {
			resultado = getEntityManager().find(ContaEspecial.class, numeroConta);
		}
		catch (Exception e) {

			System.out.println("Erro ao tentar recuperar a conta especial! " + e.getMessage());
			e.printStackTrace();
			resultado = null;
		}
		
		return resultado;
	}
	
	public boolean atualizarContaEspecial(ContaEspecial contaEspecial) {

		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			getEntityManager().merge(contaEspecial);
			transaction.commit();
		}
		catch (Exception e) {

			System.out.println("Erro ao tentar atualizar a conta especial! " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public boolean excluirContaEspecial(ContaEspecial contaEspecial) {

		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {	
			
			transaction.begin();
			contaEspecial = getEntityManager().find(ContaEspecial.class, contaEspecial.getNumeroConta());
			getEntityManager().remove(contaEspecial);
			transaction.commit();
		}
		catch (Exception e) {

			System.out.println("Erro ao tentar remover a Conta especial! " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
}
