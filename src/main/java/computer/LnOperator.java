package computer;

public class LnOperator extends SimpleBracketedUnaryOperator {

    public LnOperator(final Operand o1) {
        super(o1, Math::log, "ln");
    }
}