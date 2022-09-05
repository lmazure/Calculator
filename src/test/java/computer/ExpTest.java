package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ReportPortalExtension.class)
public class ExpTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final double effectiveValue = (new ExpOperator(n1)).getValue();

        // -- assert
        assertEquals(Math.exp(1.3d), effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveDescription = (new ExpOperator(n1)).getDescription();

        // -- assert
        assertEquals("e^n1", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");

        // -- act
        final String effectiveLatex = (new ExpOperator(n1)).getLatex();

        // -- assert
        assertEquals("e^n1", effectiveLatex);
    }
}
