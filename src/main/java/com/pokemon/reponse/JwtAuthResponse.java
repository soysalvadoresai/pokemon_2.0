package com.pokemon.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {

	private String accesToken;
	private String tokenType = "Bearer";
	public JwtAuthResponse(String accesToken) {
		this.accesToken = accesToken;
	}
	
}
