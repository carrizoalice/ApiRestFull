package com.amc.apirestfull.repository;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amc.apirestfull.entity.Nota;

@Repository("repositorio")
public interface NotaRepositorio extends JpaRepository<Nota, Serializable>, PagingAndSortingRepository<Nota, Serializable>{
	public abstract Nota findByNombre(String nombre); //devuelveme el registro que tenga el nombre

	public abstract List<Nota> findByTitulo (String titulo);
	
	public abstract Nota findByNombreAndTitulo(String nombre, String titulo);
	
	public abstract Nota findByNombreAndId(String nombre, Long id);
	
	public abstract Page<Nota> findAll(Pageable pageable);
}


