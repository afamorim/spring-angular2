package br.com.vortice.web.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.vortice.web.api.security.model.Usuario;

public class UsuarioSistema extends User {

	
	private Usuario	usuario;
	
	public UsuarioSistema(Usuario aUsuario, Collection<? extends GrantedAuthority> authorities) {
		super(aUsuario.getEmail(), aUsuario.getSenha(), authorities);
		
		this.usuario = aUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}