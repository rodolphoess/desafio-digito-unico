package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.commands.DeletarUsuarioPorIdCommand;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class DeletarUsuarioHandler {

    private final UsuarioRepository usuarioRepository;

    public DeletarUsuarioHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void handle(DeletarUsuarioPorIdCommand command) {
        requireNonNull(command);

        this.usuarioRepository.deletar(command.getIdUsuario());
    }

}
