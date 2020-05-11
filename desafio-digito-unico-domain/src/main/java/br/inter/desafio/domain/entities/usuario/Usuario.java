package br.inter.desafio.domain.entities.usuario;

import br.inter.desafio.domain.entities.digitounico.DigitoUnico;
import br.inter.desafio.shared.asserts.DomainEntity;
import br.inter.desafio.shared.value.Email;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class Usuario extends DomainEntity {

    private String nome;
    private Email email;
    private List<DigitoUnico> digitosUnicosCalculados;

    private Usuario(String nome, Email email) {
        this.nome = nome;
        this.email = email;
    }

    private Usuario(DigitoUnico digitoUnicoCalculado) {
        this.digitosUnicosCalculados.add(digitoUnicoCalculado);
    }

    private Usuario(Long id, String nome, Email email, List<DigitoUnico> digitosUnicosCalculados) {
        setId(id);

        this.nome = nome;
        this.email = email;
        this.digitosUnicosCalculados = digitosUnicosCalculados;
    }

    public static Usuario criarUsuario(String nome, Email email) {
        return new Usuario(nome, email);
    }

    public static Usuario recuperarUsuario(Long id, String nome, Email email, List<DigitoUnico> digitosUnicosCalculados) {
        return new Usuario(id, nome, email, digitosUnicosCalculados);
    }

    public static Usuario calcularDigitoUnicoParaUsuario(String valorASerConcatenado, int numeroDeConcatenacoes) {
        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico(valorASerConcatenado, numeroDeConcatenacoes);

        return new Usuario(digitoUnico);
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
