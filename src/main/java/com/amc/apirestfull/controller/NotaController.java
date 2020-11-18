package com.amc.apirestfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amc.apirestfull.entity.Nota;
import com.amc.apirestfull.model.MNota;
import com.amc.apirestfull.service.NotaService;

@RestController
@RequestMapping("/v1")
public class NotaController {
	
	@Autowired
	@Qualifier("servicio")
	NotaService service;
	
	@PutMapping("/nota")
	public boolean agregarNota(@RequestBody Nota nota) {
		return service.crear(nota);
	}
	
	@PostMapping("/nota")
	public boolean actualizarNota(@RequestBody Nota nota){
		return service.actualizar(nota);
	}
	
	@DeleteMapping("/nota/{id}/{nombre}")
	public boolean borrarNota(@PathVariable("id") Long id, @PathVariable("nombre") String nombre) {
		return service.borrar(nombre, id);
	}
	
	@GetMapping("/notas")
	public List<MNota> obtnerNotas(){
		return service.obtener();
	}
}
