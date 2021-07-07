package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LnTest {

    @Test
    void checkValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new LnOperator(n1);

        // -- assert
        assertEquals(Math.log(1.3d), effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new LnOperator(n1);

        // -- assert
        assertEquals("ln(n1)", effective.getDescription());
    }
}
