package com.projetoCRUD1.projetoEmpresa.SERVICE;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetoCRUD1.projetoEmpresa.ENTITY.Empresa;
import com.projetoCRUD1.projetoEmpresa.REPOSITORY.EmpresaRepository;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository ligacaoEmpresaRepository) {
        empresaRepository = ligacaoEmpresaRepository;
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }//select * from empresa

    public Empresa cadastrarEmpresa(Empresa dadosEmpresa){
        return empresaRepository.save(dadosEmpresa);
    }

    public void deletarEmpresa(Empresa dadosEmpresa){
        empresaRepository.delete(dadosEmpresa);
    }

}
