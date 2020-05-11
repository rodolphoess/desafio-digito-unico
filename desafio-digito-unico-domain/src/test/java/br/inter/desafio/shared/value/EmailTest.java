package br.inter.desafio.shared.value;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EmailTest {

    private final String EMAIL_FORNECIDO = "teste@email.com";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deve_criar_objeto_ao_fornecer_um_email() {
        Email email = new Email(EMAIL_FORNECIDO);

        assertNotNull(email);
        assertNotNull(email.toString());
        assertEquals(EMAIL_FORNECIDO, email.getEmailFornecido());
    }

    @Test
    public void deve_falhar_ao_passar_um_email_vazio() {
        this.expectedException.expect(IllegalArgumentException.class);

        Email email = new Email("");

        assertNotNull(email);
        assertNotNull(email.toString());
    }

    @Test
    public void deve_validar_o_retorno_igual_a_false_do_equals_ao_passar_um_objeto_nulo() {
        Email email = new Email(EMAIL_FORNECIDO);

        assertNotEquals(email, null);
    }

    @Test
    public void deve_validar_o_retorno_igual_a_false_do_equals_ao_passar_dois_objetos_diferentes() {
        Email email = new Email(EMAIL_FORNECIDO);

        assertNotEquals(email, "");
    }

    @Test
    public void emails_devem_ser_iguais_ao_chamar_o_equals_da_classe_email() {
        Email email1 = new Email(EMAIL_FORNECIDO);
        Email email2 = new Email(EMAIL_FORNECIDO);

        realizar_asserts_para_checagem_de_objetos_sao_nulos(email1, email2);
        assertEquals(email1, email2);
    }

    @Test
    public void hashcodes_de_emails_devem_ser_iguais_ao_chamar_o_hashcode_da_classe_email() {
        Email email1 = new Email(EMAIL_FORNECIDO);
        Email email2 = new Email(EMAIL_FORNECIDO);

        realizar_asserts_para_checagem_de_objetos_sao_nulos(email1, email2);
        assertEquals(email1.hashCode(), email2.hashCode());
    }

    @Test
    public void emails_devem_ser_diferentes_ao_chamar_o_equals_da_classe_email() {
        Email email1 = new Email(EMAIL_FORNECIDO);
        Email email2 = new Email("teste2@email.com");

        realizar_asserts_para_checagem_de_objetos_sao_nulos(email1, email2);
        assertNotEquals(email1, email2);
    }

    @Test
    public void hashcodes_de_emails_devem_ser_diferentes_ao_chamar_o_hashcode_da_classe_email() {
        Email email1 = new Email(EMAIL_FORNECIDO);
        Email email2 = new Email("teste2@email.com");

        realizar_asserts_para_checagem_de_objetos_sao_nulos(email1, email2);
        assertNotEquals(email1.hashCode(), email2.hashCode());
    }

    private void realizar_asserts_para_checagem_de_objetos_sao_nulos(Email email1, Email email2) {
        assertNotNull(email1);
        assertNotNull(email2);
        assertNotNull(email1.toString());
        assertNotNull(email2.toString());
    }

}
