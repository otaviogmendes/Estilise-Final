package com.estilise.estilise.rest.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaDTO {
	
	private Long idcategoria;
	private String nomecategoria;
	private String descricao;
	private String imagemcategoria;

}
