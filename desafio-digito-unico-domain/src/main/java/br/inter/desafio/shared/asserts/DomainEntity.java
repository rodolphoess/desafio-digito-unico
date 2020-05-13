package br.inter.desafio.shared.asserts;

public class DomainEntity extends AssertionConcern {

    private Integer id;

    protected DomainEntity() { }

    public Integer getId() {
        return this.id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

}
