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
    //Exibe a lista de Contatos
    public List<Contato> exibirTodos(){
        return contatoRepositorio.findAll();
    }
    
    
    public Contato buscaPorNome(String nome){
    	Contato contato = contatoRepositorio.buscarNome(nome);
    	return contato;
    }
    
    
    //Busca um contato pelo email
    public Contato buscaContato(String email) {
    	Contato contato = contatoRepositorio.findByEmail(email);
    	return contato;
    }
   
    
    //Verificações
    public boolean verificaLista(List<Contato> contatos) {
    	if(contatos.isEmpty()) return false;
    	return true;
    }
    public boolean verificaContato(String email) {
    	if(buscaContato(email) == null) return true;
    	return false;
    }
}
