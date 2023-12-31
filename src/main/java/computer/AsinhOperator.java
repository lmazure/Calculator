package computer;

public class AsinhOperator extends SimpleBracketedUnaryOperator {

    public AsinhOperator(final Operand o1) {
        super(o1, AsinhOperator::asinh, "arcsinh");
    }

    private static double asinh(final double value) {
        return Math.log(value + Math.sqrt(value * value + 1));
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its inverse hyperbolic sine on the stack";
    }
}
