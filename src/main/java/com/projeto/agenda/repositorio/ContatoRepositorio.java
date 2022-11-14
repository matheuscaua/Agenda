package com.projeto.agenda.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.agenda.modelo.Contato;


@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long>{
	
	Contato getByEmail(String email);
	
	@Query(value = "SELECT * FROM contato WHERE nome LIKE %?1%", nativeQuery = true)
	List<Contato> buscarNome(String nome);
	
	
}
