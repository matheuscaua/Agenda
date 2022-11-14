package com.projeto.agenda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.agenda.modelo.Contato;


@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long>{
	
	Contato findByEmail(String email);
	
	@Query(value = "SELECT * FROM contato WHERE nome LIKE %?1%", nativeQuery = true)
	Contato buscarNome(String nome);
	
	
}
