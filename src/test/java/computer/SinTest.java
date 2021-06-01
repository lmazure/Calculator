package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SinTest {

    @Test
    void checkValue() {

        // -- arrange
        final double value = 1.3d;
        final Number n1 = new Number(value, "n1");
 
        // -- act
        final Operand effective = new Sin(n1);

        // -- assert
        assertEquals(Math.sin(value), effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
 
        // -- act
        final Operand effective = new Sin(n1);

        // -- assert
        assertEquals("sin(n1)", effective.getDescription());
    }
}