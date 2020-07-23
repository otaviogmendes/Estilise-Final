package com.estilise.estilise.controller;

import java.util.List;
import java.util.Optional;

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
//import org.springframework.web.server.ResponseStatusException;
//
//import com.estilise.estilise.model.ModelCompra;
import com.estilise.estilise.model.modelLoginUsuario;
import com.estilise.estilise.model.modelUsuario;
//import com.estilise.estilise.repository.CompraRepository;
import com.estilise.estilise.repository.UsuarioRepository;
import com.estilise.estilise.rest.DTO.UsuarioDTO;
import com.estilise.estilise.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UsuarioController {
	
//	private final CompraRepository compraRepository;
	
	private final UsuarioRepository repository;

//	@Autowired
//	private UsuarioRepository repository;
	
	@Autowired
    private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<modelUsuario>>GetAllUsuario(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<modelUsuario>GetById(@PathVariable long id){
		return repository.findById(id).map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/profissional/{profissional}")
	public ResponseEntity<List<modelUsuario>>GetAllProfissional(@PathVariable boolean profissional){
		return ResponseEntity.ok(repository.findAllByProfissional(profissional));	
	}
	
	@PostMapping("/dto")
	public modelUsuario salvar(@RequestBody UsuarioDTO dto) {
		Long idCompra = dto.getIdCompra();
//		ModelCompra compra = compraRepository.findById(idCompra).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Compra não existente."));
		modelUsuario usuario = new modelUsuario();
//		usuario.setCompra(compra);
//		usuario.setId_compra(compra);
		usuario.setIdusuario(dto.getIdusuario());
		usuario.setNome(dto.getNome());
		usuario.setSenha(dto.getSenha());
		usuario.setCpfusuario(dto.getCpfusuario());
		usuario.setEmailusuario(dto.getEmailusuario());
		usuario.setCep(dto.getCep());
		usuario.setTelefone(dto.getTelefone());
		usuario.setNumerocasa(dto.getNumerocasa());
		usuario.setComplemento(dto.getComplemento());
		usuario.setCartaocredito(dto.getCartaocredito());
		usuario.setImagemusuario(dto.getImagemusuario());
		usuario.setEspecialidade(dto.getEspecialidade());
		usuario.setDatanascimento(dto.getDatanascimento());
		usuario.setProfissional(dto.getProfissional());
		return repository.save(usuario);
	}
	
	@PostMapping("/logar")
    public ResponseEntity<modelLoginUsuario> Autenticacao(@RequestBody Optional<modelLoginUsuario> user){
          return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
	
	@PostMapping
	public ResponseEntity<modelUsuario> PostUsuario(@RequestBody modelUsuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
    @PostMapping("/cadastrar")
    public ResponseEntity<modelUsuario> Post(@RequestBody modelUsuario usuario){
          return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
    }
    
    @PutMapping
    public ResponseEntity<modelUsuario> PutUsuario(@RequestBody modelUsuario usuario){
    	return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
    }
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable long id) {
		repository.deleteById(id);
	}
}