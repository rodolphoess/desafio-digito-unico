package br.inter.desafio.shared.asserts;

public class DomainEntity extends AssertionConcern {

    private Long id;

    protected DomainEntity() { }

    public Long getId() {
        return this.id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

}
