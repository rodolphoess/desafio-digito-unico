package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListarTodosUsuariosHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UsuarioRepository usuarioRepository;

    private ListarTodosUsuariosHandler handler;

    @Before
    public void setUp() {
        this.handler = new ListarTodosUsuariosHandler(usuarioRepository);
    }

    @Test
    public void deve_fazer_requisicao_para_listar_todos_os_usuarios_com_sucesso() {
        handler.handle();

        verify(usuarioRepository, times(1)).listarTodos();
    }

}
