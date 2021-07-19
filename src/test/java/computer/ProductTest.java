package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    @SuppressWarnings("static-method")
    void checkValueForIntegerMixMax() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final Number n3 = new Number(1.5d, "n3");

        // -- act
        final Operand effective = new ProductOperator(n1, n2, n3, incrementStack);

        // -- assert
        assertEquals(11.390625d, effective.getValue(), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkValueForFloatMixMax() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(2.3d, "n1");
        final Number n2 = new Number(7.4d, "n2");
        final Number n3 = new Number(1.5d, "n3");

        // -- act
        final Operand effective = new ProductOperator(n1, n2, n3, incrementStack);

        // -- assert
        assertEquals(11.390625d, effective.getValue(), 0.0001d);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkValueForMultipliedVariable() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(3.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final VarOperator n3 = new VarOperator(0, incrementStack);

        // -- act
        final Operand effective = new ProductOperator(n1, n2, n3, incrementStack);

        // -- assert
        assertEquals(2520.d, effective.getValue(), 0.0001d);
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
        final Operand effective = new ProductOperator(n1, n2, n3, incrementStack);

        // -- assert
        assertEquals("product for i equal n1 to n2 of {\n    i\n}", effective.getDescription());
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescriptionOfNestedProducts() {

        // -- arrange
        final IncrementStack incrementStack = new IncrementStack();
        final Number n1 = new Number(-2.d, "n1");
        final Number n2 = new Number(7.d, "n2");
        final Number n3 = new Number(19.d, "n3");
        final Number n4 = new Number(7.d, "n4");
        final VarOperator n5 = new VarOperator(1, incrementStack);

        // -- act
        final Operand n6 = new SumOperator(n3, n4, n5, incrementStack);
        final Operand effective = new ProductOperator(n1, n2, n6, incrementStack);

        // -- assert
        assertEquals("product for i equal n1 to n2 of {\n    sum for j equal n3 to n4 of {\n        j\n    }\n}", effective.getDescription());
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
        final Operand effective = new ProductOperator(n1, n2, n3, incrementStack);

        // -- assert
        assertEquals("\\prod\\limits_{i=n1}^{i=n2}i", effective.getLatex());
    }
}
