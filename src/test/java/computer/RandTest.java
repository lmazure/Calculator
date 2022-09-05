package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ReportPortalExtension.class)
public class RandTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange
        RandOperator.setSeed(0);

        // -- act
        final double effectiveValue = (new RandOperator()).getValue();

        // -- assert
        assertEquals(0.730967787376657d, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange

        // -- act
        final String effectiveDescription = (new RandOperator()).getDescription();

        // -- assert
        assertEquals("rand()", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange

        // -- act
        final String effectiveLatex = (new RandOperator()).getLatex();

        // -- assert
        assertEquals("rand()", effectiveLatex);
    }
}
