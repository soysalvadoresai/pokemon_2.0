package com.pokemon.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pokemon.entity.Usuario;
import com.pokemon.repository.UsuarioRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	private UsuarioRepository usuarioRepository;
    public void CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		 Usuario usuario = usuarioRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
	               .orElseThrow(() ->
	                       new UsernameNotFoundException("User not found with username:" + usernameOrEmail));
	        return new org.springframework.security.core.userdetails.User(usuario.getUsuario(),
	                usuario.getPassword(), null);
	}

}
