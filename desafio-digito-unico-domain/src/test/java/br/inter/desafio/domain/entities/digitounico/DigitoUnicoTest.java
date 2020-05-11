package br.inter.desafio.domain.entities.digitounico;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigitoUnicoTest {

    @Test
    public void deve_calcular_o_digito_unico_de_um_numero_pre_estabelecido_em_exemplo() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico("9875", 4);

        assertNotNull(digitoUnico);
    }

    @Test
    public void deve_calcular_o_digito_unico_de_um_numero_com_um_algarismo_no_limite_inferior() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico("1", 1);

        assertNotNull(digitoUnico);
    }

    @Test
    public void deve_calcular_o_digito_unico_de_um_numero_com_dois_algarismos() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico("10", 3);

        assertNotNull(digitoUnico);
    }

    @Test
    public void deve_calcular_o_digito_unico_de_um_numero_no_limite_superior() {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico("100000000000000000000000000000000000000", 100000);

        assertNotNull(digitoUnico);
    }

}
