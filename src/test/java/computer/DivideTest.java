package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DivideTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {
        // -- arrange
        final Number n1 = new Number(2.0d, "n1");
        final Number n2 = new Number(0.3d, "n2");

        // -- act
        final double effectiveValue = (new DivideOperator(n1, n2)).getValue();

        // -- assert
        assertEquals(6.66666666666666666667d, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void divisionByZeroShouldGenerateException() {
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(1.0d, "n1");
                final Number n2 = new Number(0.0d, "n2");

                // -- act
                final Operand effective = new DivideOperator(n1, n2);

                // -- assert
                System.out.println("result = " + effective.getValue());
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void zeroDividedByZeroShouldGenerateException() {
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(0.0d, "n1");
                final Number n2 = new Number(0.0d, "n2");

                // -- act
                final Operand effective = new DivideOperator(n1, n2);

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
        final String effectiveDescription = (new DivideOperator(n1, n2)).getDescription();

        // -- assert
        assertEquals("n1 / n2", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {
        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(1.7d, "n2");

        // -- act
        final String effectiveLatex = (new DivideOperator(n1, n2)).getLatex();

        // -- assert
        assertEquals("\\frac{n1}{n2}", effectiveLatex);
    }
}
