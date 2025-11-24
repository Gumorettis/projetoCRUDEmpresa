package com.projetoCRUD1.projetoEmpresa.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoCRUD1.projetoEmpresa.ENTITY.Funcionario;
import com.projetoCRUD1.projetoEmpresa.SERVICE.EmpresaService;
import com.projetoCRUD1.projetoEmpresa.SERVICE.FuncionarioService;

@Controller
@RequestMapping("/funcionarioCTR")
public class FuncionarioController {

    @Autowired
    private FuncionarioService ligacaoFuncionarioService;

    @Autowired
    private EmpresaService ligacaoEmpresaService;

    @GetMapping("/listarFunc")
    public String listarTodosFuncionarios(Model oModel) {
        oModel.addAttribute("funcionarios",
        ligacaoFuncionarioService.listarTodosFuncionarios());

        return "listarFuncionarios";
    }

    @GetMapping("/formFuncionario")
    public String mostrarFormCadastro(Model oModel) {
        
        oModel.addAttribute("funcionario", new Funcionario());
        oModel.addAttribute("empresas", ligacaoEmpresaService.findAll());
        return "cadastrarFuncionario";
    }

    @PostMapping("salvarFuncionario")
    public String salvarFuncionario(@ModelAttribute Funcionario objFuncionario) {
        ligacaoFuncionarioService.cadastrarFuncionario(objFuncionario);
        return "redirect:/funcionarioCTR/listarFunc";
    }

    @GetMapping("/deletarFuncionario/{id}")
    public String excluirFuncionario(@PathVariable("id") Long id) {

        ligacaoFuncionarioService.deletarFuncionario(id);
        return "redirect:/funcionarioCTR/listarFunc";
    }

    //@GetMapping
}
