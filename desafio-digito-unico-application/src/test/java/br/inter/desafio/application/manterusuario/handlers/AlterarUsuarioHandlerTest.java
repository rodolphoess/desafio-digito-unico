package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.commands.AlterarUsuarioCommand;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AlterarUsuarioHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UsuarioRepository usuarioRepository;

    private AlterarUsuarioHandler handler;

    @Before
    public void setUp() {
        this.handler = new AlterarUsuarioHandler(usuarioRepository);
    }

    @Test
    public void deve_fazer_requisicao_para_alterar_um_usuario_com_sucesso_ao_receber_os_dados() {
        AlterarUsuarioCommand command = AlterarUsuarioCommand.builder()
                                                             .idUsuario(1)
                                                             .nome("Usuário Modificado")
                                                             .email("teste@email.com")
                                                             .build();

        handler.handle(command);

        verify(usuarioRepository, times(1)).alterar(anyInt(), anyString(), anyString());
    }

    @Test
    public void deve_retornar_uma_excecao_quando_passar_o_command_nulo() {
        expectedException.expect(NullPointerException.class);

        handler.handle(null);
    }

}
