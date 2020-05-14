package br.inter.desafio.application.manterusuario.handlers;

import br.inter.desafio.application.manterusuario.commands.CalcularDigitoUnicoParaUsuarioCommand;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CalcularDigitoUnicoParaUsuarioHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock private UsuarioRepository usuarioRepository;

    private CalcularDigitoUnicoParaUsuarioHandler handler;

    @Before
    public void setUp() {
        this.handler = new CalcularDigitoUnicoParaUsuarioHandler(usuarioRepository);
    }

    @Test
    public void deve_fazer_requisicao_para_garantir_o_calculo_do_digito_unico_para_o_usuario_com_os_parametros_passados() {
        CalcularDigitoUnicoParaUsuarioCommand command = CalcularDigitoUnicoParaUsuarioCommand.builder()
                                                                                             .idUsuario(1)
                                                                                             .valorASerConcatenado("9875")
                                                                                             .numeroDeConcatenacoes(4)
                                                                                             .build();

        handler.handle(command);

        verify(usuarioRepository, times(1)).calcularDigitoUnicoParaUsuario(anyInt(), anyString(), anyInt());
    }

    @Test
    public void deve_retornar_uma_excecao_quando_passar_o_command_nulo() {
        expectedException.expect(NullPointerException.class);

        handler.handle(null);
    }

}
