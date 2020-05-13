package br.inter.desafio.application.manterusuario.queries;

import br.inter.desafio.shared.asserts.AssertionConcern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecuperarUsuarioPorIdQuery extends AssertionConcern {

    private Integer idUsuario;

    public RecuperarUsuarioPorIdQuery(Integer idUsuario) {
        this.assertArgumentNotZero(idUsuario, "É necessário informar o ID do usuário.");

        this.idUsuario = idUsuario;
    }

}
