package com.pokemon.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pokemon.entity.Usuario;
import com.pokemon.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private UsuarioRepository userRepository;

    public CustomUserDetailsService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
       Usuario user = userRepository.findByUsuario(usuario)
               .orElseThrow(() ->
                       new UsernameNotFoundException("User not found with username or email:" + usuario));
        return new org.springframework.security.core.userdetails.User(user.getUsuario(),
                user.getPassword(), mapRolesToAuthorities(new HashSet<String>(Arrays.asList("ROLE_ADMIN"))));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<String> roles){
    	return roles.stream().map(role -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
    }
}