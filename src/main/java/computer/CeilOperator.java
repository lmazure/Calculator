package computer;

public class CeilOperator extends SimpleUnaryOperator {

    public CeilOperator(final Operand o1) {
        super(o1, Math::ceil, "⌈", "⌉");
    }
}
