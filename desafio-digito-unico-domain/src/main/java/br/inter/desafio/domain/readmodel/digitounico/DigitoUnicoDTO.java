package br.inter.desafio.domain.readmodel.digitounico;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DigitoUnicoDTO {

    private Integer id;
    private String valorASerConcatenado;
    private int numeroDeConcatenacoes;
    private int valorDigitoUnico;

}
