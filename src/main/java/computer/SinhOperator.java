package computer;

public class SinhOperator extends SimpleBracketedUnaryOperator {

    public SinhOperator(final Operand o1) {
        super(o1, Math::sinh, "sinh");
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its hyperbolic sine on the stack";
    }
}
