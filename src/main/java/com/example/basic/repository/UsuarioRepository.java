package com.example.basic.repository;

import com.example.basic.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);

    Usuario findUsuarioByLogin(String login);

    boolean existsByLogin(String login);
}
