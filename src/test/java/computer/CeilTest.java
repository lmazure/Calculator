package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CeilTest extends AdderTest {

    @Test
    void checkValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        
        // -- act
        final Operand effective = new CeilOperator(n1);

        // -- assert
        assertEquals(2.0d, effective.getValue(), 0.0001d);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        
        // -- act
        final Operand effective = new CeilOperator(n1);

        // -- assert
        assertEquals("⌈n1⌉", effective.getDescription());
    }
}
