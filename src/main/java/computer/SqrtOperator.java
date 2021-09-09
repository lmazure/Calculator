package computer;

public class SqrtOperator extends SimpleBracketedUnaryOperator {

    public SqrtOperator(final Operand o1) {
        super(o1, Math::sqrt, "sqrt");
    }

    @Override
    public double getValue() {
        if (this.o1.getValue() < 0.0d) {
            throw new ArithmeticException("sqrt of a negative number");
        }
        return Math.sqrt(this.o1.getValue());
    }

    @Override
    public String getLatex() {
        return "\\sqrt{" + this.o1.getLatex() + "}";
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its square root on the stack";
    }
}
