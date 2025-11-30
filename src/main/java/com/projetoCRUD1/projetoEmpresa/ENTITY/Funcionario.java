package com.projetoCRUD1.projetoEmpresa.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_funcionario")
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false, unique=true)
    private Long codigo;

    @Column(name = "nome", nullable = false, length=100)
    private String nome;

    @Column(name="salario", nullable = false, unique=true)
    private double salario;

    @Column(name="cargo", nullable = false, length=100)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "empresaID", nullable = false)
    private Empresa identificadorEmpresa;

    public Funcionario(Long codigo, String nome, double salario, String cargo, Empresa identificadorEmpresa) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
        this.identificadorEmpresa = identificadorEmpresa;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empresa getIdentificadorEmpresa() {
        return identificadorEmpresa;
    }

    public void setIdentificadorEmpresa(Empresa identificadorEmpresa) {
        this.identificadorEmpresa = identificadorEmpresa;
    }
}
