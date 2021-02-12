package com.example.jwt.service;


import com.example.jwt.rest.web.dto.EnderecoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnderecoService {
    List<EnderecoDTO> buscarTodosEnderecos();
}
