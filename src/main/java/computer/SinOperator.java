package computer;

public class SinOperator extends SimpleBracketedUnaryOperator {

    public SinOperator(final Operand o1) {
        super(o1, Math::sin, "sin");
    }
}
