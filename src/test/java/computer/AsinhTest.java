package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ReportPortalExtension.class)
public class AsinhTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final double value = 1.3d;
        final Number n1 = new Number(value, "n1");

        // -- act
        final double effectiveValue = (new AsinhOperator(n1)).getValue();

        // -- assert
        // Math.asinh does not exist, so we use Math.sinh to check
        assertEquals(value, Math.sinh(effectiveValue), 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveDescription = (new AsinhOperator(n1)).getDescription();

        // -- assert
        assertEquals("arcsinh(n1)", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveLatex = (new AsinhOperator(n1)).getLatex();

        // -- assert
        assertEquals("arcsinh(n1)", effectiveLatex);
    }
}
