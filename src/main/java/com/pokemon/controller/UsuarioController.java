package com.pokemon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.pokemon.entity.Usuario;
import com.pokemon.reponse.UsuarioResponse;
import com.pokemon.request.CreateUserRequest;
import com.pokemon.request.UpdateUserRequest;
import com.pokemon.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/pokemon/")
@Api(value="API REST Pokemons")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@PostMapping("create")
	@ApiOperation(value="Register the user on Data Base")
	public UsuarioResponse createUser (@Valid @RequestBody CreateUserRequest createUserRequest) {
		Usuario usuario = usuarioService.createUsuario(createUserRequest);
		return new UsuarioResponse(usuario);
	}
	
	@PutMapping("update")
	public UsuarioResponse updateUser (@Valid @RequestBody UpdateUserRequest updateUserRequest) {
		Usuario usuario = usuarioService.updateUser(updateUserRequest);
		return new UsuarioResponse(usuario);
	}

}
