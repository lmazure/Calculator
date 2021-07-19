package computer;

public class AsinhOperator extends SimpleBracketedUnaryOperator {

    public AsinhOperator(final Operand o1) {
        super(o1, AsinhOperator::asinh, "arcsinh");
    }

    private static double asinh(final double value) {
        return Math.log(value + Math.sqrt(value * value + 1));
    }
}
