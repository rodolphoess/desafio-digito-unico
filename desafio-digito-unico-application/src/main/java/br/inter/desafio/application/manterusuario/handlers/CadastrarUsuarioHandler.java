package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.commands.CadastrarUsuarioCommand;
import br.inter.desafio.domain.entities.usuario.Usuario;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import br.inter.desafio.shared.value.Email;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class CadastrarUsuarioHandler {

    private final UsuarioRepository usuarioRepository;

    public CadastrarUsuarioHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void handle(CadastrarUsuarioCommand command) {
        requireNonNull(command);

        Usuario usuario = Usuario.criar(command.getNome(), new Email(command.getEmail()));

        usuarioRepository.salvar(usuario);
    }

}
