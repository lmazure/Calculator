package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CosTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final double value = 1.3d;
        final Number n1 = new Number(value, "n1");

        // -- act
        final Operand effective = new CosOperator(n1);

        // -- assert
        assertEquals(Math.cos(value), effective.getValue(), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new CosOperator(n1);

        // -- assert
        assertEquals("cos(n1)", effective.getDescription());
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new CosOperator(n1);

        // -- assert
        assertEquals("cos(n1)", effective.getLatex());
    }
}
