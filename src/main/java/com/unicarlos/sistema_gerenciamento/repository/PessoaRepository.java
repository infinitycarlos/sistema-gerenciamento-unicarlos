package com.unicarlos.sistema_gerenciamento.repository;

import com.unicarlos.sistema_gerenciamento.model.Pessoa;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID>{
}