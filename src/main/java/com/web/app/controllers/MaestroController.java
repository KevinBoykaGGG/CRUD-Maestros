package com.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.app.entitys.Maestro;
import com.web.app.services.IMaestroService;




@Controller
@RequestMapping(path = "/app")
public class MaestroController {

	@Autowired
	private IMaestroService maestroS;
	
	@GetMapping(path = { "/agregar" })
	public String agregar(Model model) {
		model.addAttribute("titulo","Agregar Maestro");
		model.addAttribute("maestro", new Maestro());
		return "Maestro/agregar";
	}
	
	@GetMapping(path = { "/buscar" })
	public String buscar(Model model) {
		model.addAttribute("titulo","Busqueda Maestro");
		return "Maestro/busqueda";
	}
	
	@GetMapping(path = { "/busquedaId" })
	public String busquedaId(Model model) {
		model.addAttribute("titulo","Busqueda por ID");
		model.addAttribute("maestro", new Maestro());
		return "Maestro/busquedaNum";
	}
	
	@GetMapping(path = { "/busquedaNom" })
	public String busquedaNom(Model model) {
		model.addAttribute("titulo","Busqueda por nombre");
		model.addAttribute("maestro", new Maestro());
		return "Maestro/busquedaNom";
	}
	@GetMapping(path = { "/busquedaSal" })
	public String busquedaSalNum(Model model) {
		model.addAttribute("titulo","Busqueda por salario");
		model.addAttribute("maestro", new Maestro());
		return "Maestro/busquedaSal";
	}
	
	@GetMapping(path = { "/editar/{id}" })
	public String editar(@PathVariable Integer id,Model model) {
		model.addAttribute("titulo","Editar Maestro");
		model.addAttribute("maestro", maestroS.find(id));
		return "Maestro/editar";
	}
	
	@GetMapping(path = { "/eliminar/{id}" })
	public String eliminar(@PathVariable Integer id,Model model) {
		maestroS.delete(id);
		model.addAttribute("titulo","Maestros");
		model.addAttribute("maestros",maestroS.findAll());
		return "index";
	} 
	
	

}
