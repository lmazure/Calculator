package computer;

public class TanhOperator extends SimpleUnaryOperator {

    public TanhOperator(final Operand o1) {
        super(o1, Math::tanh, "tanh(", ")");
    }
}
