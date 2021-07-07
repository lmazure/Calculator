package computer;

public class ModOperator extends BinaryOperator {

    public ModOperator(final Operand o1, final Operand o2) {
        super(o1, o2);
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
    public String getDescription() {
        return "(" + o1.getDescription() + ") % (" + o2.getDescription() + ")";
    }

    @Override
    public String getLatex() {
        return "\\left(" + o1.getLatex() + "\\right)\\mod\\left(" + o2.getLatex() + "\\right)";
    }
}
