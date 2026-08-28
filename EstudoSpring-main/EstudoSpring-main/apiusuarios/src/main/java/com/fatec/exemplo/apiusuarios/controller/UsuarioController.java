package com.fatec.exemplo.apiusuarios.controller;

import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.repository.UsuarioRepository;
import com.fatec.exemplo.apiusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @GetMapping("/buscar")
    public List<Usuario> buscarPorNome(@RequestParam String nome) {
        return usuarioService.buscaPorNome(nome);
    }

    @GetMapping("/buscarContendo")
    public List<Usuario> buscarPorNomeContendo(@RequestParam String nome) {
        return usuarioService.buscarPorNomeContendo(nome);
    }

    @GetMapping("/buscarIdadeMaior")
    public List<Usuario> buscarPorIdadeMaior(@RequestParam Integer idade) {
        return usuarioService.buscarPorIdadeMaior(idade);
    }

    @GetMapping("/buscarIdadeMenor")
    public List<Usuario> buscarPorIdadeMenor(@RequestParam Integer idade) {
        return usuarioService.buscarPorIdadeMenor(idade);
    }


}
