package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.queries.ListarDigitosUnicosUsuarioQuery;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
public class ListarDigitosUnicosUsuarioHandler {

    private final UsuarioRepository usuarioRepository;

    public ListarDigitosUnicosUsuarioHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO.DigitoUnico> handle(ListarDigitosUnicosUsuarioQuery query) {
        requireNonNull(query);

        return this.usuarioRepository.recuperarCalculosDeDigitoUnicoDeUmUsuario(query.getIdUsuario());
    }

}
