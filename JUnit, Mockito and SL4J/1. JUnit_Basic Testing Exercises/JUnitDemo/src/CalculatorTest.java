import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(9, calc.add(4, 5));
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.subtract(7, 4));
    }
}
