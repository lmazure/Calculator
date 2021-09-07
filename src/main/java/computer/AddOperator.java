package computer;

public class AddOperator extends BinaryOperator {

    public AddOperator(final Operand o1,
                       final Operand o2) {
        super(o1, o2, "+", "+");
    }

    @Override
    public double getValue() {
        return this.o1.getValue() + this.o2.getValue();
    }

    @Override
    boolean needBrackets(final Operand other,
                         final Position position) {
        return other instanceof ModOperator;
    }

    public static String getHelp() {
        return "Pop b from the stack\n"
                + "Pop a from the stack\n"
                + "Push a added to b on the stack";
    }
}
