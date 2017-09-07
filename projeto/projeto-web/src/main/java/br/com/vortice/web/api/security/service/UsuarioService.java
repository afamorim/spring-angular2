package br.com.vortice.web.api.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vortice.web.api.security.model.Usuario;
import br.com.vortice.web.api.security.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository	usuarioRepository;
	
	public Optional<Usuario> findByEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
}
