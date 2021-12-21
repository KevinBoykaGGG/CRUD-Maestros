package com.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.app.entitys.Maestro;
import com.web.app.repositories.MaestroDAO;
@Component
public class MaestroServiceImpl implements IMaestroService {

	@Autowired
	private MaestroDAO maestroDAO;
	
	@Override
	public void insert(Maestro m) {
		maestroDAO.insert(m);
		
	}

	@Override
	public Maestro find(Integer id) {
		
		return maestroDAO.find(id);
	}

	@Override
	public List<Maestro> findAll() {
	
		return maestroDAO.findAll();
	}

	@Override
	public void delete(Integer id) {
		maestroDAO.delete(id);
		
	}

	@Override
	public void update(Maestro m) {
		maestroDAO.update(m);
		
	}

	@Override
	public List<Maestro> findName(String nombre) {
		
		return maestroDAO.findName(nombre);
	}

	@Override
	public List<Maestro> findSalarios(float salario1, float salario2) {
		
		return maestroDAO.findSalarios(salario1, salario2);
	}

}
