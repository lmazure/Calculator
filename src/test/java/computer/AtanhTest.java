package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AtanhTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final double value = 0.3d;
        final Number n1 = new Number(value, "n1");

        // -- act
        final double effectiveValue = (new AtanhOperator(n1)).getValue();

        // -- assert
        // Math.tanh does not exist, so we use Math.tanh to cjeck
        assertEquals(value, Math.tanh(effectiveValue), 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(0.3d, "n1");

        // -- act
        final String effectiveDescription = (new AtanhOperator(n1)).getDescription();

        // -- assert
        assertEquals("arctanh(n1)", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(0.3d, "n1");

        // -- act
        final String effectiveLatex = (new AtanhOperator(n1)).getLatex();

        // -- assert
        assertEquals("arctanh(n1)", effectiveLatex);
    }
}
