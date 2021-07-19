package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PiTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange

        // -- act
        final PiOperator effective = new PiOperator();

        // -- assert
        assertEquals(3.141592653589793d, effective.getValue(), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange

        // -- act
        final PiOperator effective = new PiOperator();

        // -- assert
        assertEquals("π", effective.getDescription());
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange

        // -- act
        final PiOperator effective = new PiOperator();

        // -- assert
        assertEquals("\\pi", effective.getLatex());
    }
}
