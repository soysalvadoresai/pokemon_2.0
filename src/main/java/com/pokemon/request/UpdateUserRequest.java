package com.pokemon.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateUserRequest {
	
	@NotBlank(message = "Team name is required")
	@JsonProperty("nombre_team")
	private String teamName;
	
	@NotBlank(message = "Traineer name is required")
	@JsonProperty("nombre_entrenador")
	private String traineerName;
	
	@NotBlank(message = "Role is required")
	@JsonProperty("rol")
	private String role;
	
	@NotBlank(message = "Username is required")
	@JsonProperty("usuario")
	private String username;
	
	@NotBlank(message = "Password is required")
	private String password;

	
}
