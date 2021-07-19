package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ModTest {
    @Test
    @SuppressWarnings("static-method")
    void checkValue() {
        // -- arrange
        final Number n1 = new Number(2.0d, "n1");
        final Number n2 = new Number(0.3d, "n2");

        // -- act
        final Operand effective = new ModOperator(n1, n2);

        // -- assert
        assertEquals(0.2d, effective.getValue(), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkModuloZero() {
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(1.0d, "n1");
                final Number n2 = new Number(0.0d, "n2");

                // -- act
                final Operand effective = new ModOperator(n1, n2);

                // -- assert
                System.out.println("result = " + effective.getValue());
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void checkZeroModuloZero() {
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(0.0d, "n1");
                final Number n2 = new Number(0.0d, "n2");

                // -- act
                final Operand effective = new ModOperator(n1, n2);

                // -- assert
                System.out.println("result = " + effective.getValue());
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {
        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(1.7d, "n2");

        // -- act
        final Operand effective = new ModOperator(n1, n2);

        // -- assert
        assertEquals("n1 % n2", effective.getDescription());
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {
        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(1.7d, "n2");

        // -- act
        final Operand effective = new ModOperator(n1, n2);

        // -- assert
        assertEquals("n1\\modn2", effective.getLatex());
    }
}
