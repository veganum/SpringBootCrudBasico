package com.api.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.Persona;
import com.api.crud.repository.Repository;

@RestController
@RequestMapping("/personas")
public class Controller {

	@Autowired
	private Repository repo;

	@GetMapping("conexion")
	public String index() {
		return "CONECTADO";
	}

	@GetMapping()
	public List<Persona> getPersonas() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Persona> getPersonaById(@PathVariable long id) {
		Optional<Persona> getPersonaById = repo.findById(id);
		return getPersonaById;
	}

	@PostMapping("grabar")
	public String post(@RequestBody Persona persona) {
		repo.save(persona);
		return "Grabado";
	}

	@PutMapping("editar/{id}")
	public String update(@PathVariable Long id, @RequestBody Persona persona) {
		Persona updatePersona = repo.findById(id).get();
		updatePersona.setNombre(persona.getNombre());
		updatePersona.setPrimerApellido(persona.getPrimerApellido());
		updatePersona.setSegundoApellido(persona.getSegundoApellido());
		updatePersona.setEdad(persona.getEdad());
		updatePersona.setTelefono(persona.getTelefono());
		repo.save(updatePersona);
		return "Editado";
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		Persona deletePersona = repo.findById(id).get();
		repo.delete(deletePersona);
		return "Eliminado";
	}

}
