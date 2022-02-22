package com.pokemon.request;



import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
	
	private String nombre_team;
	private String nombre_entrenador;
	private String rol;
	private String usuario;
	private String password;
	
	
 
	
	private List<CreatePokemonRequest> pokemon;
		

}
