package com.projeto.agenda.repositorio;

import com.projeto.agenda.modelo.Contato;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long>{
	
	Contato findByEmail(String email);
	
	@Query(value = "SELECT * FROM contato WHERE nome = ?1", nativeQuery = true)
	Contato buscarNome(String nome);
	
}
