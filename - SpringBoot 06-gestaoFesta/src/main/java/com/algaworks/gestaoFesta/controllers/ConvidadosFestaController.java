package com.algaworks.gestaoFesta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.gestaoFesta.models.ConvidadoFesta;
import com.algaworks.gestaoFesta.repositories.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosFestaController {

	@Autowired
	private Convidados convidados;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject("c", new ConvidadoFesta());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(ConvidadoFesta convidado) {
		convidados.save(convidado);
		return "redirect:/convidados";
	}
}
