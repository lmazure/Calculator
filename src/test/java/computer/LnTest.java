package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LnTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final double effectiveValue = (new LnOperator(n1)).getValue();

        // -- assert
        assertEquals(Math.log(1.3d), effectiveValue, 1E-10d);
    }


    @Test
    @SuppressWarnings("static-method")
    void negativeValueShouldGenerateException() {

        // -- assert
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(-1.69d, "n1");

                // -- act
                final double effectiveValue = (new LnOperator(n1)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void nulValueShouldGenerateException() {

        // -- assert
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(0.0d, "n1");

                // -- act
                final double effectiveValue = (new LnOperator(n1)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveDescription = (new LnOperator(n1)).getDescription();

        // -- assert
        assertEquals("ln(n1)", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveLatex = (new LnOperator(n1)).getLatex();

        // -- assert
        assertEquals("ln(n1)", effectiveLatex);
    }
}
