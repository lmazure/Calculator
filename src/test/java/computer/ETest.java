package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ETest {

    @Test
    void checkValue() {

        // -- arrange

        // -- act
        final EOperator effective = new EOperator();

        // -- assert
        assertEquals(2.718281828459045d, effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange

        // -- act
        final EOperator effective = new EOperator();

        // -- assert
        assertEquals("e", effective.getDescription());
    }
}
