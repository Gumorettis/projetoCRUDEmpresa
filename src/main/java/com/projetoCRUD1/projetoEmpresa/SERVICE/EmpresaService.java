package com.projetoCRUD1.projetoEmpresa.SERVICE;

import java.util.List;
import java.util.Optional;

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

    public void deletarEmpresa(Long id){
        empresaRepository.deleteById(id);
    }

    //realizar a busca de dados no banco usando
    //o id criado da classe
    public Optional<Empresa> buscaPorId(Long id){
        return empresaRepository.findById(id);
    }

    public Empresa editarDadoEmpresa(Long id, Empresa dadosAtualizados){
        
        Empresa empresaBuscada = buscaPorId(id).orElseThrow(
        () -> new IllegalArgumentException("Empresa não encontrada"));

        empresaBuscada.setNome(dadosAtualizados.getNome());
        empresaBuscada.setCnpj(dadosAtualizados.getCnpj());
        empresaBuscada.setRamo(dadosAtualizados.getRamo());

        return empresaRepository.save(empresaBuscada);
    }

    public List<Empresa> buscarEmpresaPorNome(String nome_empresa){
        return empresaRepository.findByNomeContainingIgnoreCase(nome_empresa);
    }

}
