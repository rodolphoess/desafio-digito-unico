package br.inter.desafio.application.manterdigitounico.commands;

import br.inter.desafio.shared.asserts.AssertionConcern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CalcularDigitoUnicoCommand extends AssertionConcern {

    private String valorASerConcatenado;
    private int numeroDeConcatenacoes;

    public CalcularDigitoUnicoCommand(String valorASerConcatenado, int numeroDeConcatenacoes) {
        this.assertArgumentNotEmpty(valorASerConcatenado, "É necessário informar um valor para cálculo do dígito único. " +
                "Por favor, informe um valor válido.");
        this.assertArgumentNotZero(numeroDeConcatenacoes, "É necessário informar um fator de concatenação maior do que 0 " +
                "e menor do que 10^1000001. Por favor, informe um fator válido.");

        this.valorASerConcatenado = valorASerConcatenado;
        this.numeroDeConcatenacoes = numeroDeConcatenacoes;
    }

}
