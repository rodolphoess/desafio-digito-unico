package br.inter.desafio.application.manterusuario.commands;

import br.inter.desafio.shared.asserts.AssertionConcern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeletarUsuarioPorIdCommand extends AssertionConcern {

    private Integer idUsuario;

    public DeletarUsuarioPorIdCommand(Integer idUsuario) {
        this.assertArgumentNotZero(idUsuario, "É necessário informar o ID do usuário.");

        this.idUsuario = idUsuario;
    }

}
