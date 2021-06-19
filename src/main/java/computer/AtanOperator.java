package computer;

public class AtanOperator extends SimpleUnaryOperator {

    public AtanOperator(final Operand o1) {
        super(o1, Math::atan, "arctan(", ")");
    }
}
