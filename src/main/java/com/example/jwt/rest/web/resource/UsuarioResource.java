package com.example.jwt.rest.web.resource;

import com.example.jwt.rest.web.dto.UsuarioDTO;
import com.example.jwt.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioServiceImpl usuarioService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<?> salvar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        usuarioService.salvar(usuarioDTO);
        return ResponseEntity.ok(CREATED);
    }

}
