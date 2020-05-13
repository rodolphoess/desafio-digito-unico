package br.inter.desafio.domain.entities.usuario;

import br.inter.desafio.domain.entities.digitounico.DigitoUnico;
import br.inter.desafio.shared.asserts.DomainEntity;
import br.inter.desafio.shared.value.Email;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Usuario extends DomainEntity {

    private String nome;
    private Email email;
    private List<DigitoUnico> digitosUnicosCalculados = newArrayList();

    private Usuario(String nome, Email email) {
        this.assertArgumentNotEmpty(nome, "É necessário informar um nome de usuário ao domínio.");
        this.assertArgumentNotNull(email, "É necessário informar o e-mail do usuário ao domínio.");

        this.nome = nome;
        this.email = email;
    }

    private Usuario(Integer id, String nome, Email email, List<DigitoUnico> digitosUnicosCalculados) {
        setId(id);

        this.nome = nome;
        this.email = email;
        this.digitosUnicosCalculados = digitosUnicosCalculados;
    }

    public static Usuario criar(String nome, Email email) {
        return new Usuario(nome, email);
    }

    public static Usuario recuperar(Integer id, String nome, Email email, List<DigitoUnico> digitosUnicosCalculados) {
        return new Usuario(id, nome, email, digitosUnicosCalculados);
    }

    public void calcularDigitoUnicoParaUsuario(String valorASerConcatenado, int numeroDeConcatenacoes) {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico(valorASerConcatenado, numeroDeConcatenacoes);

        this.digitosUnicosCalculados.add(digitoUnico);
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<DigitoUnico> getDigitosUnicosCalculados() {
        return digitosUnicosCalculados;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getClass())
                .append(getId())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario entity = (Usuario) obj;

            return new EqualsBuilder()
                    .append(getId(), entity.getId())
                    .isEquals();
        }

        return false;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
