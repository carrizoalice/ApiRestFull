package com.amc.apirestfull.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "NOTA")
public class Nota implements Serializable{
	
	@GeneratedValue
	@Id
	@Column(name = "ID_NOTA")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "CONTENIDO")
	private String contenido;
	
	

	public Nota() {
	}

	public Nota(Long id, String nombre, String titulo, String contenido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
}
