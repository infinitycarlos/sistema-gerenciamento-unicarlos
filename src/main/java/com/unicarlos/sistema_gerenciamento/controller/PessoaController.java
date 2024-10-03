package com.unicarlos.sistema_gerenciamento.controller;

import com.unicarlos.sistema_gerenciamento.dto.PessoaDTO;
import com.unicarlos.sistema_gerenciamento.model.Pessoa;
import com.unicarlos.sistema_gerenciamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // POST /pessoas - Criar uma nova Pessoa
    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // GET /pessoas/{id} - Buscar Pessoa por ID usando DTO
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> buscarPessoaPorId(@PathVariable UUID id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(p -> ResponseEntity.ok(new PessoaDTO(p.getId(), p.getNome(), p.getCpf(), p.getIdade())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
