package com.pokemon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemon.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);
    Boolean existsByUsuario(String usuario);
	Usuario findByNombreTeamOrNombreEntrenadorOrUsuario(String nombreTeam, String nombreEntrenador, String usuario);
}
