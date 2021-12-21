package com.web.app.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.app.entitys.Maestro;

@Repository
public class MaestroDaoImpl implements MaestroDAO {

	@Autowired
	private EntityManager em;
	@Override
	@Transactional
	public void insert(Maestro m) {
		em.persist(m);
		
	}

	@Override
	@Transactional
	public Maestro find(Integer id) {
		
		return em.find(Maestro.class,id);
	}
	
	@Override
	@Transactional
	public List<Maestro> findName(String nombre) {
		
		@SuppressWarnings("unchecked")
		List<Maestro> resultado = em.createQuery("SELECT m FROM Maestro m WHERE m.nombre=:nombre")
				.setParameter("nombre", nombre)
				.getResultList();
		return  resultado;
	}

	@Override
	@Transactional
	public List<Maestro> findSalarios(float salario1, float salario2) {
		
		if(salario1 != 0 && salario2 != 0) {
			@SuppressWarnings("unchecked")
			List<Maestro> resultado = em.createQuery("SELECT m FROM Maestro m WHERE m.salario>=:salario1 AND m.salario<=:salario2")
					                    .setParameter("salario1", salario1).setParameter("salario2",salario2).getResultList();
			return resultado;
		}
		else {
			@SuppressWarnings("unchecked")
			List<Maestro> resultado = em.createQuery("SELECT m FROM Maestro m WHERE m.salario>=:salario1")
                    .setParameter("salario1", salario1).getResultList();
			return resultado;
		}
	}

	@Override
	public List<Maestro> findAll() {
		
		return em.createQuery("from Maestro",Maestro.class).getResultList();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Maestro eliminar = find(id);
		em.remove(eliminar);
	   
	}

	@Override
	public void update(Maestro m) {
		
		Maestro cambio = find(m.getId());
		cambio.setNombre(m.getNombre());
		cambio.setEdad(m.getEdad());
		cambio.setSalario(m.getSalario());
		
	}

}
