package computer;

public class FloorOperator extends UnaryOperator {

    protected FloorOperator(final Operand o1) {
        super(o1);
    }

    @Override
    public double getValue() {
        return Math.floor(o1.getValue());
    }

    @Override
    public String getDescription() {
        return "⌊" + o1.getDescription() + "⌋";
    }
}
