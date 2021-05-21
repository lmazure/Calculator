package computer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplierTest {

    @Test
    void basicMultiplication() {

        // -- arrange
    	final Multiplier multiplier = new Multiplier();
        final Number n1 = new Number(1.3d);
        final Number n2 = new Number(0.7d);
        final Number expected = new Number(0.91d);
        
        // -- act
        final Number effective = multiplier.operate(n1, n2);

        // -- assert
        assertTrue(Number.approximateEquals(expected, effective));
    }
}
