package br.com.vortice.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vortice.web.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
