package com.projeto.agenda.servico;

import com.projeto.agenda.modelo.Contato;
import com.projeto.agenda.repositorio.ContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoServico {

    @Autowired
    private ContatoRepositorio contatoRepositorio;


    //Salva um contato na Agenda
    public Contato salvarContato(Contato contato){
        return contatoRepositorio.save(contato);
    }
    //Atualia os dados do Contato na Agenda
    public Contato atualizarContato(Contato contato){
        return contatoRepositorio.save(contato);
    }
    //Deleta um Contato da Agenda
    public void deletarContato(Long id){
        contatoRepositorio.deleteById(id);
    }
    public List<Contato> exibirTodos(){
        return contatoRepositorio.findAll();
    }
}
