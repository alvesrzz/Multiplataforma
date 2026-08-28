package com.fatec.exemplo.apiusuarios.service;

import com.fatec.exemplo.apiusuarios.model.Cliente;
import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public  Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> buscaPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public List<Cliente> buscarPorNomeContendo(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }

    public List<Cliente> buscarPorIdadeMaior(Integer idade) {
        return clienteRepository.findByIdadeGreaterThan(idade);
    }

    public List<Cliente> buscarPorIdadeMenor(Integer idade) {
        return clienteRepository.findByIdadeLessThan(idade);
    }
}
