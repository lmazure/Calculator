package computer;

public class SubtractOperator extends BinaryOperator {

    public SubtractOperator(final Operand o1, final Operand o2) {
        super(o1, o2, "-", "-");
    }

    @Override
    public double getValue() {
        return this.o1.getValue() - this.o2.getValue();
    }

    @Override
    boolean needBrackets(final Operand other,
                         final Position position) {
        if (position == Position.RIGHT) {
            return other instanceof BinaryOperator &&
                   !(other instanceof MultiplyOperator || other instanceof DivideOperator || other instanceof PowerOperator);
        }
        return other instanceof ModOperator;
    }
}
