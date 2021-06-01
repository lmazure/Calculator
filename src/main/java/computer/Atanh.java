package computer;

public class Atanh extends JavaMathUnaryOperator {

    public Atanh(final Operand o1) {
        super(o1, Atanh::atanh, "arctanh(", ")");
    }

    private static Double atanh(final Double value) {
        return 0.5d * Math.log((1 + value)/(1 - value));
    }
}
