package br.inter.desafio.web.mvc.controllers.digitounico;

import br.inter.desafio.application.manterdigitounico.handlers.CalcularDigitoUnicoHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootApplication(scanBasePackages = {"br.inter.desafio.web.mvc.controllers.digitounico"})
class TesteWebMvc { }

@RunWith(SpringRunner.class)
@WebMvcTest(value = DigitoUnicoController.class)
@ContextConfiguration(classes = {TesteWebMvc.class})
public class DigitoUnicoControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @MockBean private CalcularDigitoUnicoHandler calcularDigitoUnicoHandler;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void deve_fazer_uma_requisicao_post_para_calcular_o_digito_unico() throws Exception {
        mockMvc.perform(post("/calcular").contentType(MediaType.APPLICATION_JSON)
                                                   .content("{" +
                                                               "\"valorASerConcatenado\": \"9875\"," +
                                                               "\"fatorDeConcatenacao\": 4" +
                                                           "}"))
               .andDo(print())
               .andExpect(status().isOk());
    }

}