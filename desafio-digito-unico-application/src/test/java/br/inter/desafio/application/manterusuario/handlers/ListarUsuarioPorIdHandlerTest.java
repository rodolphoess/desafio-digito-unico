package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.queries.ListarUsuarioPorIdQuery;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListarUsuarioPorIdHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UsuarioRepository usuarioRepository;

    private ListarUsuarioPorIdHandler handler;

    @Before
    public void setUp() {
        this.handler = new ListarUsuarioPorIdHandler(usuarioRepository);
    }

    @Test
    public void deve_fazer_requisicao_para_listar_um_usuario_de_acordo_com_o_id_passado() {
        ListarUsuarioPorIdQuery query = ListarUsuarioPorIdQuery.builder()
                                                               .idUsuario(1)
                                                               .build();

        handler.handle(query);

        verify(usuarioRepository, times(1)).listarPorId(anyInt());
    }

    @Test
    public void deve_retornar_uma_excecao_quando_passar_o_command_nulo() {
        expectedException.expect(NullPointerException.class);

        handler.handle(null);
    }

}
