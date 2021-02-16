package com.example.jwt.service.impl;


import com.example.jwt.repository.EnderecoRepository;
import com.example.jwt.rest.web.dto.EnderecoDTO;
import com.example.jwt.rest.web.mapper.EnderecoMapper;
import com.example.jwt.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Override
    public List<EnderecoDTO> buscarTodosEnderecos() {
        return EnderecoMapper.entityToDTO(enderecoRepository.findAll());
    }
}
