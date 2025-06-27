package main.java;

public class ExceptionThrower {
    public void throwException(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException("Triggered exception");
        }
    }
}
