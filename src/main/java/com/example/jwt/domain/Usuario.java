package com.example.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numPessoa;

    @NotEmpty(message = "${campo.login.obrigatorio}")
    private String login;

    @NotEmpty(message = "${campo.senha.obrigatorio}")
    private String senha;

    @ManyToMany
    private Set<Papel> papel;
}
