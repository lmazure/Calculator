package computer;

public class TanhOperator extends SimpleBracketedUnaryOperator {

    public TanhOperator(final Operand o1) {
        super(o1, Math::tanh, "tanh");
    }
}
