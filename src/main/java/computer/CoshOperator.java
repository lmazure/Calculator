package computer;

public class CoshOperator extends SimpleBracketedUnaryOperator {

    public CoshOperator(final Operand o1) {
        super(o1, Math::cosh, "cosh");
    }
}
