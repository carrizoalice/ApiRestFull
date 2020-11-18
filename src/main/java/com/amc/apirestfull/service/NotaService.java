package com.amc.apirestfull.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.amc.apirestfull.converter.Convertidor;
import com.amc.apirestfull.entity.Nota;
import com.amc.apirestfull.model.MNota;
import com.amc.apirestfull.repository.NotaRepositorio;

@Service("servicio")
public class NotaService {
	@Autowired //inyectar
	@Qualifier("repositorio")
	private NotaRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	public boolean crear(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}	
	
	public boolean borrar(String nombre, Long id) {
		try {
		Nota nota =	repositorio.findByNombreAndId(nombre, id);
		repositorio.delete(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<MNota> obtener() {
		List<MNota> notas = null;
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	
	public MNota obtenerPorNombreTitulo(String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota> obtenerTitulo(String titulo){		
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
		
	}
	
	
}
