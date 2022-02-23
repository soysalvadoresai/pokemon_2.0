package com.pokemon.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pokemon.entity.Pokemon;
import com.pokemon.entity.Usuario;
import com.pokemon.error.NoUniqueNamesException;
import com.pokemon.repository.PokemonRepository;
import com.pokemon.repository.UsuarioRepository;
import com.pokemon.request.CreatePokemonRequest;
import com.pokemon.request.CreateUserRequest;
import com.pokemon.request.UpdateUserRequest;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	public Usuario createUsuario (CreateUserRequest createUserRequest) {
		Usuario usuario = new Usuario(createUserRequest);
		
		
		if(usuarioRepository.findByTeamNameOrTraineerNameOrUsername(usuario.getTeamName(), usuario.getTraineerName(), usuario.getUsername()) != null) {
			throw new NoUniqueNamesException("Username, team name, and traineer name is already taken. ");
		}
			usuario = usuarioRepository.save(usuario);
			
			List<Pokemon> pokemonList = new ArrayList<Pokemon>();
			
			
			if(createUserRequest.getPokemon() != null) {
				for (CreatePokemonRequest createPokemonRequest : 
					createUserRequest.getPokemon()) {
					Pokemon pokemon = new Pokemon();
					pokemon.setName(createPokemonRequest.getNombre_pokemon());
					pokemon.setType(createPokemonRequest.getTipo_pokemon());
					pokemon.setUsuario(usuario);
					
					pokemonList.add(pokemon);
				}
				
				pokemonRepository.saveAll(pokemonList);
				
			}
			
			usuario.setPokemones(pokemonList);
		
		
		return usuario;
	}
	
	
	
	public List<Pokemon> getAllPokemonsByUser(long id){
		return pokemonRepository.findByUsuarioId(id);
	}
		
		
	public String deletePokemon(long id) {
		pokemonRepository.deleteById(id);
		return "Pokemon deleted succesfully";
		
	}
	
	public Usuario updateData(UpdateUserRequest updateUser) {
		
		Usuario user = usuarioRepository.findByUsername(updateUser.getUsername());
		user.setTraineerName(updateUser.getTraineerName());
		user.setTeamName(updateUser.getTeamName());
		user.setRole(updateUser.getRole());
		user.setPassword(updateUser.getPassword());
		user = usuarioRepository.save(user);
		
		
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		
		
		if(updateUser.getPokemon() != null) {
			for (CreatePokemonRequest createPokemonRequest : 
				updateUser.getPokemon()) {
				Pokemon pokemon = new Pokemon();
				pokemon.setName(createPokemonRequest.getNombre_pokemon());
				pokemon.setType(createPokemonRequest.getTipo_pokemon());
				pokemon.setUsuario(user);
				
				if(pokemonRepository.findByName(pokemon.getName()) != null) {
					throw new NoUniqueNamesException("Pokemon already exist");
				}
				
				pokemonList.add(pokemon);
			}
			
			pokemonRepository.saveAll(pokemonList);
			
		}
		
		user.setPokemones(pokemonList);
		
		return user;
	}
	
	
	
	public Usuario getUserbyId(long id) {
		System.out.println(id);
		return usuarioRepository.getById(id);
	}

}
