package br.inter.desafio.shared.utils;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class StringOperations {

    private StringOperations() { }

    public static StringBuilder concatenarString(String stringASerConcatenada, int fatorDeConcatenacao) {

        StringBuilder primeiroFatorConcatenado = new StringBuilder();
        for (int iterator = 0; iterator < fatorDeConcatenacao; iterator++) {
            primeiroFatorConcatenado.append(stringASerConcatenada);
        }

        return primeiroFatorConcatenado;
    }

    public static List<String> separarElementosDeUmaString(StringBuilder stringASerSeparada) {

        List<String> elementosUnicos = newArrayList();
        for (int iterator = stringASerSeparada.length() - 1; iterator >= 0; iterator--) {
            elementosUnicos.add(stringASerSeparada.substring(iterator, iterator + 1));
        }

        return elementosUnicos;
    }

}
