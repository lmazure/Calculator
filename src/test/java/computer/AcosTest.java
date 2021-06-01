package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AcosTest {

    @Test
    void checkValue() {

        // -- arrange
        final double value = 0.3d;
        final Number n1 = new Number(value, "n1");
 
        // -- act
        final Operand effective = new Acos(n1);

        // -- assert
        assertEquals(Math.acos(value), effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(0.3d, "n1");
 
        // -- act
        final Operand effective = new Acos(n1);

        // -- assert
        assertEquals("arccos(n1)", effective.getDescription());
    }
}
