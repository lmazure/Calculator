package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LoopAndRecursionTest {

    @Test
    @SuppressWarnings("static-method")
    void checkDescriptionOfSumOfRecursions() {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(1., "jmin");
        final Number n2 = new Number(10., "jmax");
        final Number n3 = new Number(42., "jnit");
        final RecVarOperator rec = new RecVarOperator(1, stack);
        final VarOperator i = new VarOperator(0, stack);
        final AddOperator add = new AddOperator(i, rec);
        final SubtractOperator sub = new SubtractOperator(i, rec);
        final DivideOperator divide = new DivideOperator(sub, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);
        final Number m1 = new Number(2., "imin");
        final Number m2 = new Number(22., "imax");
        final SumOperator sigma = new SumOperator(m1, m2, recursion, stack);

        // -- act
        final String effectiveDescription = sigma.getDescription();

        // -- assert
        assertEquals("sum for i equal imin to imax of {\n" +
                     "    for j equal jmin to jmax recurse on {\n" +
                     "        (i - recvar 1) / (i + recvar 1)\n" +
                     "    } starting with value jnit for initializing the deepest recursion\n" +
                     "}", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatexOfSumOfRecursions() {

        // -- arrange
        final Stack stack = new Stack();
        final Number n1 = new Number(1., "jmin");
        final Number n2 = new Number(10., "jmax");
        final Number n3 = new Number(42., "jnit");
        final RecVarOperator rec = new RecVarOperator(1, stack);
        final VarOperator i = new VarOperator(0, stack);
        final AddOperator add = new AddOperator(i, rec);
        final SubtractOperator sub = new SubtractOperator(i, rec);
        final DivideOperator divide = new DivideOperator(sub, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);
        final Number m1 = new Number(2., "imin");
        final Number m2 = new Number(22., "imax");
        final SumOperator sigma = new SumOperator(m1, m2, recursion, stack);

        // -- act
        final String effectiveLatex = sigma.getLatex();

        // -- assert
        assertEquals("\\sum\\limits_{i=imin}^{i=imax}\\frac{{i}-\\frac{{i}-\\frac{{i}-\\frac{{i}-\\frac{{i}-...}{{i}+...}}{{i}+\\frac{{i}-...}{{i}+...}}}{{i}+\\frac{{i}-\\frac{{i}-...}{{i}+...}}{{i}+\\frac{{i}-...}{{i}+...}}}}{{i}+\\frac{{i}-\\frac{{i}-\\frac{{i}-...}{{i}+...}}{{i}+\\frac{{i}-...}{{i}+...}}}{{i}+\\frac{{i}-\\frac{{i}-...}{{i}+...}}{{i}+\\frac{{i}-...}{{i}+...}}}}}{{i}+\\frac{{i}-\\frac{{i}-\\frac{{i}-\\frac{{i}-...}{{i}+...}}{{i}+\\frac{{i}-...}{{i}+...}}}{{i}+\\frac{{i}-\\frac{{i}-...}{{i}+...}}{{i}+\\frac{{i}-...}{{i}+...}}}}{{i}+\\frac{{i}-\\frac{{i}-\\frac{{i}-...}{{i}+...}}{{i}+\\frac{{i}-...}{{i}+...}}}{{i}+\\frac{{i}-\\frac{{i}-...}{{i}+...}}{{i}+\\frac{{i}-...}{{i}+...}}}}}", effectiveLatex);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkDescriptionOfRecursionOfSum() {

        // -- arrange
        final Stack stack = new Stack();

        final Number one = new Number(1., "1");
        final VarOperator i = new VarOperator(0, stack);
        final VarOperator j = new VarOperator(1, stack);
        final Number two = new Number(2., "2");
        final PowerOperator square = new PowerOperator(j, two);
        final SumOperator sigma = new SumOperator(one, i, square, stack);

        final Number n1 = new Number(1., "jmin");
        final Number n2 = new Number(10., "jmax");
        final Number n3 = new Number(42., "jnit");
        final RecVarOperator rec = new RecVarOperator(0, stack);
        final AddOperator add = new AddOperator(sigma, rec);
        final SubtractOperator sub = new SubtractOperator(sigma, rec);
        final DivideOperator divide = new DivideOperator(sub, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);

        // -- act
        final String effectiveDescription = recursion.getDescription();

        // -- assert
        assertEquals("for i equal jmin to jmax recurse on {\n" +
                     "    (sum for j equal 1 to i of {\n" +
                     "        j ^ 2\n" +
                     "    } - recvar 0) / (sum for j equal 1 to i of {\n" +
                     "        j ^ 2\n" +
                     "    } + recvar 0)\n" +
                     "} starting with value jnit for initializing the deepest recursion", effectiveDescription);
    }

    @Test
    @SuppressWarnings("static-method")
    void checkLatexOfRecursionOfSum() {

        // -- arrange
        final Stack stack = new Stack();

        final Number one = new Number(1., "1");
        final VarOperator i = new VarOperator(0, stack);
        final VarOperator j = new VarOperator(1, stack);
        final Number two = new Number(2., "2");
        final PowerOperator square = new PowerOperator(j, two);
        final SumOperator sigma = new SumOperator(one, i, square, stack);

        final Number n1 = new Number(1., "jmin");
        final Number n2 = new Number(10., "jmax");
        final Number n3 = new Number(42., "jnit");
        final RecVarOperator rec = new RecVarOperator(0, stack);
        final AddOperator add = new AddOperator(sigma, rec);
        final SubtractOperator sub = new SubtractOperator(sigma, rec);
        final DivideOperator divide = new DivideOperator(sub, add);
        final RecursionOperator recursion = new RecursionOperator(n1, n2, n3, divide, stack);

        // -- act
        final String effectiveLatex = recursion.getLatex();

        // -- assert
        assertEquals("\\frac{\\sum\\limits_{j=1}^{j=1}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=2}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=3}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}}{\\sum\\limits_{j=1}^{j=3}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}}}{\\sum\\limits_{j=1}^{j=2}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=3}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}}{\\sum\\limits_{j=1}^{j=3}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}}}}{\\sum\\limits_{j=1}^{j=1}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=2}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=3}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}}{\\sum\\limits_{j=1}^{j=3}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}}}{\\sum\\limits_{j=1}^{j=2}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=3}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}}{\\sum\\limits_{j=1}^{j=3}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)-\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}{\\sum\\limits_{j=1}^{j=4}\\left({j}^{2}\\right)+\\frac{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)-...}{\\sum\\limits_{j=1}^{j=5}\\left({j}^{2}\\right)+...}}}}}", effectiveLatex);
    }
}
