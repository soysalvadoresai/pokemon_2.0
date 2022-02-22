package com.pokemon.request;



import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
	
	@NotNull
	@NotEmpty
	@JsonProperty("nombre_team")
	private String nombreTeam;
	
	@NotNull
	@NotEmpty
	@JsonProperty("nombre_entrenador")
	private String nombreEntrenador;
	
	@NotNull
	@NotEmpty
	private String rol;
	
	@NotNull
	@NotEmpty
	private String usuario;
	
	@NotNull
	@NotEmpty
	private String password;
	
	@NotNull
	@NotEmpty
	@UniqueElements
	private List<CreatePokemonRequest> pokemon;
		

}
