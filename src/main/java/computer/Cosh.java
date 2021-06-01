package computer;

public class Cosh extends JavaMathUnaryOperator {

    public Cosh(final Operand o1) {
        super(o1, Math::cosh, "cosh(", ")");
    }
}
