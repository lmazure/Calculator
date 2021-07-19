package computer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

 public class MultiplyTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");

        // -- act
        final Operand effective = new MultiplyOperator(n1, n2);

        // -- assert
        assertEquals(0.91d, effective.getValue(), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");

        // -- act
        final Operand effective = new MultiplyOperator(n1, n2);

        // -- assert
        assertEquals("n1 * n2", effective.getDescription());
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");

        // -- act
        final Operand effective = new MultiplyOperator(n1, n2);

        // -- assert
        assertEquals("n1\\timesn2", effective.getLatex());
    }
}
