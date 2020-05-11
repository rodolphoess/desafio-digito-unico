package br.inter.desafio.commons.value;

import br.inter.desafio.commons.asserts.AssertionConcern;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Email extends AssertionConcern {

    private String emailFornecido;

    public Email(String emailFornecido) {
        this.assertArgumentNotEmpty(emailFornecido, "O email deve ser informado.");

        this.emailFornecido = emailFornecido;
    }

    public String getEmailFornecido() {
        return emailFornecido;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getClass())
                .append(getEmailFornecido())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Email) {
            Email entity = (Email) obj;
            return new EqualsBuilder()
                    .append(getEmailFornecido(), entity.getEmailFornecido())
                    .isEquals();
        }

        return false;
    }

    @Override
    public String toString() {
        return getEmailFornecido();
    }
}
