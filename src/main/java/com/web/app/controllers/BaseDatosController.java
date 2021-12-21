package com.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.app.entitys.Maestro;

import com.web.app.services.IMaestroService;

@PropertySource(ignoreResourceNotFound = true, value = "mensajes.properties") //esto lo puse porque marcaba error al querer hacer llamar a mensaje.titulo
@Controller
@RequestMapping(path = "/bd")
public class BaseDatosController {
	
	@Autowired
	private IMaestroService maestroS;

	@Value("${mensaje.id}")
	private String titulo;
	
	@Value("${mensaje.nombre}")
	private String titulo2;
	
	@Value("${mensaje.agregar}")
	private String titulo3;
	

	@Value("${mensaje.editar}")
	private String titulo4;
	
	@Value("${mensaje.salarios}")
	private String titulo5;
	
	
	@PostMapping(path= "agregar")
	public String form(@Valid Maestro m,BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo",titulo3);
			return "Maestro/agregar";
		}
		if(maestroS.find(m.getId()) != null) {
			
			model.addAttribute("advertencia","El ID que intentas poner ya existe");
			model.addAttribute("titulo",titulo3);
			return "Maestro/agregar";
		}
		maestroS.insert(m);
		model.addAttribute("titulo",titulo3);
		model.addAttribute("advertencia","Maestro agregado con exito");
		model.addAttribute("maestro",new Maestro());
		return "Maestro/agregar";
		
	}
	
	@PostMapping(path= "actualizar")
	public String update(@Valid Maestro m,BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo",titulo4);
			return "Maestro/editar";
		}
		maestroS.update(m);
		model.addAttribute("titulo",titulo4);
		model.addAttribute("advertencia","Actualizacion con exito");
		model.addAttribute("maestros",maestroS.find(m.getId()));
		return "Maestro/editar";
		
	}
	
	@PostMapping(path= "buscarId")
	public String buscarId(Integer id,Model model) {
		if( id == null ||id < 0) {
			model.addAttribute("titulo","Ingresaste algo mal");
			model.addAttribute("maestro", new Maestro());
			return "Maestro/busquedaNum";
		}
		model.addAttribute("titulo",titulo);
		model.addAttribute("maestros",maestroS.find(id));
		return "Maestro/maestroResultadoBusqueda";
		
	}
	
	@PostMapping(path= "buscarNombre")
	public String buscarNombre(String nombre,Model model) {
		
		if( nombre == "" || nombre == null) {
			model.addAttribute("titulo","Ingresaste algo mal");
			model.addAttribute("maestro", new Maestro());
			return "Maestro/busquedaNom";
		}
		model.addAttribute("titulo",titulo2);
		model.addAttribute("maestros",maestroS.findName(nombre));
		return "Maestro/maestroResultadoBusqueda";
		
	}
	
	@PostMapping(path= "buscarSalario")
	public String buscarSalarios(float salario1,float salario2,Model model) {
		
		if( salario1 < 0 ||salario2 < 0 ) {
			model.addAttribute("titulo","Ingresa bien los datos");
			model.addAttribute("maestro", new Maestro());
			return "Maestro/busquedaSal";
		}
		model.addAttribute("titulo",titulo5);
		model.addAttribute("maestros",maestroS.findSalarios(salario1, salario2));
		return "Maestro/maestroResultadoBusqueda";
		
	}
}
