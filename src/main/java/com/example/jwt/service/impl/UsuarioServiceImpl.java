package com.example.jwt.service.impl;

import com.example.jwt.domain.Papel;
import com.example.jwt.domain.Usuario;
import com.example.jwt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UserDetailsService {


    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

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

    public Usuario salvar(Usuario usuario) {
        String senhaCriptografada = obterSenhaCriptografada(usuario);
        final Set<Papel> roles = new HashSet<>();

        concederRoleUsuario(roles);
        usuario.setPapel(roles);
        usuario.setSenha(senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    private String obterSenhaCriptografada(Usuario usuario) {
        return encoder.encode(usuario.getSenha());
    }

    private void concederRoleUsuario(Set<Papel> roles) {
        Papel roleUsuario = obterRoleUsuario();
        roles.add(roleUsuario);
    }

    private Papel obterRoleUsuario() {
        return Papel.builder()
                .nome("USER")
                .id(1L)
                .build();
    }
}
