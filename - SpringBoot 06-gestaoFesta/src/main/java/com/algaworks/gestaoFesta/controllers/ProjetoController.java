package com.algaworks.gestaoFesta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetoController {

	@GetMapping("/")
	public String salvar() {
		return "redirect:/convidados";
	}
}
