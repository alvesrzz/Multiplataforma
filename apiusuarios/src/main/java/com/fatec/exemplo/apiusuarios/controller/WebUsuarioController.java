package com.fatec.exemplo.apiusuarios.controller;

import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/usuarios")
public class WebUsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
        usuarioService.salvar(usuario);
        return "cadastro";
    }

    @GetMapping("/lista")
    public String listar(@RequestParam(required = false) String nome,
                         Model model) {
        List<Usuario> usuarios = (nome == null || nome.isEmpty())
                ? usuarioService.listarTodos()
                : usuarioService.buscaPorNome(nome);
        model.addAttribute("usuarios", usuarios);
        return "lista";
    }

}
