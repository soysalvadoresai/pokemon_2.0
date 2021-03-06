package com.pokemon.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pokemon")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "nombre_pokemon")
	private String name;
	
	
	@Column(name = "tipo_pokemon")
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Override
	public int hashCode() {
		return Objects.hash(name, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(name, other.name) && Objects.equals(usuario, other.usuario);
	}
	

}
