package com.projetoCRUD1.projetoEmpresa.CONTROLLER;

import org.springframework.stereotype.Controller;

import com.projetoCRUD1.projetoEmpresa.SERVICE.EmpresaService;

@Controller
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService ligcaoEmpresaService) {
        this.empresaService = ligcaoEmpresaService;
    }

    
}
