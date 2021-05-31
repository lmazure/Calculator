package computer;

public class Cos extends JavaMathUnaryOperator {

    public Cos(final Operand o1) {
        super(o1, Math::cos, "cos(", ")");
    }
}
