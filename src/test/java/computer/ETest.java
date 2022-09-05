package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ReportPortalExtension.class)
public class ETest {

    @Test
    @SuppressWarnings("static-method")
    void checkValue() {

        // -- arrange

        // -- act
        final double effectiveValue = (new EOperator()).getValue();

        // -- assert
        assertEquals(Math.E, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange

        // -- act
        final String effectiveDescription = (new EOperator()).getDescription();

        // -- assert
        assertEquals("e", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange

        // -- act
        final String effectiveLatex = (new EOperator()).getLatex();

        // -- assert
        assertEquals("e", effectiveLatex);
    }
}
