package com.estilise.estilise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estilise.estilise.model.modelUsuario;

@Repository
public interface UsuarioRepository extends JpaRepository<modelUsuario, Long> {
	public List<modelUsuario> findAllByEmailusuario(String emailusuario);
	public List<modelUsuario> findAllByIdusuario (Long idusuario);
	
	public Optional<modelUsuario> findByEmailusuario(String emailusuario);
	public List<modelUsuario> findAllByProfissional(boolean profissional);

}
