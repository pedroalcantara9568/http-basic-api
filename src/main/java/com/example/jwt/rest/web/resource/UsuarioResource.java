package com.example.jwt.rest.web.resource;

import com.example.jwt.domain.Usuario;
import com.example.jwt.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioServiceImpl usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario) {
        if(usuarioService.ehExistente(usuario.getLogin())){
           return new ResponseEntity<>(BAD_REQUEST);
        }
        final Usuario usuarioSalvo = usuarioService.salvar(usuario);
        return new ResponseEntity<>(usuarioSalvo ,BAD_REQUEST);
    }
}
