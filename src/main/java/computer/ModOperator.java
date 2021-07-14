package computer;

public class ModOperator extends BinaryOperator {

    public ModOperator(final Operand o1, final Operand o2) {
        super(o1, o2, "%", "\\mod");
    }

    @Override
    public double getValue() {
        final double d = o1.getValue() / o2.getValue();
        if (!Double.isFinite(d)) {
            throw new ArithmeticException("Modulo zero");
        }
        return (d - (int)d) * o2.getValue();
    }

    @Override
    boolean needBrackets(final Operand other,
                         final Position position) {
        return other instanceof BinaryOperator &&
               !(other instanceof PowerOperator);
    }
}
