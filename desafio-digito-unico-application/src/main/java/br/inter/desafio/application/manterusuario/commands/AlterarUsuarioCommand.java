package br.inter.desafio.application.manterusuario.commands;

import br.inter.desafio.shared.asserts.AssertionConcern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AlterarUsuarioCommand extends AssertionConcern {

    private Integer idUsuario;
    private String nome;
    private String email;

    public AlterarUsuarioCommand(Integer idUsuario, String nome, String email) {
        this.assertArgumentNotZero(idUsuario, "Por favor, informe um ID de usuário válido.");
        this.assertArgumentNotEmpty(nome, "Por favor, informe um nome de usuário válido.");
        this.assertArgumentNotEmpty(email, "Por favor, informe um e-mail de usuário válido.");

        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
    }

}
