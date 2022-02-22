package com.pokemon.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
	
	@NotNull(message = "Student Id is required")
	private Long id;
	
	private String nombreTeam;
	
	private String nombreEntrenador;
	
	private String usuario;
	
	private List<CreatePokemonRequest> pokemon;
	

}
