package com.pokemon.reponse;

import com.pokemon.entity.Pokemon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonResponse {
	
	private Long id;
	
	private String nombre_pokemon;
	
	private String tipo_pokemon;
	
	public PokemonResponse (Pokemon pokemon) {
		this.id = pokemon.getId();
		this.nombre_pokemon = pokemon.getNombre_pokemon();
		this.tipo_pokemon = pokemon.getTipo_pokemon();
	}

}
