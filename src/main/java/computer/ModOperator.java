package computer;

public class ModOperator extends BinaryOperator {

    public ModOperator(final Operand o1, final Operand o2) {
        super(o1, o2, "%", "\\mod");
    }

    @Override
    public double getValue() {
        final double d = this.o1.getValue() / this.o2.getValue();
        if (!Double.isFinite(d)) {
            throw new ArithmeticException("Modulo zero");
        }
        return (d - (int)d) * this.o2.getValue();
    }

    @Override
    boolean needBrackets(final Operand other,
                         final Position position) {
        return other instanceof BinaryOperator &&
               !(other instanceof PowerOperator);
    }

    public static String getHelp() {
        return "Pop b from the stack\n"
                + "Pop a from the stack\n"
                + "Push a modulo b on the stack";
    }
}
