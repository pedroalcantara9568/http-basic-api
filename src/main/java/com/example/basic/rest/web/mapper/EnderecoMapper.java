package com.example.basic.rest.web.mapper;

import com.example.basic.domain.Endereco;
import com.example.basic.rest.web.dto.EnderecoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoMapper {

    public static Endereco dtoToEntity(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .id(enderecoDTO.getId())
                .numero(enderecoDTO.getNumero())
                .latitude(enderecoDTO.getLatitude())
                .longitude(enderecoDTO.getLongitude())
                .logradouro(enderecoDTO.getLogradouro())
                .build();
    }

    public static EnderecoDTO entityToDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .numero(endereco.getNumero())
                .latitude(endereco.getLatitude())
                .longitude(endereco.getLongitude())
                .logradouro(endereco.getLogradouro())
                .build();
    }

    public static List<Endereco> dtoToEntity(List<EnderecoDTO> enderecoDTOS) {
        return enderecoDTOS.stream().map(EnderecoMapper::dtoToEntity).collect(Collectors.toList());
    }

    public static List<EnderecoDTO> entityToDTO(List<Endereco> enderecos) {
        return enderecos.stream().map(EnderecoMapper::entityToDTO).collect(Collectors.toList());

    }
}
