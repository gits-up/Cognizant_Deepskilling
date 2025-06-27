package test.java;

import main.java.ExceptionThrower;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest {

    @Test
    void testExceptionIsThrown() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
    }

    @Test
    void testNoException() {
        ExceptionThrower thrower = new ExceptionThrower();

        thrower.throwException(false);
    }
}
