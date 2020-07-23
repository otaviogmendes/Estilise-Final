package com.estilise.estilise.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class modelLoginUsuario {

	private long idusuario;
	private String emailusuario;
	private String cpfusuario;
	private String senha;
	private String nome;
	private String cep;
	private String telefone;
	private int numerocasa;
	private String complemento;
	private String cartaocredito;
	private String imagemusuario;
	private String especialidade;
	private Date datanascimento;
	private String profissional;
	
	private String token;

}
