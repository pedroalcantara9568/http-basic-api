package com.example.jwt.rest.web.mapper;

import com.example.jwt.domain.Usuario;
import com.example.jwt.rest.web.dto.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioDTO entityToDto(Usuario usuario) {
        return UsuarioDTO.builder()
                .login(usuario.getLogin())
                .senha(usuario.getSenha())
                .build();
    }

    public static Usuario dtoToEntity(UsuarioDTO usuario) {
        return Usuario.builder()
                .login(usuario.getLogin())
                .senha(usuario.getSenha())
                .build();
    }

    public static List<UsuarioDTO> entityToDto(List<Usuario> usuarioList) {
        return usuarioList.stream().map(UsuarioMapper::entityToDto).collect(Collectors.toList());
    }

    public static List<Usuario> dtoToEntity(List<UsuarioDTO> usuarioList) {
        return usuarioList.stream().map(UsuarioMapper::dtoToEntity).collect(Collectors.toList());
    }
}
