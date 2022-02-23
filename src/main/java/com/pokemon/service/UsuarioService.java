package com.pokemon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.pokemon.entity.Pokemon;
import com.pokemon.entity.Usuario;
import com.pokemon.error.NoUniqueNamesException;
import com.pokemon.repository.PokemonRepository;
import com.pokemon.repository.UsuarioRepository;
import com.pokemon.request.CreatePokemonRequest;
import com.pokemon.request.CreateUserRequest;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	PasswordEncoder passwordEncoder;
	
	public Usuario createUsuario (CreateUserRequest createUserRequest) {
		
		Usuario usuario = new Usuario(createUserRequest);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
		if(usuarioRepository.findByNombreTeamOrNombreEntrenadorOrUsuario(usuario.getNombreTeam(), usuario.getNombreEntrenador(), usuario.getUsuario()) != null) {
			throw new NoUniqueNamesException("El  nombre de usuario, nombre del team y nombre entrenador deben ser unicos.");
		}
			usuario = usuarioRepository.save(usuario);
			
			List<Pokemon> pokemonList = new ArrayList<Pokemon>();
			
			
			if(createUserRequest.getPokemon() != null) {
				for (CreatePokemonRequest createPokemonRequest : 
					createUserRequest.getPokemon()) {
					Pokemon pokemon = new Pokemon();
					pokemon.setNombre_pokemon(createPokemonRequest.getNombre_pokemon());
					pokemon.setTipo_pokemon(createPokemonRequest.getTipo_pokemon());
					pokemon.setUsuario(usuario);
					
					pokemonList.add(pokemon);
				}
				
				pokemonRepository.saveAll(pokemonList);
				
			}
			
			usuario.setTipoPokemon(pokemonList);
		
		
		return usuario;
	}
	
	public List<Pokemon> getAllPokemonsByUser(long id){
		return pokemonRepository.findByUsuarioId(id);
	}

}
