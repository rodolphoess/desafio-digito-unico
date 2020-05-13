package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.queries.ListarUsuarioPorIdQuery;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class ListarUsuarioHandler {

    private final UsuarioRepository usuarioRepository;

    public ListarUsuarioHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO handle(ListarUsuarioPorIdQuery query) {
        requireNonNull(query);

        return usuarioRepository.listarPorId(query.getIdUsuario());
    }

}
