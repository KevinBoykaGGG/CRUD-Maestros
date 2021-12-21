

package com.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.web.app.services.IMaestroService;

@PropertySource(ignoreResourceNotFound = true, value = "mensajes.properties") //esto lo puse porque marcaba error al querer hacer llamar a mensaje.titulo
@Controller
@RequestMapping(path = "/app")
public class IndexController {
	
	
	@Autowired
	private IMaestroService maestroS;

	@Value("${mensaje.titulo}")
	private String titulo;
	
	@RequestMapping(path = { "/", "","/index"} )
	public String index(Model model) {
		model.addAttribute("titulo",titulo);
		model.addAttribute("maestros",maestroS.findAll());
		return "index";
	}

}
