package com.projeto.agenda.repositorio;

import com.projeto.agenda.modelo.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepositorio extends JpaRepository<Contato, Long> {
}
