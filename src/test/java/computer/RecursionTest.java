package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RecursionTest {

    @ParameterizedTest
    @CsvSource({
        "1.,1.,0.,1.",
        "1.,1.,3.,0.25",
        "1.,2.,0.,0.5",
        "1.,2.,2.,0.75",
        "1.,4.,0.,0.6",
        "1.,4.,5.,0.65",
        })
    @SuppressWarnings("static-method")
    void checkValueOneDividedByOnePlusX(final String imin,
                                        final String imax,
                                        final String initialRecursionValue,
                                        final String expectedResult) {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(Double.parseDouble(imin), "imin");
        final Number n2 = new Number(Double.parseDouble(imax), "imax");
        final Number n3 = new Number(Double.parseDouble(initialRecursionValue), "init");
        final RecVarOperator rec = new RecVarOperator(0, stack);
        final Number one = new Number(1d, "1");
        final AddOperator add = new AddOperator(one, rec);
        final DivideOperator divide = new DivideOperator(one, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);

        // -- act
        final double effectiveValue = recursion.getValue();

        // -- assert
        assertEquals(Double.parseDouble(expectedResult), effectiveValue, 1E-10d);
    }

    @ParameterizedTest
    @CsvSource({
        "1.,1.,0.,1.",
        "1.,1.,3.,0.25",
        "1.,2.,0.,0.666666666666666666",
        "1.,2.,2.,0.8",
        "1.,4.,0.,0.6976744186046512",
        "1.,4.,0.5,0.69791666666666666666666",
        })
    @SuppressWarnings("static-method")
    void checkValueOneDividedByIPlusX(final String imin,
                                      final String imax,
                                      final String initialRecursionValue,
                                      final String expectedResult) {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(Double.parseDouble(imin), "imin");
        final Number n2 = new Number(Double.parseDouble(imax), "imax");
        final Number n3 = new Number(Double.parseDouble(initialRecursionValue), "init");
        final RecVarOperator rec = new RecVarOperator(0, stack);
        final VarOperator i = new VarOperator(0, stack);
        final Number one = new Number(1d, "1");
        final AddOperator add = new AddOperator(i, rec);
        final DivideOperator divide = new DivideOperator(one, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);

        // -- act
        final double effectiveValue = recursion.getValue();

        // -- assert
        assertEquals(Double.parseDouble(expectedResult), effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void noRecursionShouldGiveInitialValue() {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(19.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final Number n3 = new Number(12345.d, "n3");
        final RecVarOperator rec = new RecVarOperator(0, stack);
        final Number one = new Number(1d, "1");
        final AddOperator add = new AddOperator(one, rec);
        final DivideOperator divide = new DivideOperator(one, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);

        // -- act
        final double effectiveValue = recursion.getValue();

        // -- assert
        assertEquals(12345.d, effectiveValue, 1E-10d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescriptionOfOneDividedByOnePlusX() {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(1., "imin");
        final Number n2 = new Number(2., "imax");
        final Number n3 = new Number(42., "init");
        final RecVarOperator rec = new RecVarOperator(0, stack);
        final VarOperator i = new VarOperator(0, stack);
        final Number one = new Number(1d, "1");
        final AddOperator add = new AddOperator(i, rec);
        final DivideOperator divide = new DivideOperator(one, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);

        // -- act
        final String effectiveDescription = recursion.getDescription();

        // -- assert
        assertEquals("for i equal imin to imax recurse on {\n" +
                     "    1 / (i + recvar 0)\n" +
                     "} starting with value init for initializing the deepest recursion", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescriptionOfOneDividedByIPlusX() {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(1., "imin");
        final Number n2 = new Number(2., "imax");
        final Number n3 = new Number(42., "init");
        final RecVarOperator rec = new RecVarOperator(0, stack);
        final VarOperator i = new VarOperator(0, stack);
        final Number one = new Number(1d, "1");
        final AddOperator add = new AddOperator(i, rec);
        final DivideOperator divide = new DivideOperator(one, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);

        // -- act
        final String effectiveDescription = recursion.getDescription();

        // -- assert
        assertEquals("for i equal imin to imax recurse on {\n" +
                     "    1 / (i + recvar 0)\n" +
                     "} starting with value init for initializing the deepest recursion", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescriptionOfNestedProducts() {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(-2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final Number n3 = new Number(19.d, "n3");
        final Number n4 = new Number(7.d, "n4");
        final VarOperator n5 = new VarOperator(1, stack);

        // -- act
        final Operand n6 = new SumOperator(n3, n4, n5, stack);
        final String effectiveDescription = (new ProductOperator(n1, n2, n6, stack)).getDescription();

        // -- assert
        assertEquals("product for i equal n1 to n2 of {\n    sum for j equal n3 to n4 of {\n        j\n    }\n}", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatex() {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(-2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final VarOperator n3 = new VarOperator(0, stack);

        // -- act
        final String effectiveLatex = (new ProductOperator(n1, n2, n3, stack)).getLatex();

        // -- assert
        assertEquals("\\prod\\limits_{i=n1}^{i=n2}i", effectiveLatex);
    }
}
