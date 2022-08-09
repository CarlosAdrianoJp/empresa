package com.livmall.recouces;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.livmall.entities.Encomenda;
import com.livmall.services.EncomendaServico;

@RestController
@RequestMapping(value = "/encomendas")
public class EncomendaRecurso {
	
	@Autowired
	private EncomendaServico servico;
	
	
	@GetMapping
public ResponseEntity<List<Encomenda>> encontreTudo(){
		
		List<Encomenda> list = servico.encontreTudo();
		return ResponseEntity.ok().body(list);
		
		
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Encomenda> encontrePeloId(@PathVariable Long id){
		Encomenda obj = servico.encontrePeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Encomenda> inserir(@RequestBody Encomenda obj){
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		servico.deletar(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Encomenda> atualizar(@PathVariable Long id, @RequestBody Encomenda obj){
		obj = servico.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
