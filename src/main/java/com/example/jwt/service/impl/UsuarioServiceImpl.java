package com.example.jwt.service.impl;

import com.example.jwt.domain.Papel;
import com.example.jwt.domain.Usuario;
import com.example.jwt.repository.UsuarioRepository;
import com.example.jwt.rest.web.dto.UsuarioDTO;
import com.example.jwt.rest.web.exception.UsuarioJaExistenteException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

import static com.example.jwt.rest.web.mapper.UsuarioMapper.dtoToEntity;
import static com.example.jwt.rest.web.mapper.UsuarioMapper.entityToDto;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UserDetailsService {

    private final PasswordEncoder encoder;

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nomeDeUsuario) throws UsernameNotFoundException {
        final Usuario usuario = usuarioRepository.findByLogin(nomeDeUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(usuario.getPapel().toString())
                .build();
    }

    public boolean ehExistente(String login){
       return usuarioRepository.existsByLogin(login);
    }

    public UsuarioDTO salvar(@Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = dtoToEntity(usuarioDTO);
        verificarDisponibilidadeLogin(usuario);
        adicionarPapelUSER(usuario);
        adicionarSenhaCriptografada(usuario);
        final Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return entityToDto(usuarioSalvo);
    }

    private void verificarDisponibilidadeLogin(Usuario usuario) {
        if(ehExistente(usuario.getLogin())){
            throw new UsuarioJaExistenteException("O login já esta cadastrado");
        }
    }

    private void adicionarSenhaCriptografada(Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
    }

    private void adicionarPapelUSER(Usuario usuario) {
        final Set<Papel> roles = new HashSet<>();
        Papel roleUsuario = construir();
        roles.add(roleUsuario);
        usuario.setPapel(roles);
    }

    private Papel construir() {
        return Papel.builder()
                .nome("USER")
                .id(1L)
                .build();
    }
}
