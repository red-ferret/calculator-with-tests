import com.calculator.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addition() {
        int a = 1;
        int b = -2;
        int expected = -1;
        int actual = calculator.addition(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction() {
        int a = 535552525;
        int b = 8258478;
        int expected = 527294047;
        int actual = calculator.subtraction(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication() {
        int a = 35;
        int b = -2;
        int expected = -70;
        int actual = calculator.multiplication(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void division() {
        int a = 35;
        int b = 2;
        double expected = 17.5;
        double actual = calculator.division(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void divisionByZero() {
        int a = 35;
        int b = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.division (a, b);
        }, "Can't divide by zero");
    }
}