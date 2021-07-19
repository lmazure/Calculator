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
        final Operand effective = new AtanhOperator(n1);

        // -- assert
        // Math.tanh does not exist, so we use Math.tanh to cjeck
        assertEquals(value, Math.tanh(effective.getValue()), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(0.3d, "n1");

        // -- act
        final Operand effective = new AtanhOperator(n1);

        // -- assert
        assertEquals("arctanh(n1)", effective.getDescription());
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(0.3d, "n1");

        // -- act
        final Operand effective = new AtanhOperator(n1);

        // -- assert
        assertEquals("arctanh(n1)", effective.getLatex());
    }
}
