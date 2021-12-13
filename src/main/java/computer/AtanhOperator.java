package computer;

public class AtanhOperator extends SimpleBracketedUnaryOperator {

    public AtanhOperator(final Operand o1) {
        super(o1, AtanhOperator::atanh, "arctanh");
    }

    private static double atanh(final double value) {
        if (value < -1.0d) {
            throw new ArithmeticException("atanh of a value smaller than -1");
        }
        if (value > 1.0d) {
            throw new ArithmeticException("atanh of a value greater than 1");
        }
        return 0.5d * Math.log((1 + value)/(1 - value));
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its inverse hyperbolic tangent on the stack";
    }
}
