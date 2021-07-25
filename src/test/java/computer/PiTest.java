package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PiTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange

        // -- act
        final double effectiveValue = (new PiOperator()).getValue();

        // -- assert
        assertEquals(Math.PI, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange

        // -- act
        final String effectiveDescription = (new PiOperator()).getDescription();

        // -- assert
        assertEquals("π", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange

        // -- act
        final String effectiveLatex = (new PiOperator()).getLatex();

        // -- assert
        assertEquals("\\pi", effectiveLatex);
    }
}
