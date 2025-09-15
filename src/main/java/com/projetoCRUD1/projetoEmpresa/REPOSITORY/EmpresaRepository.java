package com.projetoCRUD1.projetoEmpresa.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoCRUD1.projetoEmpresa.ENTITY.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

    List<Empresa> findByNome_empresaContainingIgnoreCase(String nome_empresa);

}
