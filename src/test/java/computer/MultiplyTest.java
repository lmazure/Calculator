package computer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ReportPortalExtension.class)
public class MultiplyTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");

        // -- act
        final double effectiveValue = (new MultiplyOperator(n1, n2)).getValue();

        // -- assert
        assertEquals(0.91d, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");

        // -- act
        final String effectiveDescription = (new MultiplyOperator(n1, n2)).getDescription();

        // -- assert
        assertEquals("n1 * n2", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");

        // -- act
        final String effectiveLatex = (new MultiplyOperator(n1, n2)).getLatex();

        // -- assert
        assertEquals("{n1}\\times{n2}", effectiveLatex);
    }
}
