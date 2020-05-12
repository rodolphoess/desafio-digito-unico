package br.inter.desafio.application.manterdigitounico.commands;

import br.inter.desafio.shared.asserts.AssertionConcern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CalcularDigitoUnicoCommand extends AssertionConcern {

    private String valorASerConcatenado;
    private int fatorDeConcatenacao;

    public CalcularDigitoUnicoCommand(String valorASerConcatenado, int fatorDeConcatenacao) {
        this.assertArgumentNotEmpty(valorASerConcatenado, "É necessário informar o valor a ser concatenado. " +
                "Por favor, informe um valor válido.");
        this.assertArgumentTrue(Long.parseLong(valorASerConcatenado) <= 0L, "É necessário informar um valor a ser concatenado maior do que zero. " +
                "Por favor, informe um valor válido.");
        this.assertArgumentTrue(fatorDeConcatenacao <= 0L, "É necessário informar um fator de concatenação maior do que 0 " +
                "e menor do que 10^1000001. Por favor, informe um fator válido.");

        this.valorASerConcatenado = valorASerConcatenado;
        this.fatorDeConcatenacao = fatorDeConcatenacao;

    }

}
