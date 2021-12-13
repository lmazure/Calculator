package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AcoshTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final double value = 1.3d;
        final Number n1 = new Number(value, "n1");

        // -- act
        final double effectiveValue = (new AcoshOperator(n1)).getValue();

        // -- assert
        // Math.acosh does not exist, so we use Math.cosh to check
        assertEquals(value, Math.cosh(effectiveValue), 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void arccoshOfValueLessThanOneShouldThrowException() {

        // -- assert
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(0.5d, "n1");

                // -- act
                final double effectiveValue = (new AcoshOperator(n1)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }
    
    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveDescription = (new AcoshOperator(n1)).getDescription();

        // -- assert
        assertEquals("arccosh(n1)", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveLatex = (new AcoshOperator(n1)).getLatex();

        // -- assert
        assertEquals("arccosh(n1)", effectiveLatex);
    }
}
