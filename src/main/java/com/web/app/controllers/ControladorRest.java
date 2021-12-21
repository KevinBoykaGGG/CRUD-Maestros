package com.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.entitys.Maestro;
import com.web.app.services.IMaestroService;

@RestController
@RequestMapping("/restMaestro")
public class ControladorRest {
	
	@Autowired
	private IMaestroService maestroS;

	@GetMapping(path= {"", "/"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public List<Maestro> findAll(){
		return maestroS.findAll();
	}
	
	@GetMapping(path= {"/{id}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Maestro find(@PathVariable Integer id){
		return maestroS.find(id);
	}
	
	@GetMapping(path= {"/agregar/{id}/{nombre}/{edad}/{salario}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Maestro insert(@PathVariable Integer id,@PathVariable String nombre, @PathVariable Integer edad, @PathVariable float salario){
		
		Maestro m = new Maestro();
		m.setId(id);
		m.setNombre(nombre);
		m.setEdad(edad);
		m.setSalario(salario);
		maestroS.insert(m);
		return maestroS.find(id);
		
	}
	@GetMapping(path= {"/borrar/{id}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Boolean delete(@PathVariable Integer id){
		
	    maestroS.delete(id);
		return true;
		
	}
	
	@GetMapping(path= {"/editar/{id}/{nombre}/{edad}/{salario}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Maestro update(@PathVariable Integer id,@PathVariable String nombre, @PathVariable Integer edad, @PathVariable float salario){
		
		Maestro m = new Maestro();
		m.setId(id);
		m.setNombre(nombre);
		m.setEdad(edad);
		m.setSalario(salario);
		maestroS.update(m);
		return maestroS.find(id);
		
	}

}
