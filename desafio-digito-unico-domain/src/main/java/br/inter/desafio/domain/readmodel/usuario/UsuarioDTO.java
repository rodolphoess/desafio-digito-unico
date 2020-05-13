package br.inter.desafio.domain.readmodel.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String email;
    private List<DigitoUnico> digitosUnicos;

    @Getter
    @AllArgsConstructor
    public static class DigitoUnico {

        private String valorASerConcatenado;
        private int numeroDeConcatenacoes;
        private int valorDigitoUnico;
    }

}
