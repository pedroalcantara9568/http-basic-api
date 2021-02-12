package com.example.jwt.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String logradouro;

    private String numero;

    private String latitude;

    private String longitude;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
