package computer;

public class Asinh extends JavaMathUnaryOperator {

    public Asinh(final Operand o1) {
        super(o1, Asinh::asinh, "arcsinh(", ")");
    }

    private static Double asinh(final Double value) {
        return Math.log(value + Math.sqrt(value * value + 1));
    }
}
