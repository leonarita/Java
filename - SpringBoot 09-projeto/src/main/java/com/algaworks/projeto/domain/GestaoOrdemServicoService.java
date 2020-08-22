package com.algaworks.projeto.domain;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.projeto.exceptionhnadler.EntidadeNaoEncontradaException;
import com.algaworks.projeto.exceptionhnadler.NegocioException;
import com.algaworks.projeto.models.Cliente;
import com.algaworks.projeto.models.Comentario;
import com.algaworks.projeto.models.OrdemServico;
import com.algaworks.projeto.models.StatusOrdemServico;
import com.algaworks.projeto.repositories.ClienteRepository;
import com.algaworks.projeto.repositories.ComentarioRepository;
import com.algaworks.projeto.repositories.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
    private ClienteRepository clienteRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}
	
	public void finalizar(Long ordemServicoId) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		
		ordemServico.finalizar();
		ordemServicoRepository.save(ordemServico);
	}
	
	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
	    OrdemServico ordemServico = buscar(ordemServicoId);

	    Comentario comentario = new Comentario();
	    comentario.setDataEnvio(OffsetDateTime.now());
	    comentario.setDescricao(descricao);
	    comentario.setOrdemServico(ordemServico);

	    return comentarioRepository.save(comentario);
	}

	private OrdemServico buscar(Long ordemServicoId) {
		return ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrado"));
	}
}
