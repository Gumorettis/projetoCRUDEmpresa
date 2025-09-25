package com.projetoCRUD1.projetoEmpresa.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoCRUD1.projetoEmpresa.ENTITY.Empresa;
import com.projetoCRUD1.projetoEmpresa.SERVICE.EmpresaService;

@Controller
@RequestMapping("/empresaCTR")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService ligcaoEmpresaService) {
        this.empresaService = ligcaoEmpresaService;
    }

    @GetMapping("/viewCadEmpresa")
    public String mostrarFormCadastro(Model oModel) {
        oModel.addAttribute("empresa", new Empresa());
        return "cadastroEmpresa";
    }

}
