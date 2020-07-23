package com.estilise.estilise.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="produto")
public class modelProduto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idproduto;
	
//	@NotNull
//	@Size(min=3,max=20)
	private String nomeProduto;
	
//	@NotNull
	private String material;
	
//	@NotNull
	private String cor;
	
//	@NotNull
	private float preco;
	
//	@NotNull
	private String tamanho;
	
//	@NotNull
	private String descricao;
	
//	@NotNull
	private String keytag;
	
//	@NotNull
	private String imagem1;
	
	private String imagem2;
	private String imagem3;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data= new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private modelUsuario idusuarios;
	
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private modelCategoria idcategorias;
	
	private int qtdestoque;
	
}
