package com.fatec.exemplo.apiusuarios.repository;

import com.fatec.exemplo.apiusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNome(String nome);

    List<Usuario> findByNomeContaining(String nome);

    List<Usuario> findByIdadeGreaterThan(Integer idade);

    List<Usuario> findByIdadeLessThan(Integer idade);
}
