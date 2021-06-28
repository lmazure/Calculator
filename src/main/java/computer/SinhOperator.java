package computer;

public class SinhOperator extends SimpleBracketedUnaryOperator {

    public SinhOperator(final Operand o1) {
        super(o1, Math::sinh, "sinh");
    }
}
