package com.estilise.estilise.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estilise.estilise.model.modelCategoria;
import com.estilise.estilise.model.modelLoginUsuario;
import com.estilise.estilise.model.modelProduto;
import com.estilise.estilise.model.modelUsuario;
import com.estilise.estilise.repository.CategoriaRepository;
import com.estilise.estilise.repository.ProdutoRepository;
import com.estilise.estilise.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	@Autowired
	private CategoriaRepository categoriarepository;
	
	public modelUsuario CadastrarUsuario(modelUsuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}
	
	public modelProduto CadastrarProduto(modelProduto produto) {
		produto.setIdproduto(produto.getIdproduto());
		produto.setNomeProduto(produto.getNomeProduto());
		produto.setMaterial(produto.getMaterial());
		produto.setCor(produto.getCor());
		produto.setPreco(produto.getPreco());
		produto.setTamanho(produto.getTamanho());
		produto.setKeytag(produto.getKeytag());
		produto.setImagem1(produto.getImagem1());
		produto.setImagem2(produto.getImagem1());
		produto.setImagem3(produto.getImagem1());
		produto.setData(produto.getData());
		produto.setIdusuarios(produto.getIdusuarios());
		produto.setIdcategorias(produto.getIdcategorias());
		return produtorepository.save(produto);
	}
	
	public modelCategoria CadastrarCategoria(modelCategoria categoria) {
		categoria.setIdcategoria(categoria.getIdcategoria());
		categoria.setDescricao(categoria.getDescricao());
		categoria.setImagemcategoria(categoria.getImagemcategoria());
		categoria.setNomecategoria(categoria.getNomecategoria());
		return categoriarepository.save(categoria);
	}
	
	public Optional<modelLoginUsuario> Logar(Optional<modelLoginUsuario> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<modelUsuario> usuario = repository.findByEmailusuario(user.get().getEmailusuario());
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getEmailusuario()+ ":" +user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader ="Basic " + new String(encodedAuth);
				user.get().setToken(authHeader);
				user.get().setEmailusuario(usuario.get().getEmailusuario());
				user.get().setCpfusuario(usuario.get().getCpfusuario());
				user.get().setNome(usuario.get().getNome());
				user.get().setDatanascimento(usuario.get().getDatanascimento());
				user.get().setCep(usuario.get().getCep());
				user.get().setTelefone(usuario.get().getTelefone());
				user.get().setImagemusuario(usuario.get().getImagemusuario());
				user.get().setCartaocredito(usuario.get().getCartaocredito());
				user.get().setComplemento(usuario.get().getComplemento());
				user.get().setEspecialidade(usuario.get().getEspecialidade());
				user.get().setProfissional(usuario.get().getProfissional());
				user.get().setIdusuario(usuario.get().getIdusuario());
				return user;
			}
		}
		return null;
	}
}

//user.get().setEmailusuario(usuario.get().getEmailusuario());
//user.get().setNome(usuario.get().getNome());
//user.get().setCpf_usuario(usuario.get().getCpf_usuario());
//user.get().setData_nascimento(usuario.get().getData_nascimento());
//user.get().setCep(usuario.get().getCep());
//user.get().setTelefone(usuario.get().getTelefone());
//user.get().setImagem_usuario(usuario.get().getImagem_usuario());
//user.get().setCartao_credito(usuario.get().getCartao_credito());
//user.get().setId_usuario(usuario.get().getId_usuario());
//user.get().setComplemento(usuario.get().getComplemento());
