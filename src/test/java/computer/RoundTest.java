package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoundTest {


    @ParameterizedTest
    @CsvSource({
        "0.0,0.0,zero",
        "7.0,7.0,positive integer",
        "-13.0,-13.0,negative integer",
        "1.2,1.0,positive just above an integer",
        "1.9,2.0,positive just below an integer",
        "-1.2,-1.0,negative just above an integer",
        "-1.9,-2.0,negative just below an integer",
        })
    void checkValue(final String input,
                    final String expectedResult,
                    final String description) {

        final double inputValue = Double.parseDouble(input);
        final double expectedRes = Double.parseDouble(expectedResult);

        // -- arrange
        final Number n1 = new Number(inputValue, "n1");

        // -- act
        final Operand effective = new RoundOperator(n1);

        // -- assert
        assertEquals(expectedRes, effective.getValue(), 0.0001d, "Failure for " + description);
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
