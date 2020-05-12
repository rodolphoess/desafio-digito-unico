package br.inter.desafio.domain.entities.usuario;

import br.inter.desafio.domain.entities.digitounico.DigitoUnico;
import br.inter.desafio.shared.value.Email;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class UsuarioTest {

    private final String NOME = "Nome Usuário";
    private final Email EMAIL = new Email("email@teste.com");
    private final List<DigitoUnico> DIGITOS_UNICOS_CALCULADOS = instanciarDigitosUnicos();
    private final String VALOR_A_SER_CONCATENADO = "9875";
    private final int NUMERO_CONCATENACOES = 4;
    private final int VALOR_DIGITO_UNICO = 116;

    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deve_verificar_se_o_objeto_nao_eh_nulo_apos_criacao() {
        Usuario usuario = Usuario.criar(NOME, EMAIL);

        assertNotNull(usuario);
    }

    @Test
    public void deve_criar_com_sucesso_um_usuario() {
        Usuario usuario = Usuario.criar(NOME, EMAIL);

        assertEquals(NOME, usuario.getNome());
        assertEquals(EMAIL, usuario.getEmail());
    }

    @Test
    public void deve_recuperar_com_sucesso_um_usuario_criado() {
        Usuario usuario = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        assertEquals(Long.valueOf(1L), usuario.getId());

        assertEquals(NOME, usuario.getNome());
        assertEquals(EMAIL, usuario.getEmail());

        DigitoUnico digitoUnico = usuario.getDigitosUnicosCalculados().get(0);
        assertNotNull(digitoUnico);
        assertEquals(VALOR_A_SER_CONCATENADO, digitoUnico.getValorASerConcatenado());
        assertEquals(NUMERO_CONCATENACOES, digitoUnico.getNumeroDeConcatenacoes());
        assertEquals(VALOR_DIGITO_UNICO, digitoUnico.getValorDigitoUnico());
    }

    @Test
    public void deve_realizar_com_sucesso_o_calculo_de_um_digito_unico_para_um_usuario() {
        Usuario usuario = Usuario.criar(NOME, EMAIL);
        usuario.calcularDigitoUnicoParaUsuario(VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES);

        DigitoUnico digitoUnico = DIGITOS_UNICOS_CALCULADOS.get(0);
        assertNotNull(digitoUnico);
        assertEquals(VALOR_A_SER_CONCATENADO, digitoUnico.getValorASerConcatenado());
        assertEquals(NUMERO_CONCATENACOES, digitoUnico.getNumeroDeConcatenacoes());
        assertEquals(VALOR_DIGITO_UNICO, digitoUnico.getValorDigitoUnico());
    }

    @Test
    public void deve_lancar_uma_excecao_ao_tentar_criar_um_usuario_sem_informar_o_nome() {
        expectedException.expect(IllegalArgumentException.class);

        Usuario.criar("", EMAIL);
    }

    @Test
    public void deve_lancar_uma_excecao_ao_tentar_criar_um_usuario_informando_o_nome_nulo() {
        expectedException.expect(IllegalArgumentException.class);

        Usuario.criar(null, EMAIL);
    }

    @Test
    public void deve_lancar_uma_excecao_ao_tentar_criar_um_usuario_sem_informar_o_email() {
        expectedException.expect(IllegalArgumentException.class);

        Usuario.criar(NOME, new Email(""));
    }

    @Test
    public void deve_garantir_que_um_objeto_com_digito_unico_calculado_retorne_seu_estado_corretamente_enquanto_string() {
        Usuario usuario = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        assertEquals("Usuario[nome=Nome Usuário,email=email@teste.com,digitosUnicosCalculados=[DigitoUnico[valorASerConcatenado=9875,numeroDeConcatenacoes=4,valorDigitoUnico=116,id=<null>]],id=1]",
                usuario.toString());
    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_iguais_quando_retornam_o_mesmo_id() {
        Usuario usuario1 = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        Usuario usuario2 = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        assertEquals(usuario1, usuario2);
    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_diferentes_quando_possuem_ids_diferentes() {
        Usuario usuario1 = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        Usuario usuario2 = Usuario.recuperar(2L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        assertNotEquals(usuario1, usuario2);
    }

    @Test
    public void deve_garantir_identificar_que_dois_objetos_sao_de_tipos_diferentes() {
        Usuario usuario = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        assertNotEquals(usuario, "");
    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_diferentes_quando_um_deles_for_nulo() {
        Usuario usuario = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        assertNotEquals(usuario, null);
    }

    @Test
    public void deve_garantir_que_ao_passar_dois_objetos_iguais_retorne_o_mesmo_hashcode() {
        Usuario usuario1 = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        Usuario usuario2 = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        assertEquals(usuario1.hashCode(), usuario2.hashCode());
    }

    @Test
    public void deve_garantir_que_ao_passar_dois_objetos_diferentes_retorne_hashcodes_diferentes() {
        Usuario usuario1 = Usuario.recuperar(1L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        Usuario usuario2 = Usuario.recuperar(2L, NOME, EMAIL, DIGITOS_UNICOS_CALCULADOS);

        assertNotEquals(usuario1.hashCode(), usuario2.hashCode());
    }

    private List<DigitoUnico> instanciarDigitosUnicos() {
        return List.of(DigitoUnico.calcularDigitoUnico(VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES));
    }

}
