package atividade_DataPersistence.modelo.designPattern.facade;

import java.time.LocalDateTime;

import atividade_DataPersistence.modelo.ContaComum;
import atividade_DataPersistence.modelo.Movimento;
import atividade_DataPersistence.modelo.repositorio.MovimentoDAO;

public class MovimentoFacade {

	// M�todo interno auxiliar. Optei por implement�-lo para que o m�todo registrarMovimento n�o ficasse t�o extenso.
	private static boolean efetivarMovimento(Movimento m) {
	
		// true=Sucesso e false=Falha
		boolean resultado = false; 
			
		if (m.getContaMovimento() != null) {
							
			// Garante que eu tenho em this.contaMovimento os dados mais atuais da conta
			m.setContaMovimento(ContaComum.getCcDao().obterContaComumPorNumeroContaESenha
					(m.getContaMovimento().getNumeroConta(), m.getContaMovimento().getSenhaConta()));
				
			// Se deu certo a consulta anterior
			if (m.getContaMovimento() != null) {
					
				// Dep�sito
				if (m.getTipoMovimento() == 1) {
						
					m.getContaMovimento().setSaldoConta(m.getContaMovimento().emitirSaldo() + m.getValorMovimento());
					ContaComum.getCcDao().atualizarContaComum(m.getContaMovimento());
					resultado = true;
						
					System.out.println("Dep�sito efetuado com sucesso!");
				} 
					
				// Saque
				else if (m.getTipoMovimento() == 2) {
						
					if (m.getContaMovimento().emitirSaldo() >= m.getValorMovimento()) {
							
						// S� � poss�vel sacar se existir saldo suficiente
						m.getContaMovimento().setSaldoConta(m.getContaMovimento().emitirSaldo() - m.getValorMovimento());
						ContaComum.getCcDao().atualizarContaComum(m.getContaMovimento());
						resultado = true;
							
						System.out.println("Saque efetuado com sucesso!");
					} 
					else {
						System.out.println("Saque n�o p�de ser efetivado. Sem saldo!");
					}
				}
			}
		}
		
		return resultado;
	}
		
	public static int registrarMovimento(Movimento m, int tipoMovimento, double valorMovimento) {
			
		// 1=Sucesso e 0=Fracasso
		int resultado = 0; 
			
		// Somente registra se existir conta vinculada
		if (m.getContaMovimento() != null) {
				
			m.setTipoMovimento(tipoMovimento);
			m.setDataHoraMovimento(LocalDateTime.now());
			m.setValorMovimento(valorMovimento);
				
			// Somente registra se o movimento for efetivado na conta
			if (efetivarMovimento(m)) {
					
				MovimentoDAO mDAO = new MovimentoDAO();
					
				// Persiste este objeto, registrando o movimento no BD.
				m.setIdMovimento(mDAO.criarMovimento(m));
					
				// Sucesso na inser��o
				if (m.getIdMovimento() > 0) {
					resultado = 1;
				}
					
				mDAO = null;
			}
		}
			
		return resultado;
	}
}