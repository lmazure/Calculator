package computer;

public class SinhOperator extends SimpleUnaryOperator {

    public SinhOperator(final Operand o1) {
        super(o1, Math::sinh, "sinh(", ")");
    }
}
