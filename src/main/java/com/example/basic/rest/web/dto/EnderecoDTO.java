package com.example.basic.rest.web.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EnderecoDTO {

    private Long id;

    private String logradouro;

    private String numero;

    private String latitude;

    private String longitude;
}
