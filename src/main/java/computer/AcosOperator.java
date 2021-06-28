package computer;

public class AcosOperator extends SimpleBracketedUnaryOperator {

    public AcosOperator(final Operand o1) {
        super(o1, Math::acos, "arccos");
    }
}
