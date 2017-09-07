package br.com.vortice.web.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.vortice.web.api.model.Lancamento;
import br.com.vortice.web.api.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository	lancamentoRepository;
	
	public Lancamento insert(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}
	
	public Lancamento update(Lancamento lancamento) {
		Lancamento especieSalva = lancamentoRepository.findOne(lancamento.getCodigo());
		if (especieSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(lancamento, especieSalva, "codigo");
		lancamentoRepository.save(lancamento);
		
		return lancamento;
	}
	
	public List<Lancamento> findAll(){
		return lancamentoRepository.findAll();
	}
	
	public Lancamento	findByPrimaryKey(Lancamento lancamento) {
		return lancamentoRepository.findOne(lancamento.getCodigo());
	}
	
	public void delete(Lancamento lancamento) {
		lancamentoRepository.delete(lancamento.getCodigo());
	}
}
