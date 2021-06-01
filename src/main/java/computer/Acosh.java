package computer;

public class Acosh extends JavaMathUnaryOperator {

    public Acosh(final Operand o1) {
        super(o1, Acosh::acosh, "arccosh(", ")");
    }

    private static Double acosh(final Double value) {
        return Math.log(value + Math.sqrt(value * value - 1));
    }
}
