package br.inter.desafio.web.mvc.controllers.usuario.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcularDigitoUnicoParaUsuarioForm {

    private Integer idUsuario;
    private String valorASerConcatenado;
    private int numeroDeConcatenacoes;

}
