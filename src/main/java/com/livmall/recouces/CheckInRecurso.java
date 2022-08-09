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

import com.livmall.entities.CheckIn;
import com.livmall.services.CheckInServico;

@RestController
@RequestMapping(value = "/checkin")
public class CheckInRecurso {
	
	@Autowired
	private CheckInServico servico;
	
	
	@GetMapping
public ResponseEntity<List<CheckIn>> encontreTudo(){
		
		List<CheckIn> list = servico.encontreTudo();
		return ResponseEntity.ok().body(list);
		
		
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CheckIn> encontrePeloId(@PathVariable Long id){
		CheckIn obj = servico.encontrePeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<CheckIn> inserir(@RequestBody CheckIn obj){
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
	public ResponseEntity<CheckIn> atualizar(@PathVariable Long id, @RequestBody CheckIn obj){
		obj = servico.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
