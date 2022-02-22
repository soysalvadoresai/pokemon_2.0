package com.pokemon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.entity.Pokemon;
import com.pokemon.entity.Usuario;
import com.pokemon.reponse.PokemonResponse;
import com.pokemon.reponse.UsuarioResponse;
import com.pokemon.request.CreateUserRequest;
import com.pokemon.service.UsuarioService;


@RestController
@RequestMapping("/pokemon/")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("pokemons/{id}")
	public List<PokemonResponse> getAllPokemonsByUser(@PathVariable long id) {
		List<Pokemon> pokemonList = usuarioService.getAllPokemonsByUser(id);
		
		List<PokemonResponse> pokemonResponseList = new ArrayList<PokemonResponse>();
		
		pokemonList.stream().forEach(pokemon -> {
			pokemonResponseList.add(new PokemonResponse(pokemon));
		});
		
		return pokemonResponseList;
	}
	
	@PostMapping("create")
	public UsuarioResponse createUser (@Valid @RequestBody CreateUserRequest createUserRequest) {
		Usuario usuario = usuarioService.createUsuario(createUserRequest);
		return new UsuarioResponse(usuario);
	}

}
