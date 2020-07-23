package com.estilise.estilise.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="compra")
@Data
public class ModelCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCompra;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_compra= new java.sql.Date(System.currentTimeMillis());
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private modelUsuario usuario;

	@OneToOne
	@JoinColumn(name="id_produto")
	private modelProduto produto;
}


