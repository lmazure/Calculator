package computer;

public class AddOperator extends BinaryOperator {

    public AddOperator(final Operand o1,
                       final Operand o2) {
        super(o1, o2, "+", "+");
    }

    @Override
    public double getValue() {
        return o1.getValue() + o2.getValue();
    }

    boolean needBrackets(final Operand other,
                         final Position position) {
        return other instanceof ModOperator;
    }
}
