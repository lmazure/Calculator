package computer;

public class AtanOperator extends SimpleBracketedUnaryOperator {

    public AtanOperator(final Operand o1) {
        super(o1, Math::atan, "arctan");
    }
}
