package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.queries.RecuperarUsuarioPorIdQuery;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;

@Service
public class RecuperarUsuarioHandler {

    private final UsuarioRepository usuarioRepository;

    public RecuperarUsuarioHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO handle(RecuperarUsuarioPorIdQuery query) {
        return usuarioRepository.recuperar(query.getIdUsuario());
    }

}
