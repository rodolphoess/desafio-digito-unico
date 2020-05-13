package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.commands.CalcularDigitoUnicoParaUsuarioCommand;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class CalcularDigitoUnicoParaUsuarioHandler {

    private final UsuarioRepository usuarioRepository;

    public CalcularDigitoUnicoParaUsuarioHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void handle(CalcularDigitoUnicoParaUsuarioCommand command) {
        requireNonNull(command);

        this.usuarioRepository.calcularDigitoUnicoParaUsuario(command.getIdUsuario(),
                                                              command.getValorASerConcatenado(),
                                                              command.getNumeroDeConcatenacoes()
        );
    }

}
