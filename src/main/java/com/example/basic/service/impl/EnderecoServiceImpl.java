package com.example.basic.service.impl;


import com.example.basic.repository.EnderecoRepository;
import com.example.basic.rest.web.dto.EnderecoDTO;
import com.example.basic.rest.web.mapper.EnderecoMapper;
import com.example.basic.service.EnderecoService;
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
