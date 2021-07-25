package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CeilTest {

    @ParameterizedTest
    @CsvSource({
        "0.0,0.0,zero",
        "7.0,7.0,positive integer",
        "-13.0,-13.0,negative integer",
        "1.2,2.0,positive just above an integer",
        "1.9,2.0,positive just below an integer",
        "-1.2,-1.0,negative just above an integer",
        "-1.9,-1.0,negative just below an integer",
        })
    @SuppressWarnings("static-method")
    void checkValue(final String input,
                    final String expectedResult,
                    final String description) {

        final double inputValue = Double.parseDouble(input);
        final double expectedRes = Double.parseDouble(expectedResult);

        // -- arrange
        final Number n1 = new Number(inputValue, "n1");

        // -- act
        final double effectiveValue = (new CeilOperator(n1)).getValue();

        // -- assert
        assertEquals(expectedRes, effectiveValue, 1E-10d, "Failure for " + description);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveDescription = (new CeilOperator(n1)).getDescription();

        // -- assert
        assertEquals("⌈n1⌉", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveLatex = (new CeilOperator(n1)).getLatex();

        // -- assert
        assertEquals("\\lceil{n1}\\rceil", effectiveLatex);
    }
}
