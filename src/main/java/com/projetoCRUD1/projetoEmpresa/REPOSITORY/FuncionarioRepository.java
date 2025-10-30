package com.projetoCRUD1.projetoEmpresa.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoCRUD1.projetoEmpresa.ENTITY.Funcionario;

@Repository
public interface FuncionarioRepository extends
        JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNomeContainingIgnoreCase(String nome_funcionario);

}
