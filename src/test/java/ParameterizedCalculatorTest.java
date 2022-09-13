import com.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParameterizedCalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @MethodSource("addOperationTestData")
    void adding(int a, int b, int expectedSum) {
        Assertions.assertEquals(expectedSum, calculator.addition(a, b));
    }

    static Stream<Arguments> addOperationTestData() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 2),
                Arguments.of(2, 1, 3),
                Arguments.of(1, 3, 4),
                Arguments.of(-4, 4, 0),
                Arguments.of(-5, -5, -10),
                Arguments.of(-3, 6, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("subtractOperationTestData")
    void subtracting(int a, int b, int expectedSum) {
        Assertions.assertEquals(expectedSum, calculator.subtraction(a, b));
    }

    static Stream<Arguments> subtractOperationTestData() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 0),
                Arguments.of(3, 2, 1),
                Arguments.of(1, 3, -2),
                Arguments.of(-4, 4, -8),
                Arguments.of(-5, -5, 0),
                Arguments.of(-3, 6, -9)
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyOperationTestData")
    void multiplying(int a, int b, int expectedSum) {
        Assertions.assertEquals(expectedSum, calculator.multiplication(a, b));
    }

    static Stream<Arguments> multiplyOperationTestData() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(3, 2, 6),
                Arguments.of(258956, 3, 776868),
                Arguments.of(-4, 4, -16),
                Arguments.of(-5, -5, 25),
                Arguments.of(-3, 6, -18)
        );
    }

    @ParameterizedTest
    @MethodSource("divideOperationTestData")
    void dividing(int a, int b, double expectedSum) {
        Assertions.assertEquals(expectedSum, calculator.division(a, b));
    }

    static Stream<Arguments> divideOperationTestData() {
        return Stream.of(
                Arguments.of(-1, 2, -0.5),
                Arguments.of(1, 1, 1.0),
                Arguments.of(3, 2, 1.5),
                Arguments.of(776868, 3, 258956),
                Arguments.of(-4, 4, -1),
                Arguments.of(-5, -5, 1.0),
                Arguments.of(-3, 6, -0.5)
        );
    }

    @ParameterizedTest
    @MethodSource("divideByZeroOperationTestData")
    void dividing_By_Zero(int a, int b) {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.division(a, b);
        }, "Can't divide by zero");
    }

    static Stream<Arguments> divideByZeroOperationTestData() {
        return Stream.of(
                Arguments.of(3, 0)
        );
    }
}
