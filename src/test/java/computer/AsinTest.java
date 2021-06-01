package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AsinTest {

    @Test
    void checkValue() {

        // -- arrange
        final double value = 0.3d;
        final Number n1 = new Number(value, "n1");
 
        // -- act
        final Operand effective = new Asin(n1);

        // -- assert
        assertEquals(Math.asin(value), effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(0.3d, "n1");
 
        // -- act
        final Operand effective = new Asin(n1);

        // -- assert
        assertEquals("arcsin(n1)", effective.getDescription());
    }
}