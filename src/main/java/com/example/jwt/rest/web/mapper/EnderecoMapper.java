package com.example.jwt.rest.web.mapper;

import com.example.jwt.domain.Endereco;
import com.example.jwt.rest.web.dto.EnderecoDTO;

import java.util.ArrayList;
import java.util.List;

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

        List<Endereco> enderecos = new ArrayList<>();
        enderecoDTOS.forEach(enderecoDTO -> {
            enderecos.add(dtoToEntity(enderecoDTO));
        });
        return enderecos;
    }

    public static List<EnderecoDTO> entityToDTO(List<Endereco> enderecos) {
        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();
        enderecos.forEach(endereco -> {
            enderecoDTOS.add(entityToDTO(endereco));
        });

        return enderecoDTOS;
    }
}
