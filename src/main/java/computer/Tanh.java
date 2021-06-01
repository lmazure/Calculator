package computer;

public class Tanh extends JavaMathUnaryOperator {

    public Tanh(final Operand o1) {
        super(o1, Math::tanh, "tanh(", ")");
    }
}
