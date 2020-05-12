package br.inter.desafio.shared.asserts;

public class AssertionConcern {

    protected AssertionConcern() { }

    protected void assertArgumentNotEmpty(String aString, String aMessage) {
        if (aString == null || aString.trim().isEmpty()) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentNotNull(Object anObject, String aMessage) {
        if (anObject == null) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentEquals(Object anObject1, Object anObject2, String aMessage) {
        if (!anObject1.equals(anObject2)) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentNotZero(Long aLong, String aMessage) {
        if (aLong == null || aLong == 0L) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentNotZero(Integer anInt, String aMessage) {
        if (anInt == null || anInt == 0) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentTrue(boolean aBoolean, String aMessage) {
        if (aBoolean) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentFalse(boolean aBoolean, String aMessage) {
        if (!aBoolean) {
            throw new IllegalArgumentException(aMessage);
        }
    }



}
