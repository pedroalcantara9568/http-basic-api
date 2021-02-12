package com.example.jwt.service.impl;


import com.example.jwt.repository.EnderecoRepository;
import com.example.jwt.rest.web.dto.EnderecoDTO;
import com.example.jwt.rest.web.mapper.EnderecoMapper;
import com.example.jwt.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<EnderecoDTO> buscarTodosEnderecos() {
        return EnderecoMapper.entityToDTO(enderecoRepository.findAll());
    }
}
