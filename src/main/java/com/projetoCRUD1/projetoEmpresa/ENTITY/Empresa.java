package com.projetoCRUD1.projetoEmpresa.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_empresa")
@NoArgsConstructor
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa", nullable = false, unique=true)
    private Long id_empresa;

    @Column(name = "nome", nullable = false, length=100)
    private String nome;

    @Column(name = "cnpj", nullable = false, length=20, unique=true)
    private int cnpj;

    @Column(name = "ramo", nullable = false, length=100)
    private String ramo;

    public Empresa(String nome, int cnpj, String ramo) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.ramo = ramo;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    

}
