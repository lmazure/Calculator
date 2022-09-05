package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ReportPortalExtension.class)
public class AbsTest {

    @ParameterizedTest
    @CsvSource({
        "1.3,1.3,positive",
        "0.0,0.0,zero",
        "-1.3,1.3,negative",
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
        final double effectiveValue = (new AbsOperator(n1)).getValue();

        // -- assert
        assertEquals(expectedRes, effectiveValue, 1E-10d, "Failure for " + description);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveDescription = (new AbsOperator(n1)).getDescription();

        // -- assert
        assertEquals("|n1|", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveLatex = (new AbsOperator(n1)).getLatex();

        // -- assert
        assertEquals("\\abs*{n1}", effectiveLatex);
    }
}
