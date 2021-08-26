package computer;

public class LnOperator extends SimpleBracketedUnaryOperator {

    public LnOperator(final Operand o1) {
        super(o1, Math::log, "ln");
    }

    @Override
    public double getValue() {
        if (this.o1.getValue() <= 0.0d) {
            if (this.o1.getValue() == 0.0d) {
                throw new ArithmeticException("ln of a zero");
            }
            throw new ArithmeticException("ln of a negative number");
        }
        return Math.log(this.o1.getValue());
    }
}