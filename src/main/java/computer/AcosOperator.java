package computer;

public class AcosOperator extends SimpleUnaryOperator {

    public AcosOperator(final Operand o1) {
        super(o1, Math::acos, "arccos(", ")");
    }
}
