package br.inter.desafio.web.mvc.controllers.usuario;

import br.inter.desafio.application.manterusuario.handlers.*;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootApplication(scanBasePackages = {"br.inter.desafio.web.mvc.controllers.usuario"})
class TesteWebMvc { }

@RunWith(SpringRunner.class)
@WebMvcTest(value = UsuarioController.class)
@ContextConfiguration(classes = {TesteWebMvc.class})
public class UsuarioControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @MockBean private CadastrarUsuarioHandler cadastrarUsuarioHandler;;
    @MockBean private ListarUsuarioPorIdHandler listarUsuarioPorIdHandler;
    @MockBean private ListarTodosUsuariosHandler listarTodosUsuariosHandler;
    @MockBean private DeletarUsuarioPorIdHandler deletarUsuarioPorIdHandler;
    @MockBean private AlterarUsuarioHandler alterarUsuarioHandler;
    @MockBean private CalcularDigitoUnicoParaUsuarioHandler calcularDigitoUnicoParaUsuarioHandler;
    @MockBean private ListarDigitosUnicosUsuarioHandler listarDigitosUnicosUsuarioHandler;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void deve_fazer_uma_requisicao_post_para_cadastrar_um_usuario_com_sucesso() throws Exception {
        mockMvc.perform(post("/usuario/cadastrar").contentType(MediaType.APPLICATION_JSON)
                                           .content("{" +
                                                       "\"nome\": \"Usuário\"," +
                                                       "\"email\": \"teste@teste.com\"" +
                                                   "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deve_fazer_uma_requisicao_get_para_listar_um_usuario_de_acordo_com_o_id_passado() throws Exception {
        mockMvc.perform(get("/usuario/listar?id=1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deve_fazer_uma_requisicao_get_para_listar_todos_os_usuarios() throws Exception {
        mockMvc.perform(get("/usuario/listar-todos").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deve_fazer_uma_requisicao_delete_para_deletar_um_usuario_com_o_id_passado() throws Exception {
        mockMvc.perform(delete("/usuario/deletar?id=1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deve_fazer_uma_requisicao_put_para_alterar_os_dados_de_um_usuario() throws Exception {
        mockMvc.perform(put("/usuario/alterar").contentType(MediaType.APPLICATION_JSON)
                                                          .content("{" +
                                                                      "\"idUsuario\": 1," +
                                                                      "\"nome\": \"Usuário Modificado\"," +
                                                                      "\"email\": \"teste@teste.com\"" +
                                                                  "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deve_fazer_uma_requisicao_post_para_calcular_o_digito_unico_para_um_usuario() throws Exception {
        mockMvc.perform(post("/usuario/calcular-digito-unico").contentType(MediaType.APPLICATION_JSON)
                                                                         .content("{" +
                                                                                     "\"idUsuario\": 1," +
                                                                                     "\"valorASerConcatenado\": \"9875\"," +
                                                                                     "\"numeroDeConcatenacoes\" : 4" +
                                                                                 "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deve_fazer_uma_requisicao_get_para_listar_os_digitos_unicos_calculados_para_um_usuario() throws Exception {
        mockMvc.perform(get("/usuario/recuperar-digitos-unicos?id-usuario=1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
