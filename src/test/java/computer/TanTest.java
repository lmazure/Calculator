package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TanTest {

    @Test
    void checkValue() {

        // -- arrange
        final double value = 1.3d;
        final Number n1 = new Number(value, "n1");
 
        // -- act
        final Operand effective = new Tan(n1);

        // -- assert
        assertEquals(Math.tan(value), effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
 
        // -- act
        final Operand effective = new Tan(n1);

        // -- assert
        assertEquals("tan(n1)", effective.getDescription());
    }
}
