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
import org.springframework.web.server.ResponseStatusException;

import com.estilise.estilise.model.modelCategoria;
import com.estilise.estilise.model.modelProduto;
import com.estilise.estilise.model.modelUsuario;
import com.estilise.estilise.repository.CategoriaRepository;
import com.estilise.estilise.repository.ProdutoRepository;
import com.estilise.estilise.repository.UsuarioRepository;
import com.estilise.estilise.rest.DTO.ProdutoDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProdutoController {
	
	
	private final UsuarioRepository usuarioRepository;
	private final CategoriaRepository categoriaRepository;
	
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping("/produtoTeste")
	public modelProduto salvar(@RequestBody ProdutoDTO dto) {
		Long idusuario = dto.getIdusuario();
		Long idcategoria = dto.getIdcategoria();
		
		modelUsuario usuario = 
				usuarioRepository.findById(idusuario).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario Inexistente."));
		modelCategoria categoria = 
				categoriaRepository.findById(idcategoria).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria Inexistente."));
		
		modelProduto produto = new modelProduto();
		produto.setIdusuarios(usuario);
		produto.setIdcategorias(categoria);
		produto.setIdproduto(dto.getIdproduto());
		produto.setCor(dto.getCor());
		produto.setData(dto.getData());
		produto.setDescricao(dto.getDescricao());
		produto.setImagem1(dto.getImagem1());
		produto.setImagem2(dto.getImagem2());
		produto.setImagem3(dto.getImagem3());
		produto.setKeytag(dto.getKeytag());
		produto.setMaterial(dto.getMaterial());
		produto.setNomeProduto(dto.getNomeProduto());
		produto.setPreco(dto.getPreco());
		produto.setQtdestoque(dto.getQtdestoque());
		produto.setTamanho(dto.getTamanho());
		
		return produtoRepository.save(produto);
	}
	
	
	@GetMapping
	public ResponseEntity<List<modelProduto>>GetAllProduto(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<modelProduto>GetById(@PathVariable long id){
		return repository.findById(id).map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeProduto/{nomeProduto}")
	public ResponseEntity<List<modelProduto>>GetByNomeProduto(@PathVariable String nomeProduto){
		return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
	}
	
	@PostMapping
	public ResponseEntity<modelProduto> PostProduto(@RequestBody modelProduto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<modelProduto> PutProduto(@RequestBody modelProduto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		repository.deleteById(id);
	}
}
