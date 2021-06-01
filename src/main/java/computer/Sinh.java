package computer;

public class Sinh extends JavaMathUnaryOperator {

    public Sinh(final Operand o1) {
        super(o1, Math::sinh, "sinh(", ")");
    }
}
