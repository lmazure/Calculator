package computer;

public class DivideOperator extends BinaryOperator {

    public DivideOperator(final Operand o1, final Operand o2) {
        super(o1, o2);
    }

    @Override
    public double getValue() {
        final double result =  o1.getValue() / o2.getValue();
        if (!Double.isFinite(result)) {
            throw new ArithmeticException("Division by zero");
        }
        return result;
    }

    @Override
    public String getDescription() {
        return "(" + o1.getDescription() + ") / (" + o2.getDescription() + ")";
    }
}
