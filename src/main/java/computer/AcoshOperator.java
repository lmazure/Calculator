package computer;

public class AcoshOperator extends SimpleBracketedUnaryOperator {

    public AcoshOperator(final Operand o1) {
        super(o1, AcoshOperator::acosh, "arccosh");
    }

    private static double acosh(final double value) {
        if (value < 1.0d) {
            throw new ArithmeticException("acosh of a value smaller than 1");
        }

        return Math.log(value + Math.sqrt(value * value - 1));
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its inverse hyperbolic cosine on the stack";
    }
}
