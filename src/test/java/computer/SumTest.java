package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SumTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValueForIntegerMixMax() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(-2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final Number n3 = new Number(1.5d, "n3");

        // -- act
        final double effectiveValue = (new SumOperator(n1, n2, n3, incrementStack)).getValue();

        // -- assert
        assertEquals(15.d, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkValueForFloatMixMax() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(-2.3d, "n1");
        final Number n2 = new Number(7.4d, "n2");
        final Number n3 = new Number(1.5d, "n3");

        // -- act
        final double effectiveValue = (new SumOperator(n1, n2, n3, incrementStack)).getValue();

        // -- assert
        assertEquals(15.d, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkValueForSummedVariable() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(-2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final VarOperator n3 = new VarOperator(0, incrementStack);

        // -- act
        final double effectiveValue = (new SumOperator(n1, n2, n3, incrementStack)).getValue();

        // -- assert
        assertEquals(25.d, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void invalidBoundariesShouldGenerateException() {
        // -- assert
        assertThrows(BadBoundsException.class,
            ()->{
                // -- arrange
                final IncrementStack incrementStack = new IncrementStack();
                final Number n1 = new Number(19.d, "n1");
                final Number n2 = new Number(7.d, "n2");
                final VarOperator n3 = new VarOperator(0, incrementStack);

                // -- act
                final double effectiveValue = (new SumOperator(n1, n2, n3, incrementStack)).getValue();
                System.out.println("result = " + effectiveValue);
            });
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescription() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(-2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final VarOperator n3 = new VarOperator(0, incrementStack);

        // -- act
        final String effectiveDescription = (new SumOperator(n1, n2, n3, incrementStack)).getDescription();

        // -- assert
        assertEquals("sum for i equal n1 to n2 of {\n    i\n}", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescriptionOfNestedSums() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(-2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final Number n3 = new Number(19.d, "n3");
        final Number n4 = new Number(7.d, "n4");
        final VarOperator n5 = new VarOperator(1, incrementStack);

        // -- act
        final Operand n6 = new SumOperator(n3, n4, n5, incrementStack);
        final String effectiveDescription = (new SumOperator(n1, n2, n6, incrementStack)).getDescription();

        // -- assert
        assertEquals("sum for i equal n1 to n2 of {\n    sum for j equal n3 to n4 of {\n        j\n    }\n}", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(-2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final VarOperator n3 = new VarOperator(0, incrementStack);

        // -- act
        final String effectiveLatex = (new SumOperator(n1, n2, n3, incrementStack)).getLatex();

        // -- assert
        assertEquals("\\sum\\limits_{i=n1}^{i=n2}i", effectiveLatex);
    }
}
