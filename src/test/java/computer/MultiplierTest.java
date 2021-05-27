package computer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplierTest {

    @Test
    void checkValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");

        // -- act
        final Operand effective = new Multiplier(n1, n2);

        // -- assert
        assertEquals(0.91d, effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");

        // -- act
        final Operand effective = new Multiplier(n1, n2);

        // -- assert
        assertEquals("(n1) * (n2)", effective.getDescription());
    }}
