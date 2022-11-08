package com.projeto.agenda.controlador;


import com.projeto.agenda.modelo.Contato;
import com.projeto.agenda.servico.ContatoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.status(200).build();
    }

}
