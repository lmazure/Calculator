package computer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdderTest {

    @Test
    void basicAddition() {

        // -- arrange
    	final Adder adder = new Adder();
        final Number n1 = new Number(1.3d);
        final Number n2 = new Number(0.7d);
        final Number expected = new Number(2.0d);
        
        // -- act
        final Number effective = adder.operate(n1, n2);

        // -- assert
        assertTrue(Number.approximateEquals(expected, effective));
    }
}
