package br.inter.desafio.domain.entities.usuario;

import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;

public interface UsuarioRepository {

    void salvar(Usuario usuario);

    UsuarioDTO recuperar(Integer idUsuario);

}
