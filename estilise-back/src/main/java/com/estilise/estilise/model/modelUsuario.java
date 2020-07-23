package com.estilise.estilise.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class modelUsuario {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idusuario;

//	@NotNull
	private String nome;

//	@NotNull
//	@Size(min=5, max = 100)
	private String senha;
	
//	@NotNull
//	@Size(min=11,max=11)
	@Column(name="cpf_usuario", unique=true, length = 11)
	private String cpfusuario;
	
//	@NotNull
	@Email
	public String emailusuario;
	
//	@NotNull
	private String cep;
	
	private String telefone;
	private int numerocasa;
	private String complemento;
	private String descricaoUsuario;
	private String cartaocredito;
	private String imagemusuario;
	
	//------------------ profissional
	private String especialidade;
	private Date datanascimento;

	private String profissional;
	
}
	

	
