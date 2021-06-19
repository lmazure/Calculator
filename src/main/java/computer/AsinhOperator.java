package computer;

public class AsinhOperator extends SimpleUnaryOperator {

    public AsinhOperator(final Operand o1) {
        super(o1, AsinhOperator::asinh, "arcsinh(", ")");
    }

    private static Double asinh(final Double value) {
        return Math.log(value + Math.sqrt(value * value + 1));
    }
}
