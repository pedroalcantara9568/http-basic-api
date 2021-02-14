package com.example.jwt.shared;

public class Constantes {

    public static final String BUSCAR_USUARIO_BY_NOME = "select login as principal, senha as credentails, true from usuario where login= ?";

    public static final String BUSCAR_PAPEL_BY_LOGIN = "select login as principal,nome as role from usuario inner join usuario_papel on usuario.num_pessoa = usuario_papel.usuario_num_pessoa inner join papel on usuario_papel.papel_id = papel.id where usuario.login = ?";

}
