package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PowerTest {
    @Test
    void checkValue() {
        // -- arrange
        final Number n1 = new Number(0.3d, "n1");
        final Number n2 = new Number(2d, "n2");

        // -- act
        final Operand effective = new PowerOperator(n1, n2);

        // -- assert
        assertEquals(0.09d, effective.getValue(), 0.0001d);
    }

    @Test
    void checkDivisionByZero() {
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(0.0d, "n1");
                final Number n2 = new Number(-0.2d, "n2");

                // -- act
                final Operand effective = new PowerOperator(n1, n2);

                // -- assert
                System.out.println("result = " + effective.getValue());
            });
    }

    @Test
    void checkDescription() {
        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(1.7d, "n2");

        // -- act
        final Operand effective = new PowerOperator(n1, n2);

        // -- assert
        assertEquals("(n1) ^ (n2)", effective.getDescription());
    }
}