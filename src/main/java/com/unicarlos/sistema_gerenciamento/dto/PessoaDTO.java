package com.unicarlos.sistema_gerenciamento.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PessoaDTO {
    private UUID id;
    private String nome;
    private String cpf;
    private int idade;

    public PessoaDTO(UUID id, String nome, String cpf, int idade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
}