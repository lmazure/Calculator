package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RoundTest {


    @Test
    void checkRoundedDownValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new RoundOperator(n1);

        // -- assert
        assertEquals(1.0d, effective.getValue(), 0.0001d);
    }

    @Test
    void checkRoundedUpValue() {

        // -- arrange
        final Number n1 = new Number(1.7d, "n1");

        // -- act
        final Operand effective = new RoundOperator(n1);

        // -- assert
        assertEquals(2.0d, effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new RoundOperator(n1);

        // -- assert
        assertEquals("[n1]", effective.getDescription());
    }
}
