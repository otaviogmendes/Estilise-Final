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

import com.estilise.estilise.model.ModelCompra;
import com.estilise.estilise.repository.CompraRepository;

@RestController
@RequestMapping("/compra")
@CrossOrigin("*")
public class CompraController {
	
	@Autowired
	private CompraRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ModelCompra>>GetAllCompra(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModelCompra>GetById(@PathVariable long id){
		return repository.findById(id).map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ModelCompra> PostCompra(@RequestBody ModelCompra compra){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(compra));
	}
	
	@PutMapping
	public ResponseEntity<ModelCompra> PutCompra(@RequestBody ModelCompra compra){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(compra));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompra(@PathVariable long id) {
		repository.deleteById(id);
	}
}
