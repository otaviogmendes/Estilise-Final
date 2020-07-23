package com.estilise.estilise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estilise.estilise.model.ModelCompra;





@Repository
public interface CompraRepository extends JpaRepository<ModelCompra, Long> {
	
	public List<ModelCompra> findAllByIdCompra(Long idCompra);

}
