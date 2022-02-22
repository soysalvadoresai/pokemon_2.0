package com.pokemon.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePokemonRequest {

	@JsonProperty("nombre_pokemon")
	private String nombre_pokemon;
	@JsonProperty("tipo_pokemon")
	private String tipo_pokemon;
	
}
