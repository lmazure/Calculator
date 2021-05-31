package computer;

public class FloorOperator extends JavaMathUnaryOperator {

    protected FloorOperator(final Operand o1) {
        super(o1, Math::floor, "⌊", "⌋");
    }
}
