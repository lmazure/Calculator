package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RandTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        RandOperator.setSeed(0);

        // -- act
        final RandOperator effective = new RandOperator();

        // -- assert
        assertEquals(0.730967787376657d, effective.getValue(), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange

        // -- act
        final RandOperator effective = new RandOperator();

        // -- assert
        assertEquals("rand()", effective.getDescription());
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange

        // -- act
        final RandOperator effective = new RandOperator();

        // -- assert
        assertEquals("rand()", effective.getLatex());
    }
}
