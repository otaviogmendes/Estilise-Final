package com.estilise.estilise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estilise.estilise.model.modelContato;


@Repository
public interface ContatoRepository extends JpaRepository<modelContato, Long> {
	
}
