package br.inter.desafio.domain.entities.digitounico;

import br.inter.desafio.shared.asserts.DomainEntity;
import br.inter.desafio.shared.utils.StringOperations;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigInteger;
import java.util.List;

public class DigitoUnico extends DomainEntity {

    private String valorASerConcatenado;
    private int numeroDeConcatenacoes;

    private int valorDigitoUnico;

    private DigitoUnico(String valorASerConcatenado, int numeroDeConcatenacoes) {
        this.assertArgumentNotEmpty(valorASerConcatenado, "É necessário informar um valor para cálculo do dígito único. " +
                "Por favor, informe um valor válido.");

        this.assertArgumentNotZero(numeroDeConcatenacoes, "É necessário informar um fator de concatenação maior do que 0 " +
                "e menor do que 10^1000001. Por favor, informe um fator válido.");

        this.assertArgumentTrue(numeroDeConcatenacoes < 0, "É necessário informar um fator de concatenação maior do que 0 " +
                "e menor do que 10^1000001. Por favor, informe um fator válido.");

        this.assertArgumentTrue(certificarQueUmNumeroMaiorDoQueLongMinEhNegativo(valorASerConcatenado),
                "É necessário informar um valor para cálculo do dígito único maior do que zero. " +
                        "Por favor, informe um valor válido.");

        if (verificarSeValorASerConcatenadoEhMenorDoQueLongMax(valorASerConcatenado) && !certificarQueUmNumeroMaiorDoQueLongMinEhNegativo(valorASerConcatenado)) {
            this.assertArgumentTrue(Long.parseLong(valorASerConcatenado) <= 0L, "É necessário informar um valor para cálculo do dígito único " +
                    "maior do que zero. Por favor, informe um valor válido.");
        }

        this.valorASerConcatenado = valorASerConcatenado;
        this.numeroDeConcatenacoes = numeroDeConcatenacoes;
        this.valorDigitoUnico = digitoUnico(valorASerConcatenado, numeroDeConcatenacoes);
    }

    private DigitoUnico(Integer id, String valorASerConcatenado, int numeroDeConcatenacoes, int valorDigitoUnico) {
        setId(id);

        this.valorASerConcatenado = valorASerConcatenado;
        this.numeroDeConcatenacoes = numeroDeConcatenacoes;
        this.valorDigitoUnico = valorDigitoUnico;
    }

    public static DigitoUnico calcularDigitoUnico(String valorASerConcatenado, int numeroDeConcatenacoes) {
        return new DigitoUnico(valorASerConcatenado, numeroDeConcatenacoes);
    }

    public static DigitoUnico recuperarDigitoUnicoCalculado(Integer id, String valorASerConcatenado, int numeroDeConcatenacoes,
                                                            int valorDigitoUnico) {
        return new DigitoUnico(id, valorASerConcatenado, numeroDeConcatenacoes, valorDigitoUnico);
    }

    private int digitoUnico(String valor, int numeroDeConcatenacoes) {

        StringBuilder resultadoDaConcatenacao = StringOperations.concatenarString(valor, numeroDeConcatenacoes);

        List<String> algarismosDoNumero = StringOperations.separarElementosDeUmaString(resultadoDaConcatenacao);

        int calculoDigitoUnico = 0;
        for (int iterador = 0; iterador < resultadoDaConcatenacao.length(); iterador++) {
            calculoDigitoUnico += Integer.parseInt(algarismosDoNumero.get(iterador));
        }

        return calculoDigitoUnico;
    }

    private boolean certificarQueUmNumeroMaiorDoQueLongMinEhNegativo(String valorASerConcatenado) {
        BigInteger valorASerConcatenadoInteger = new BigInteger(valorASerConcatenado);

        return valorASerConcatenadoInteger.compareTo(BigInteger.ZERO) < 1;
    }

    private boolean verificarSeValorASerConcatenadoEhMenorDoQueLongMax(String valorASerConcatenado) {
        BigInteger valorASerConcatenadoInteger = new BigInteger(valorASerConcatenado);

        return valorASerConcatenadoInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 1;
    }

    public String getValorASerConcatenado() {
        return valorASerConcatenado;
    }

    public int getNumeroDeConcatenacoes() {
        return numeroDeConcatenacoes;
    }

    public int getValorDigitoUnico() {
        return valorDigitoUnico;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getClass())
                .append(getId())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DigitoUnico) {
            DigitoUnico entity = (DigitoUnico) obj;

            return new EqualsBuilder()
                    .append(getId(), entity.getId())
                    .isEquals();
        }

        return false;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
