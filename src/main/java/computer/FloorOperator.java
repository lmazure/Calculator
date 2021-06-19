package computer;

public class FloorOperator extends SimpleUnaryOperator {

    public FloorOperator(final Operand o1) {
        super(o1, Math::floor, "⌊", "⌋");
    }
}
