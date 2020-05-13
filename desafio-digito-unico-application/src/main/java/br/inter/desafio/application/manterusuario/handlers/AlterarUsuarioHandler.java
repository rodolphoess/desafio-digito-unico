package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.commands.AlterarUsuarioCommand;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class AlterarUsuarioHandler {

    private UsuarioRepository usuarioRepository;

    public AlterarUsuarioHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void handle(AlterarUsuarioCommand command) {
        requireNonNull(command);

        this.usuarioRepository.alterar(command.getIdUsuario(),
                                       command.getNome(),
                                       command.getEmail()
        );
    }

}
