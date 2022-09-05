package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ReportPortalExtension.class)
public class PowerTest {
    @Test
    @SuppressWarnings("static-method")
    void checkValue() {
        // -- arrange
        final Number n1 = new Number(0.3d, "n1");
        final Number n2 = new Number(2d, "n2");

        // -- act
        final double effectiveValue = (new PowerOperator(n1, n2)).getValue();

        // -- assert
        assertEquals(0.09d, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void zeroToNegativeNumberShouldGenerateException() {
        // -- assert
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(0.0d, "n1");
                final Number n2 = new Number(-0.2d, "n2");

                // -- act
                final double effectiveValue = (new PowerOperator(n1, n2)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void zeroPowerZeroShouldGenerateException() {
        // -- assert
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(0.0d, "n1");
                final Number n2 = new Number(0.0d, "n2");

                // -- act
                final double effectiveValue = (new PowerOperator(n1, n2)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void squareRootOfNegativeNumberShouldGenerateException() {
        // -- assert
        assertThrows(ArithmeticException.class,
            ()->{
                // -- arrange
                final Number n1 = new Number(-1.0d, "n1");
                final Number n2 = new Number(0.5d, "n2");

                // -- act
                final double effectiveValue = (new PowerOperator(n1, n2)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {
        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(1.7d, "n2");

        // -- act
        final String effectiveDescription = (new PowerOperator(n1, n2)).getDescription();

        // -- assert
        assertEquals("n1 ^ n2", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {
        // -- arrange
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(1.7d, "n2");

        // -- act
        final String effectiveLatex = (new PowerOperator(n1, n2)).getLatex();

        // -- assert
        assertEquals("{n1}^{n2}", effectiveLatex);
    }
}
