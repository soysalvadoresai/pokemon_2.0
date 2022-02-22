package com.pokemon.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pokemon.request.CreateUserRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre_team", unique = true)
	private String nombreTeam;
	
	@Column(name = "nombre_entrenador" , unique = true)
	private String nombreEntrenador;
	
	@Column(name = "rol")
	private String rol;
	
	@Column(name = "usuario" , unique = true)
	private String usuario;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pokemon> tipoPokemon;
	
	public Usuario (CreateUserRequest createUserRequest) {
		this.nombreTeam = createUserRequest.getNombreTeam();
		this.nombreEntrenador = createUserRequest.getNombreEntrenador();
		this.rol = createUserRequest.getRol();
		this.usuario = createUserRequest.getUsuario();
		this.password = createUserRequest.getPassword();
		
		
	}

}
