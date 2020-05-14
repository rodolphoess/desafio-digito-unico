package br.inter.desafio.application.manterdigitounico.handlers;

import br.inter.desafio.application.manterdigitounico.commands.CalcularDigitoUnicoCommand;
import br.inter.desafio.domain.entities.digitounico.DigitoUnicoRepository;
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
public class CalcularDigitoUnicoHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock private DigitoUnicoRepository digitoUnicoRepository;

    private CalcularDigitoUnicoHandler handler;

    @Before
    public void setUp() {
        this.handler = new CalcularDigitoUnicoHandler(digitoUnicoRepository);
    }

    @Test
    public void deve_fazer_requisicao_para_garantir_o_calculo_de_um_digito_unico_de_acordo_com_os_parametros_passados() {
        CalcularDigitoUnicoCommand command = CalcularDigitoUnicoCommand.builder()
                                                                       .valorASerConcatenado("9875")
                                                                       .numeroDeConcatenacoes(4)
                                                                       .build();

        handler.handle(command);

        verify(digitoUnicoRepository, times(1)).salvar(any());
    }

    @Test
    public void deve_retornar_uma_excecao_quando_passar_o_command_nulo() {
        expectedException.expect(NullPointerException.class);

        handler.handle(null);
    }

}
