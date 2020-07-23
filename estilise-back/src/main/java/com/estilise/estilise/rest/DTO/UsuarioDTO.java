package com.estilise.estilise.rest.DTO;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {

	private long idusuario;

	private String nome;

	private String senha;

	private String cpfusuario;
	
	private String emailusuario;

	private String cep;
	
	private String telefone;
	
	private int numerocasa;
	
	private String complemento;
	
	private String cartaocredito;
	
	private String imagemusuario;
	
	private Long idCompra;
	
	//--------------- profissional
	private String especialidade;
	
	private Date datanascimento;
	
	private String profissional;

}
