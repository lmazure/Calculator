package computer;

public class Logarithm extends JavaMathUnaryOperator {

    public Logarithm(final Operand o1) {
        super(o1, Math::log, "ln(", ")");
    }
}