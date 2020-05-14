package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.commands.CadastrarUsuarioCommand;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarUsuarioHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock private UsuarioRepository usuarioRepository;

    private CadastrarUsuarioHandler handler;

    @Before
    public void setUp() {
        this.handler = new CadastrarUsuarioHandler(usuarioRepository);
    }

    @Test
    public void deve_fazer_requisicao_para_cadastrar_um_usuario_com_sucesso_ao_receber_o_command_com_os_dados_necessarios() {
        CadastrarUsuarioCommand command = CadastrarUsuarioCommand.builder()
                                                                 .nome("Usuário")
                                                                 .email("teste@teste.com")
                                                                 .build();

        handler.handle(command);

        verify(usuarioRepository, times(1)).salvar(any());
    }

    @Test
    public void deve_retornar_uma_excecao_quando_passar_o_command_nulo() {
        expectedException.expect(NullPointerException.class);

        handler.handle(null);
    }

}
