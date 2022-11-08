package com.projeto.agenda.controlador;


import com.projeto.agenda.modelo.Contato;
import com.projeto.agenda.servico.ContatoServico;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crudagenda")
public class ContatoControlador {

    @Autowired
    private ContatoServico contatoServico;


    @PostMapping("/salvar")
    public ResponseEntity<Contato> salvar(@RequestBody Contato contato){
        for(int i = 0; i < contato.getTelefones().size(); i++) {
            contato.getTelefones().get(i).setContato(contato);
        }
        contatoServico.salvarContato(contato);
        return ResponseEntity.status(201).build();
    }


    @PutMapping("/atualizar")
    public ResponseEntity<Contato> atualizar(@RequestBody  Contato contato){
        for(int i = 0; i < contato.getTelefones().size(); i++) {
            contato.getTelefones().get(i).setContato(contato);
        }
        contatoServico.atualizarContato(contato);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Contato> deletar(@PathVariable Long id){
        contatoServico.deletarContato(id);
        return ResponseEntity.ok().build();
    }
}
