package com.estilise.estilise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estilise.estilise.model.modelCategoria;

@Repository
public interface CategoriaRepository extends JpaRepository<modelCategoria, Long> {

	public List<modelCategoria> findAllByIdcategoria (Long idcategoria);
}
