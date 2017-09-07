package br.com.vortice.web.api.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vortice.web.api.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByEmail(String email);
}
