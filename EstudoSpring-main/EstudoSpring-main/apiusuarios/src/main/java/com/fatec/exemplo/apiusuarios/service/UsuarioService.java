package com.fatec.exemplo.apiusuarios.service;


import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> buscaPorNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    public List<Usuario> buscarPorNomeContendo(String nome) {
        return usuarioRepository.findByNomeContaining(nome);
    }

    public List<Usuario> buscarPorIdadeMaior(Integer idade) {
        return usuarioRepository.findByIdadeGreaterThan(idade);
    }

    public List<Usuario> buscarPorIdadeMenor(Integer idade) {
        return usuarioRepository.findByIdadeLessThan(idade);
    }
}
