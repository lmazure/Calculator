package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AtanTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final double value = 1.3d;
        final Number n1 = new Number(value, "n1");

        // -- act
        final double effectiveValue = (new AtanOperator(n1)).getValue();

        // -- assert
        assertEquals(Math.atan(value), effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveDescription = (new AtanOperator(n1)).getDescription();

        // -- assert
        assertEquals("arctan(n1)", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveLatex = (new AtanOperator(n1)).getLatex();

        // -- assert
        assertEquals("arctan(n1)", effectiveLatex);
    }
}
