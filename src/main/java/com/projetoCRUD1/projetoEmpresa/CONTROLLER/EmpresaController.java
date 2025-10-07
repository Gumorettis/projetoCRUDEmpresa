package com.projetoCRUD1.projetoEmpresa.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    //chamada para o listar todas as empresas
    @GetMapping("/listarTodasEmpresas")
    public String listarEmpresas(Model oModel) {
        oModel.addAttribute("empresas", empresaService.findAll());
        return "listarEmpresas";
    }

    @GetMapping("/viewCadEmpresa")
    public String mostrarFormCadastro(Model oModel) {
        oModel.addAttribute("empresa", new Empresa());
        return "cadastroEmpresa";
    }

    @PostMapping("/salvarEmpresa")
    public String salvarEmpresa(@ModelAttribute Empresa objEmpresa) {

        //chamando o método cadastrar e passando
        //o objeto("pacotinho") com os dados que precisam ser salvos
        empresaService.cadastrarEmpresa(objEmpresa);

        return "redirect:/empresaCTR/listarTodasEmpresas";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model oModel) {
        Empresa objEmpresa = empresaService.buscaPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));

        oModel.addAttribute("empresaEditar", objEmpresa);
        return "editarEmpresa";
    }

    @PostMapping("/atualizarEmpresa")
    public String atualizarEmpresa(@PathVariable Long id, @ModelAttribute Empresa objEmpresaAtualizado) {

        return "redirect:/empresaCTR/listarTodasEmpresas";
    }

}
