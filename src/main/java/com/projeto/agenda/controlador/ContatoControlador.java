package com.projeto.agenda.controlador;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.agenda.dto.ContatoDTO;
import com.projeto.agenda.modelo.Contato;
import com.projeto.agenda.servico.ContatoServico;

@RestController
@RequestMapping("/crudagenda")
public class ContatoControlador {

	@Autowired
	private ContatoServico contatoServico;

	@PostMapping("/salvar")
	public ResponseEntity<Contato> salvar(@RequestBody ContatoDTO contatoDTO) {
		Contato contato = new Contato();
		if (contatoServico.verificaContato(contato.getEmail())) {
			for (int i = 0; i < contatoDTO.getTelefones().size(); i++) {
				contatoDTO.getTelefones().get(i).setContato(contato);
			}
			BeanUtils.copyProperties(contatoDTO, contato);
			contatoServico.salvarContato(contato);
			return ResponseEntity.status(201).build();
		}
		return ResponseEntity.status(422).build();
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Contato> atualizar(@RequestBody Contato contato) {
		if (contatoServico.verificaContato(contato.getEmail())) {
			for (int i = 0; i < contato.getTelefones().size(); i++) {
				contato.getTelefones().get(i).setContato(contato);
			}
			contatoServico.atualizarContato(contato);
			return ResponseEntity.status(200).build();
		}
		return ResponseEntity.status(422).build();
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Contato> deletar(@PathVariable Long id) {
		contatoServico.deletarContato(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/contatos")
	public ResponseEntity<List<Contato>> exibirTodos() {
		if (contatoServico.exibirTodos() != null) //Se a lista NÃO for vazia retorna a mesma.
		return ResponseEntity.status(200).body(contatoServico.exibirTodos());
		return ResponseEntity.status(204).build();
	}
	
	//Busca contatos por nome
	@GetMapping("/buscaPorNome/{nome}")
	public ResponseEntity<List<Contato>> buscaPorNome(@PathVariable String nome){
		if (!contatoServico.buscaPorNome(nome).isEmpty())
		return ResponseEntity.status(200).body(contatoServico.buscaPorNome(nome));
		return ResponseEntity.status(204).build();
	}
	
	
	@GetMapping("/buscaPorEmail/{email}")
	public ResponseEntity<Contato> buscaPorEmail(@PathVariable String email){
		if(contatoServico.buscaPorEmail(email) != null) return ResponseEntity.status(200).body(contatoServico.buscaPorEmail(email));
		return ResponseEntity.status(204).build();
	}

}
