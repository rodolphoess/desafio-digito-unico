package br.inter.desafio.web.mvc.controllers.usuario.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlterarUsuarioForm {

    private Integer idUsuario;
    private String nome;
    private String email;

}
