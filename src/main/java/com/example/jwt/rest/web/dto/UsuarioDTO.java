package com.example.jwt.rest.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
public class UsuarioDTO {

    @Length(message = "o login deve ter entre 6 e 18 characteres ", min = 5, max = 18)
    private String login;

    @NotEmpty(message = "o Campo senha deve esta preenchido")
    @Pattern(regexp = "^((?=.*[\\d])(?=.*[a-z])(?=.*[A-Z])|(?=.*[a-z])(?=.*[A-Z])(?=.*[^\\w\\d\\s])|(?=.*[\\d])(?=.*[A-Z])(?=.*[^\\w\\d\\s])|(?=.*[\\d])(?=.*[a-z])(?=.*[^\\w\\d\\s])).{7,30}$" , message = "a senha deve conter letra minuscula, maiuscula, numero e caractere especial" )
    private String senha;

}
