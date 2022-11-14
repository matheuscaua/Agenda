package com.projeto.agenda.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.agenda.modelo.Contato;
import com.projeto.agenda.repositorio.ContatoRepositorio;

@Service
public class ContatoServico {

    @Autowired
    private ContatoRepositorio contatoRepositorio;


    //Salva um contato na Agenda
    public void salvarContato(Contato contato){
    	if(verificaContato(contato.getEmail())) contatoRepositorio.save(contato);
    }
    //Atualia os dados do Contato na Agenda
    public Contato atualizarContato(Contato contato){
        return contatoRepositorio.save(contato);
    }
    //Deleta um Contato da Agenda
    public void deletarContato(Long id){
        contatoRepositorio.deleteById(id);
    }
    //Exibe a lista de Contatos
    public List<Contato> exibirTodos(){
    	if(verificaLista(contatoRepositorio.findAll()));
    	return contatoRepositorio.findAll();
    }
    
    public List<Contato> buscaPorNome(String nome){
    	if(verificaLista(contatoRepositorio.buscarNome(nome)));
    	return contatoRepositorio.buscarNome(nome);
    }
    
    //Busca um contato pelo email
    public Contato buscaContato(String email) {
    	 return contatoRepositorio.findByEmail(email)
    			 .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT));
    }
   
    //Verificações
    public boolean verificaLista(List<Contato> contatos) {
    	return contatos.isEmpty();
    }
    public boolean verificaContato(String email) {
    	if(buscaContato(email) == null) return true;
    	return false;
    }
}
