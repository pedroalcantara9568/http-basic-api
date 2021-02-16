package com.example.basic.service;


import com.example.basic.rest.web.dto.EnderecoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnderecoService {
    List<EnderecoDTO> buscarTodosEnderecos();
}
