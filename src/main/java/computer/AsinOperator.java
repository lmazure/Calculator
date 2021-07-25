package computer;

public class AsinOperator extends SimpleBracketedUnaryOperator {

    public AsinOperator(final Operand o1) {
        super(o1, Math::asin, "arcsin");
    }


    @Override
    public double getValue() {
        if (this.o1.getValue() < -1.0d) {
            throw new ArithmeticException("asin of a value smaller than 1");
        }
        if (this.o1.getValue() > 1.0d) {
            throw new ArithmeticException("asin of a value greater than 1");
        }
        return Math.asin(this.o1.getValue());
    }}
