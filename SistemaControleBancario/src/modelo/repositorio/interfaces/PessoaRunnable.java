package modelo.repositorio.interfaces;

import java.util.Date;

import modelo.Pessoa;
import modelo.repositorio.PessoaRepository;

public class PessoaRunnable implements Runnable {
	
	private Pessoa p;
	private PessoaRepository pr;
	
	public PessoaRunnable(Pessoa p, PessoaRepository pr) {
		this.p = p;
		this.pr = pr;
	}

	@Override
	public void run() {
		while(true) {
			if(new Date().getSeconds() == 0) {
				pr.criarPessoa(p);
				break;
			}
		}
	}

}
