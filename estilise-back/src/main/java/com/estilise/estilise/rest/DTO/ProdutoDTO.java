package com.estilise.estilise.rest.DTO;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoDTO {
	
	private Long idproduto;
	private String nomeProduto;
	private String material;
	private String cor;
	private float preco;
	private String tamanho;
	private String descricao;
	private String keytag;
	private String imagem1;
	private String imagem2;
	private String imagem3;
	private Date data;
	private Long idusuario;
	private Long idcategoria;
	private int qtdestoque;

}
