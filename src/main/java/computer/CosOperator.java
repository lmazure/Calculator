package computer;

public class CosOperator extends SimpleUnaryOperator {

    public CosOperator(final Operand o1) {
        super(o1, Math::cos, "cos(", ")");
    }
}