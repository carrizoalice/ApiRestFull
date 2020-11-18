package com.amc.apirestfull.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
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
	
	private static final Log logger = LogFactory.getLog(NotaService.class);
	
	public boolean crear(Nota nota) {
		logger.info("Creando la nota");
		try {
			repositorio.save(nota);
			logger.info("Nota creada");
			return true;
		}catch(Exception e) {
			logger.info("Hubo un error al crear la nota");
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		logger.info("Actualizando nota");
		try {
			repositorio.save(nota);
			logger.info("Nota actualizada");
			return true;
		}catch(Exception e) {
			logger.info("Hubo un error al actualizar la nota");
			return false;
		}
	}	
	
	public boolean borrar(String nombre, Long id) {
		logger.warn("ABorrando nota");
		try {
		Nota nota =	repositorio.findByNombreAndId(nombre, id);
		repositorio.delete(nota);
		logger.info("Nota borrada");
			return true;
		}catch(Exception e) {
			logger.info("Hubo un error al borrar la nota");
			return false;
		}
	}
	
	public List<MNota> obtener() {
		logger.info("Obteniendo todas las notas");
		List<MNota> notas = null;
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	
	public MNota obtenerPorNombreTitulo(String nombre, String titulo) {
		logger.info("Obteniendo notas por nombre y titulo");
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota> obtenerTitulo(String titulo){	
		logger.info("Obteniendo nota por titulo");
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
		
	}
	
	
}
