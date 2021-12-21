package com.web.app.repositories;

import java.util.List;

import com.web.app.entitys.Maestro;

public interface MaestroDAO {
	
	void insert(Maestro m);
	Maestro find(Integer id);
	List<Maestro>findAll();
	void delete(Integer id);
	void update(Maestro m);
	List<Maestro> findName(String nombre);
	List<Maestro> findSalarios(float salario1, float salario2);
}
