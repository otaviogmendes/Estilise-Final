package com.estilise.estilise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilise.estilise.model.modelContato;
import com.estilise.estilise.repository.ContatoRepository;

@RestController
@RequestMapping("/contatos")
@CrossOrigin("*")
public class ContatoController {

	@Autowired
	private ContatoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<modelContato>>GetAllContato(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<modelContato>GetById(@PathVariable long id){
		return repository.findById(id).map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<modelContato> PostContato(@RequestBody modelContato contato){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(contato));
	}
	
	@PutMapping
	public ResponseEntity<modelContato> PutContato(@RequestBody modelContato contato){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(contato));
	}
	
	@DeleteMapping("/{id}")
	public void deleteContato(@PathVariable long id) {
		repository.deleteById(id);
	}
}
