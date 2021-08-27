package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AsinTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final double value = 0.3d;
        final Number n1 = new Number(value, "n1");

        // -- act
        final double effectiveValue = (new AsinOperator(n1)).getValue();

        // -- assert
        assertEquals(Math.asin(value), effectiveValue, 1E-10d);
    }


    @Test
    @SuppressWarnings("static-method")
    void arcsinOfValueLessThanMinusOneShouldThrowException() {

        // -- assert
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(-2.0d, "n1");

                // -- act
                final double effectiveValue = (new AsinOperator(n1)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void arcsinOfValueGreaterOneShouldThrowException() {

        // -- assert
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(2.0d, "n1");

                // -- act
                final double effectiveValue = (new AsinOperator(n1)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(0.3d, "n1");

        // -- act
        final String effectiveDescription = (new AsinOperator(n1)).getDescription();

        // -- assert
        assertEquals("arcsin(n1)", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(0.3d, "n1");

        // -- act
        final String effectiveLatex = (new AsinOperator(n1)).getLatex();

        // -- assert
        assertEquals("arcsin(n1)", effectiveLatex);
    }
}