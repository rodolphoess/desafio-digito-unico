package br.inter.desafio.shared.utils;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class StringOperations {

    private StringOperations() { }

    public static StringBuilder concatenarString(String stringASerConcatenada, int fatorDeConcatenacao) {

        StringBuilder primeiroFatorConcatenado = new StringBuilder();
        for (int iterador = 0; iterador < fatorDeConcatenacao; iterador++) {
            primeiroFatorConcatenado.append(stringASerConcatenada);
        }

        return primeiroFatorConcatenado;
    }

    public static List<String> separarElementosDeUmaString(StringBuilder stringASerSeparada) {

        List<String> elementosUnicos = newArrayList();
        int ultimoElementoDaLista = stringASerSeparada.length() - 1;

        for (int iterador = ultimoElementoDaLista; iterador >= 0; iterador--) {
            elementosUnicos.add(stringASerSeparada.substring(iterador, iterador + 1));
        }

        return elementosUnicos;
    }

}
