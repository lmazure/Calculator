package computer;

public class Exponential extends JavaMathUnaryOperator {

    public Exponential(final Operand o1) {
        super(o1, Math::exp, "e^(", ")");
    }
}
