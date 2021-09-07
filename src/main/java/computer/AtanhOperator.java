package computer;

public class AtanhOperator extends SimpleBracketedUnaryOperator {

    public AtanhOperator(final Operand o1) {
        super(o1, AtanhOperator::atanh, "arctanh");
    }

    private static double atanh(final double value) {
        return 0.5d * Math.log((1 + value)/(1 - value));
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its inverse hyperbolic tangent on the stack"; 
    }
}
