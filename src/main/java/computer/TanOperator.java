package computer;

public class TanOperator extends SimpleUnaryOperator {

    public TanOperator(final Operand o1) {
        super(o1, Math::tan, "tan(", ")");
    }
}
