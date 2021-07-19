package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExpTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new ExpOperator(n1);

        // -- assert
        assertEquals(Math.exp(1.3d), effective.getValue(), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new ExpOperator(n1);

        // -- assert
        assertEquals("e^n1", effective.getDescription());
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new ExpOperator(n1);

        // -- assert
        assertEquals("e^n1", effective.getLatex());
    }
}
