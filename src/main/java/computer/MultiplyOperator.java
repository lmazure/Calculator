package computer;

public class MultiplyOperator extends BinaryOperator {

    public MultiplyOperator(final Operand o1, final Operand o2) {
        super(o1, o2);
    }

    @Override
    public double getValue() {
        return o1.getValue() * o2.getValue();
    }

    @Override
    public String getDescription() {
        return "(" + o1.getDescription() + ") * (" + o2.getDescription() + ")";
    }

}
