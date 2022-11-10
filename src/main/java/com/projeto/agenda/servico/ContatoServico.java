package com.projeto.agenda.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.agenda.modelo.Contato;
import com.projeto.agenda.repositorio.ContatoRepositorio;

@Service
public class ContatoServico {

    @Autowired
    private ContatoRepositorio contatoRepositorio;


    //Salva um contato na Agenda
    public void salvarContato(Contato contato){
    	
    	contatoRepositorio.save(contato); 

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
    
    public boolean buscaContato(String email) {
    	Contato contato = contatoRepositorio.findByEmail(email);
    	if(contato == null) return true;
    	return false;
    }
   
    public boolean verificaLista() {
    	if(exibirTodos().isEmpty()) return false;
    	return true;
    }
}
