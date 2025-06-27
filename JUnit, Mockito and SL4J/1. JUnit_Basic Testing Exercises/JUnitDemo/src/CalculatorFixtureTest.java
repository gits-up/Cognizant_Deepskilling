import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorFixtureTest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Before each test");
    }

    @After
    public void tearDown() {
        calc = null;
        System.out.println("After each test");
    }

    @Test
    public void testAddition() {
        int result = calc.add(10, 5);

        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        int result = calc.subtract(8, 3);

        assertEquals(5, result);
    }
}
