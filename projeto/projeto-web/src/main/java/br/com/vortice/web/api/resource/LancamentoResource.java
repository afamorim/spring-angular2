package br.com.vortice.web.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vortice.web.api.event.RecursoCriadoEvent;
import br.com.vortice.web.api.model.Lancamento;
import br.com.vortice.web.api.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService	lancamentoService;
	
	@Autowired
	private ApplicationEventPublisher	publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ESPECIE_CONSULTAR')")
	public List<Lancamento> listar(){
		return lancamentoService.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_ESPECIE_CADASTRAR')")
	public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento especie, HttpServletResponse response) {
		especie = lancamentoService.insert(especie);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, especie.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(especie);
	}
	
	@GetMapping("/{codigo}")
	public Lancamento buscarPeloCodigo(@PathVariable Long codigo) {
		return lancamentoService.findByPrimaryKey(new Lancamento(codigo));
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		Lancamento lancamento = new Lancamento(codigo);
		lancamentoService.delete(lancamento);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Lancamento> atualizar(@PathVariable Long codigo, @Valid @RequestBody Lancamento lancamento){
		lancamento.setCodigo(codigo);
		Lancamento especieSalva = lancamentoService.update(lancamento);
		
		return ResponseEntity.ok(especieSalva);
	}
	
}
