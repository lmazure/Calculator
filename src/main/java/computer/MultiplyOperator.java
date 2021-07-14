package computer;

public class MultiplyOperator extends BinaryOperator {

    public MultiplyOperator(final Operand o1, final Operand o2) {
        super(o1, o2, "*", "\\times");
    }

    @Override
    public double getValue() {
        return o1.getValue() * o2.getValue();
    }

    @Override
    boolean needBrackets(final Operand other,
                         final Position position) {
        return other instanceof BinaryOperator &&
               !(other instanceof MultiplyOperator || other instanceof PowerOperator);
    }
}
