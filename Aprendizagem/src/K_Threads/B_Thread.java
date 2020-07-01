package K_Threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class B_Thread {
	
	private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(1);

	public static void main(String[] args) {
		
		Casa casa = new Casa(new Quarto());
		casa.obterAfazeresDaCasa().forEach(atividade -> pessoasParaExecutarAtividade.execute(() -> atividade.realizar()));
/*
		List<Future<String>> futuros = new CopyOnWriteArrayList<Future<String>> (casa.obterAfazeresDaCasa().stream().map(
				atividade -> pessoasParaExecutarAtividade.submit(() -> {
					try {
						return atividade.realizar();
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
					return null;
				})
				).collect(Collectors.toList())));
		
		while (true) {
			int numeroDeAtividadesNaoFinalizadas = 0;
			
			for (Future<?> futuro : futuros) {
				if (futuro.isDone) {
					try {
						System.out.println("Parabens! Você terminou de " + futuro.get());
						futuros.remove(futuro);
						
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					catch (ExecutionException e) {
						e.printStackTrace();
					}
				} else {
					numeroDeAtividadesNaoFinalizadas++;
				}
			}
			
			if (futuros.stream().allMatch(Future::isDone))
				break;
				
			System.out.println(numeroDeAtividadesNaoFinalizadas + " tarefas não realizadas");
			Thread.sleep(5000);
		}
*/
		pessoasParaExecutarAtividade.shutdown();
	}
}

class Casa {
	private List<Comodo> comodos;
	
	Casa (Comodo... comodos) {
		this.comodos = Arrays.asList(comodos);
	}
	
	List<Atividade> obterAfazeresDaCasa() {
		return this.comodos.stream().map(Comodo::obterAfazeresDoComodo).reduce(new ArrayList<Atividade>(), (pivo, atividades) -> { pivo.addAll(atividades);
			return pivo;
		});
	}
}

interface Atividade {
	void realizar();
}

abstract class Comodo {
	abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {
	
	@Override
	List<Atividade> obterAfazeresDoComodo() {
		return Arrays.asList(() -> {
			try {
				getArrumarACama();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, () -> {
			try {
				varrerOQuarto();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, () -> {
			try {
				arrumarGuardaRoupa();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
	
	private void arrumarGuardaRoupa() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Arrumando o guarda-roupa.");
	}
	
	private void varrerOQuarto() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Varrendo o quarto.");
	}
	
	private void getArrumarACama() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Arrumando a cama");
	}
}
