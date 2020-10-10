package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CargoRepository {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CargoRepository() {
		emf = Persistence.createEntityManagerFactory("abc");
		em = emf.createEntityManager();
	}

	public void salvar(Cargo c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Cargo c) {
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> listarTodos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select c from Cargo c");
		List<Cargo> clientes = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return clientes;
	}
	
	public Cargo obterPorId(int id) {
		em.getTransaction().begin();
		Cargo c = em.find(Cargo.class, id);
		em.getTransaction().commit();
		emf.close();
		return c;
	}
}
