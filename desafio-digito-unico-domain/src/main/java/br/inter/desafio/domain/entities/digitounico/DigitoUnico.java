package br.inter.desafio.domain.entities.digitounico;

import br.inter.desafio.shared.asserts.DomainEntity;
import br.inter.desafio.shared.utils.StringOperations;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class DigitoUnico extends DomainEntity {

    private String valorASerConcatenado;
    private int numeroDeConcatenacoes;

    private int valorDigitoUnico;

    private DigitoUnico(String valorASerConcatenado, int numeroDeConcatenacoes) {
        this.assertArgumentNotEmpty(valorASerConcatenado, "É necessário informar o fator N para o domínio.");
        this.assertArgumentNotZero(numeroDeConcatenacoes, "É necessário informar o fator K para o domínio.");

        this.valorASerConcatenado = valorASerConcatenado;
        this.numeroDeConcatenacoes = numeroDeConcatenacoes;
        this.valorDigitoUnico = digitoUnico(valorASerConcatenado, numeroDeConcatenacoes);
    }

    public DigitoUnico(Long id, String valorASerConcatenado, int numeroDeConcatenacoes, int valorDigitoUnico) {
        setId(id);

        this.valorASerConcatenado = valorASerConcatenado;
        this.numeroDeConcatenacoes = numeroDeConcatenacoes;
        this.valorDigitoUnico = valorDigitoUnico;
    }

    public static DigitoUnico calcularDigitoUnico(String valorASerConcatenado, int numeroDeConcatenacoes) {
        return new DigitoUnico(valorASerConcatenado, numeroDeConcatenacoes);
    }

    public static DigitoUnico recuperarDigitoUnicoCalculado(Long id, String valorASerConcatenado, int numeroDeConcatenacoes,
                                                            int valorDigitoUnico) {
        return new DigitoUnico(id, valorASerConcatenado, numeroDeConcatenacoes, valorDigitoUnico);
    }

    private int digitoUnico(String valor, int numeroDeConcatenacoes) {

        StringBuilder resultadoDaConcatenacao = StringOperations.concatenarString(valor, numeroDeConcatenacoes);

        List<String> algarismosDoNumero = StringOperations.separarElementosDeUmaString(resultadoDaConcatenacao);

        for (int i = 0; i < resultadoDaConcatenacao.length(); i++) {
            valorDigitoUnico += Integer.parseInt(algarismosDoNumero.get(i));
        }

        return valorDigitoUnico;
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
