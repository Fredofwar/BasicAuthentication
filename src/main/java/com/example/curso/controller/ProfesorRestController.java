package com.example.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entity.Profesor;
import com.example.curso.service.IProfesorService;

@RestController
public class ProfesorRestController {
	
	@Autowired
	private IProfesorService profesorService;
	
	@RequestMapping(value = "/todos_profesores_public", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listaAllProfesor(){
		List<Profesor> profesores = profesorService.findAllProfesores();
		if(profesores.isEmpty()) {
			return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/todos_profesores_admin", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listaAllProfesorAdmin(){
		List<Profesor> profesores = profesorService.findAllProfesores();
		if(profesores.isEmpty()) {
			return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
	}
	@RequestMapping(value = "/todos_profesores_user", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listaAllProfesorUser(){
		List<Profesor> profesores = profesorService.findAllProfesores();
		if(profesores.isEmpty()) {
			return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
	}
}
