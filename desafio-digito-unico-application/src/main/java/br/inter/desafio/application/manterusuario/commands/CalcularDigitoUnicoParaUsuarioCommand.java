package br.inter.desafio.application.manterusuario.commands;

import br.inter.desafio.shared.asserts.AssertionConcern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CalcularDigitoUnicoParaUsuarioCommand extends AssertionConcern {

    private Integer idUsuario;
    private String valorASerConcatenado;
    private int numeroDeConcatenacoes;

    public CalcularDigitoUnicoParaUsuarioCommand(Integer idUsuario, String valorASerConcatenado, int numeroDeConcatenacoes) {
        this.assertArgumentNotZero(idUsuario, "É necessário informar o ID do usuário");

        this.idUsuario = idUsuario;
        this.valorASerConcatenado = valorASerConcatenado;
        this.numeroDeConcatenacoes = numeroDeConcatenacoes;
    }

}
