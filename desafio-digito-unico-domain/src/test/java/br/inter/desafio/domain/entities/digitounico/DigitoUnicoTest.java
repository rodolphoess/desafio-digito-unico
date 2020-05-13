package br.inter.desafio.domain.entities.digitounico;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DigitoUnicoTest {

    private final String VALOR_A_SER_CONCATENADO = "9875";
    private final int NUMERO_CONCATENACOES = 4;
    private final int VALOR_DIGITO_UNICO = 116;

    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deve_verificar_se_o_objeto_nao_eh_nulo_apos_criacao() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico(VALOR_A_SER_CONCATENADO, 1);

        assertNotNull(digitoUnico);
    }

    @Test
    public void deve_calcular_o_digito_unico_de_um_numero_pre_estabelecido_em_exemplo() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico(VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES);

        assertEquals(VALOR_A_SER_CONCATENADO, digitoUnico.getValorASerConcatenado());
        assertEquals(NUMERO_CONCATENACOES, digitoUnico.getNumeroDeConcatenacoes());
        assertEquals(VALOR_DIGITO_UNICO, digitoUnico.getValorDigitoUnico());
    }

    @Test
    public void deve_calcular_o_digito_unico_de_um_numero_com_um_algarismo_no_limite_inferior() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico("1", 1);

        assertEquals("1", digitoUnico.getValorASerConcatenado());
        assertEquals(1, digitoUnico.getNumeroDeConcatenacoes());
        assertEquals(1, digitoUnico.getValorDigitoUnico());
    }

    @Test
    public void deve_calcular_o_digito_unico_de_um_numero_com_dois_algarismos() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico("10", 3);

        assertEquals("10", digitoUnico.getValorASerConcatenado());
        assertEquals(3, digitoUnico.getNumeroDeConcatenacoes());
        assertEquals(3, digitoUnico.getValorDigitoUnico());
    }

    @Test
    public void deve_calcular_o_digito_unico_de_um_numero_no_limite_superior() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico("100000000000000000000000000000000000000",
                100000);

        assertEquals("100000000000000000000000000000000000000", digitoUnico.getValorASerConcatenado());
        assertEquals(100000, digitoUnico.getNumeroDeConcatenacoes());
        assertEquals(100000, digitoUnico.getValorDigitoUnico());
    }

    @Test
    public void deve_lancar_uma_excecao_ao_enviar_o_valor_a_ser_concatenado_menor_do_que_zero() {
        expectedException.expect(IllegalArgumentException.class);

        DigitoUnico.calcularDigitoUnico("-1", NUMERO_CONCATENACOES);
    }

    @Test
    public void deve_lancar_uma_excecao_ao_enviar_o_valor_a_ser_concatenado_menor_do_que_zero_e_maior_do_que_o_limite_inferior_de_long() {
        expectedException.expect(IllegalArgumentException.class);

        DigitoUnico.calcularDigitoUnico("-100000000000000000000000000000000000000", 2);
    }

    @Test
    public void deve_lancar_uma_excecao_ao_enviar_o_numero_de_concatenacoes_menor_do_que_zero() {
        expectedException.expect(IllegalArgumentException.class);

        DigitoUnico.calcularDigitoUnico(VALOR_A_SER_CONCATENADO, -1);
    }

    @Test
    public void deve_lancar_uma_excecao_ao_enviar_o_valor_a_ser_concatenado_vazio() {
        expectedException.expect(IllegalArgumentException.class);

        DigitoUnico.calcularDigitoUnico("", 3);
    }

    @Test
    public void deve_lancar_uma_excecao_ao_enviar_o_valor_a_ser_concatenado_nulo() {
        expectedException.expect(IllegalArgumentException.class);

        DigitoUnico.calcularDigitoUnico(null, 3);
    }

    @Test
    public void deve_lancar_uma_excecao_ao_enviar_o_numero_de_concatenacoes_igual_a_zero() {
        expectedException.expect(IllegalArgumentException.class);

        DigitoUnico.calcularDigitoUnico(VALOR_A_SER_CONCATENADO, 0);
    }

    @Test
    public void deve_garantir_que_um_objeto_com_digito_unico_calculado_retorne_seu_estado_corretamente_enquanto_string() {
        DigitoUnico digitoUnico = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                                                                        VALOR_DIGITO_UNICO);

        assertEquals("DigitoUnico[valorASerConcatenado=9875,numeroDeConcatenacoes=4,valorDigitoUnico=116,id=1]",
                digitoUnico.toString());
    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_iguais_quando_retornam_o_mesmo_id() {
        DigitoUnico digitoUnico1 = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                                                                         VALOR_DIGITO_UNICO);

        DigitoUnico digitoUnico2 = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                                                                        VALOR_DIGITO_UNICO);

        assertEquals(digitoUnico1, digitoUnico2);
    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_diferentes_quando_possuem_ids_diferentes() {
        DigitoUnico digitoUnico1 = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                VALOR_DIGITO_UNICO);

        DigitoUnico digitoUnico2 = DigitoUnico.recuperarDigitoUnicoCalculado(2, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                VALOR_DIGITO_UNICO);

        assertNotEquals(digitoUnico1, digitoUnico2);
    }

    @Test
    public void deve_garantir_identificar_que_dois_objetos_sao_de_tipos_diferentes() {
        DigitoUnico digitoUnico = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                VALOR_DIGITO_UNICO);

        assertNotEquals(digitoUnico, "");
    }

    @Test
    public void deve_garantir_que_dois_objetos_sao_diferentes_quando_um_deles_for_nulo() {
        DigitoUnico digitoUnico = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                VALOR_DIGITO_UNICO);

        assertNotEquals(digitoUnico, null);
    }

    @Test
    public void deve_garantir_que_ao_passar_dois_objetos_iguais_retorne_o_mesmo_hashcode() {
        DigitoUnico digitoUnico1 = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                VALOR_DIGITO_UNICO);

        DigitoUnico digitoUnico2 = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                VALOR_DIGITO_UNICO);

        assertEquals(digitoUnico1.hashCode(), digitoUnico2.hashCode());
    }

    @Test
    public void deve_garantir_que_ao_passar_dois_objetos_diferentes_retorne_hashcodes_diferentes() {
        DigitoUnico digitoUnico1 = DigitoUnico.recuperarDigitoUnicoCalculado(1, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                VALOR_DIGITO_UNICO);

        DigitoUnico digitoUnico2 = DigitoUnico.recuperarDigitoUnicoCalculado(2, VALOR_A_SER_CONCATENADO, NUMERO_CONCATENACOES,
                VALOR_DIGITO_UNICO);

        assertNotEquals(digitoUnico1.hashCode(), digitoUnico2.hashCode());
    }

}
