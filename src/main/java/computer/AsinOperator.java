package computer;

public class AsinOperator extends SimpleBracketedUnaryOperator {

    public AsinOperator(final Operand o1) {
        super(o1, Math::asin, "arcsin");
    }
}
