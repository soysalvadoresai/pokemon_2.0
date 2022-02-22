package com.pokemon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemon.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsernameOrEmail(String username,String email);
	Usuario findByNombreTeamOrNombreEntrenadorOrUsuario(String nombreTeam, String nombreEntrenador, String usuario);
}
