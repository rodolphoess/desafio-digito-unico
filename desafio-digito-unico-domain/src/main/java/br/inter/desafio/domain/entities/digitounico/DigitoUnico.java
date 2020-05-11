package br.inter.desafio.domain.entities.digitounico;

import br.inter.desafio.shared.asserts.DomainEntity;
import br.inter.desafio.shared.utils.StringOperations;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class DigitoUnico extends DomainEntity {

    private String primeiroFator;
    private int segundoFator;

    private int valorDigitoUnico;

    private DigitoUnico(String primeiroFator, int segundoFator) {
        this.assertArgumentNotEmpty(primeiroFator, "É necessário informar o fator N para o domínio.");
        this.assertArgumentNotZero(segundoFator, "É necessário informar o fator K para o domínio.");

        this.primeiroFator = primeiroFator;
        this.segundoFator = segundoFator;
    }

    public static DigitoUnico calcularDigitoUnico(String primeiroFator, int segundoFator) {
        DigitoUnico instanciaDigitoUnico = new DigitoUnico(primeiroFator, segundoFator);

        instanciaDigitoUnico.digitoUnico(primeiroFator, segundoFator);

        return instanciaDigitoUnico;
    }

    private int digitoUnico(String primeiroFator, int segundoFator) {

        StringBuilder primeiroFatorConcatenado = StringOperations.concatenarPrimeiroFator(primeiroFator, segundoFator);

        List<String> algarismosDoNumero = StringOperations.separarAlgarismosDeUmNumero(primeiroFatorConcatenado);

        for (int i = 0; i < primeiroFatorConcatenado.length(); i++) {
            valorDigitoUnico += Integer.parseInt(algarismosDoNumero.get(i));
        }

        return valorDigitoUnico;
    }

    public String getPrimeiroFator() {
        return primeiroFator;
    }

    public int getSegundoFator() {
        return segundoFator;
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

            return new EqualsBuilder().append(getId(), entity.getId())
                                      .isEquals();
        }

        return false;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
