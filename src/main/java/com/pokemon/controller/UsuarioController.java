package com.pokemon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.entity.Usuario;
import com.pokemon.reponse.UsuarioResponse;
import com.pokemon.request.CreateUserRequest;
import com.pokemon.service.UsuarioService;


@RestController
@RequestMapping("/pokemon/")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("create")
	public UsuarioResponse createUser (@Valid @RequestBody CreateUserRequest createUserRequest) {
		Usuario usuario = usuarioService.createUsuario(createUserRequest);
		return new UsuarioResponse(usuario);
	}

}
