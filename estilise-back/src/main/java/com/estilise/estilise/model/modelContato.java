package com.estilise.estilise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="contato")
public class modelContato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_contato;
	
	@NotNull
	private String nome_contato;
	
	@NotNull
	private String email_contato;
	
	@NotNull
	private String telefone_contato;
	
	@NotNull
	private String assunto;
	
	@NotNull
	private String comentario;

	public long getId_contato() {
		return id_contato;
	}

	public void setId_contato(long id_contato) {
		this.id_contato = id_contato;
	}

	public String getNome_contato() {
		return nome_contato;
	}

	public void setNome_contato(String nome_contato) {
		this.nome_contato = nome_contato;
	}

	public String getEmail_contato() {
		return email_contato;
	}

	public void setEmail_contato(String email_contato) {
		this.email_contato = email_contato;
	}

	public String getTelefone_contato() {
		return telefone_contato;
	}

	public void setTelefone_contato(String telefone_contato) {
		this.telefone_contato = telefone_contato;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
