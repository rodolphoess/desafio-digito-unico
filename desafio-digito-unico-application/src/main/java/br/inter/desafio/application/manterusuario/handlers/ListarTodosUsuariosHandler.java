package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarTodosUsuariosHandler {

    private final UsuarioRepository usuarioRepository;

    public ListarTodosUsuariosHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> handle() {
        return this.usuarioRepository.listarTodos();
    }

}
