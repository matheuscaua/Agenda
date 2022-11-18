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
    	if(verificaLista(contatoRepositorio.findAll())) return null;
    	
    	//contatoRepositorio.findAll().stream().forEach(objeto -> System.out.println(objeto.getEmail())); //Testes
    	//contatoRepositorio.findAll().stream().map(contato -> contato.getNome().toUpperCase()).forEach(System.out::println);
   
    	//contatoRepositorio.findAll().stream().filter(contato -> contato.getNome().contains("Ma")).toList();
    	//contatoRepositorio.findAll().stream().filter(contato -> contato.getNome().length() > 3).toList();
    	return contatoRepositorio.findAll();
    }
    //Busca um Contato(Entidade) pelo nome;
    public List<Contato> buscaPorNome(String nome){
    	if(verificaLista(contatoRepositorio.buscarPorNome(nome))) return contatoRepositorio.buscarPorNome(nome);
    	return null;
    }
    public Contato buscaPorEmail(String email){
    	return contatoRepositorio.buscarPorEmail(email);
    }
   
    //Verifica se a lista atribuída está vazia ou não
    public boolean verificaLista(List<Contato> contatos) {
    	return contatos.isEmpty();
    }
    //Verifica se existe um Contato com este email
    public boolean verificaContato(String email) {
    	if(buscaContato(email) == null) return true;
    	return false;
    }
    
    
    
    //Busca um contato pelo email
    public Contato buscaContato(String email) {
    	 return contatoRepositorio.getByEmail(email);
    }
   
}
