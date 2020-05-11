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

    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deve_verificar_se_o_objeto_nao_eh_nulo_apos_criacao() {

    }

    @Test
    public void deve_criar_com_sucesso_um_usuario() {

    }

    @Test
    public void deve_recuperar_com_sucesso_um_usuario_criado() {

    }

    @Test
    public void deve_realizar_com_sucesso_o_calculo_de_um_digito_unico_para_um_usuario() {

    }

    @Test
    public void deve_verificar_se_os_valores_de_digitos_unicos_correspondem_com_o_esperado() {

    }

    @Test
    public void deve_lancar_uma_excecao_ao_tentar_criar_um_usuario_sem_informar_o_nome() {

    }

    @Test
    public void deve_lancar_uma_excecao_ao_tentar_criar_um_usuario_sem_informar_o_email() {

    }

    @Test
    public void deve_garantir_que_um_objeto_com_digito_unico_calculado_retorne_seu_estado_corretamente_enquanto_string() {

    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_iguais_quando_retornam_o_mesmo_id() {

    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_diferentes_quando_possuem_ids_diferentes() {

    }

    @Test
    public void deve_garantir_identificar_que_dois_objetos_sao_de_tipos_diferentes() {

    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_diferentes_quando_um_deles_for_nulo() {

    }

    @Test
    public void deve_garantir_que_ao_passar_dois_objetos_iguais_retorne_o_mesmo_hashcode() {

    }

    @Test
    public void deve_garantir_que_ao_passar_dois_objetos_diferentes_retorne_hashcodes_diferentes() {

    }

    private List<DigitoUnico> instanciarDigitosUnicos() {
        return List.of(DigitoUnico.calcularDigitoUnico("9875", 4));
    }



}
