package br.inter.desafio.application.manterusuario.commands;

import br.inter.desafio.shared.asserts.AssertionConcern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CadastrarUsuarioCommand extends AssertionConcern {

    private String nome;
    private String email;

    public CadastrarUsuarioCommand(String nome, String email) {
        this.assertArgumentNotEmpty(nome, "Informe o nome para dar prosseguimento ao cadastro.");
        this.assertArgumentNotEmpty(email, "Informe o e-mail para dar prosseguimento ao cadastro.");

        this.nome = nome;
        this.email = email;
    }
}
