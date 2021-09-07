package computer;

public class MultiplyOperator extends BinaryOperator {

    public MultiplyOperator(final Operand o1, final Operand o2) {
        super(o1, o2, "*", "\\times");
    }

    @Override
    public double getValue() {
        return this.o1.getValue() * this.o2.getValue();
    }

    @Override
    boolean needBrackets(final Operand other,
                         final Position position) {
        return other instanceof BinaryOperator &&
               !(other instanceof MultiplyOperator || other instanceof PowerOperator);
    }

    public static String getHelp() {
        return "Pop b from the stack\n"
                + "Pop a from the stack\n"
                + "Push a multiplied by b on the stack";
    }
}
