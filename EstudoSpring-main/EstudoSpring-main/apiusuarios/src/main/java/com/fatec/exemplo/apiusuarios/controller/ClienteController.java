package com.fatec.exemplo.apiusuarios.controller;

import com.fatec.exemplo.apiusuarios.model.Cliente;
import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.repository.ClienteRepository;
import com.fatec.exemplo.apiusuarios.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarPorNome(@RequestParam String nome) {
        return clienteService.buscaPorNome(nome);
    }

    @GetMapping("/buscarContendo")
    public List<Cliente> buscarPorNomeContendo(@RequestParam String nome) {
        return clienteService.buscarPorNomeContendo(nome);
    }

    @GetMapping("/buscarIdadeMaior")
    public List<Cliente> buscarPorIdadeMaior(@RequestParam Integer idade) {
        return clienteService.buscarPorIdadeMaior(idade);
    }

    @GetMapping("/buscarIdadeMenor")
    public List<Cliente> buscarPorIdadeMenor(@RequestParam Integer idade) {
        return clienteService.buscarPorIdadeMenor(idade);
    }
}
