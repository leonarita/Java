package modelo.repositorio;

import javax.persistence.EntityTransaction;

import modelo.ContaPoupanca;

public class ContaPoupancaRepository extends PersistenceConfig {

	public boolean criarContaPoupanca(ContaPoupanca contaPoupanca) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			getEntityManager().persist(contaPoupanca);
			transaction.commit();
		}
		catch (Exception e) {

			System.out.println("Erro ao tentar persistir a conta poupança! " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public ContaPoupanca recuperarContaPoupancaPorNumeroConta(long numeroConta) {

		ContaPoupanca resultado = null;
		
		try {
			resultado = getEntityManager().find(ContaPoupanca.class, numeroConta);
		}
		catch (Exception e) {

			System.out.println("Erro ao tentar recuperar a conta poupança! " + e.getMessage());
			e.printStackTrace();
			resultado = null;
		}
		
		return resultado;
	}
	
	public boolean atualizarContaPoupanca(ContaPoupanca contaPoupanca) {

		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			getEntityManager().merge(contaPoupanca);
			transaction.commit();
		}
		catch (Exception e) {

			System.out.println("Erro ao tentar atualizar a conta poupança! " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public boolean excluirContaPoupanca(ContaPoupanca contaPoupanca) {

		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {	
			
			transaction.begin();
			contaPoupanca = getEntityManager().find(ContaPoupanca.class, contaPoupanca.getNumeroConta());
			getEntityManager().remove(contaPoupanca);
			transaction.commit();
		}
		catch (Exception e) {

			System.out.println("Erro ao tentar remover a Conta poupança! " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
}
