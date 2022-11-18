package com.projeto.agenda.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.projeto.agenda.modelo.Telefone;

import lombok.Data;


@Data
public class ContatoDTO {
    private String nome;
    private String sobrenome;
    private String email;
    
    private String endereco;
    
    @OneToMany(mappedBy = "contato", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<Telefone>();
}
