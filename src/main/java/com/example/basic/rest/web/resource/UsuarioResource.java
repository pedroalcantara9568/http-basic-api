package com.example.basic.rest.web.resource;

import com.example.basic.rest.web.dto.UsuarioDTO;
import com.example.basic.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
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
