package com.web.app.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.web.app.validations.MayorDeEdad;

@Entity
@Table(name = "Maestros")
public class Maestro {

	@Id
	@NotNull
	private Integer id;
	@NotEmpty
	private String nombre;
	@NotNull
	@MayorDeEdad
	private Integer edad;
	@NotNull
	private float salario;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
}
