package com.example.basic.rest.web.resource;


import com.example.basic.rest.web.dto.EnderecoDTO;
import com.example.basic.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoResource {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoResource(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listar() {
        final List<EnderecoDTO> enderecoDTOS = enderecoService.buscarTodosEnderecos();

        return new ResponseEntity<>(enderecoDTOS, HttpStatus.OK);
    }

}
