package com.api.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank(message = "nombre is required")
	@Size(max = 100)
	private String nombre;
	
	@Size(max = 100)
	private String primerApellido;
	
	@Size(max = 100)
	private String segundoApellido;

	@Size(max = 3)
	private Integer edad;
	
	@Size(min = 9, max = 11)
	private String telefono;

}
