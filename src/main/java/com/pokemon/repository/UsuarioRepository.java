package com.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemon.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByNombreTeamOrNombreEntrenador(String nombreTeam, String nombreEntrenador);
}
