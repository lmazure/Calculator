package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AbsTest {

    @ParameterizedTest
    @CsvSource({
        "1.3,1.3,positive",
        "0.0,0.0,zero",
        "-1.3,1.3,negative",
        })
    void checkValue(final String input,
                    final String expectedResult,
                    final String description) {

        final double inputValue = Double.parseDouble(input);
        final double expectedRes = Double.parseDouble(expectedResult);

        // -- arrange
        final Number n1 = new Number(inputValue, "n1");

        // -- act
        final Operand effective = new AbsOperator(n1);

        // -- assert
        assertEquals(expectedRes, effective.getValue(), 0.0001d, "Failure for " + description);
    }

    @Test
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final Operand effective = new AbsOperator(n1);

        // -- assert
        assertEquals("|n1|", effective.getDescription());
    }}
