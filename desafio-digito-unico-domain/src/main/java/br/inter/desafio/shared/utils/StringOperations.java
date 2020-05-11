package br.inter.desafio.shared.utils;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class StringOperations {

    private StringOperations() { }

    public static List<String> separarAlgarismosDeUmNumero(StringBuilder primeiroFatorConcatenado) {

        List<String> algarismosUnicos = newArrayList();
        for (int i = primeiroFatorConcatenado.length() - 1; i >= 0; i--) {
            algarismosUnicos.add(primeiroFatorConcatenado.substring(i, i + 1));
        }

        return algarismosUnicos;
    }

    public static StringBuilder concatenarPrimeiroFator(String primeiroFator, int segundoFator) {

        StringBuilder primeiroFatorConcatenado = new StringBuilder();
        for (int i = 0; i < segundoFator; i++) {
            primeiroFatorConcatenado.append(primeiroFator);
        }

        return primeiroFatorConcatenado;
    }

}
