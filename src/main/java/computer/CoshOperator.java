package computer;

public class CoshOperator extends SimpleBracketedUnaryOperator {

    public CoshOperator(final Operand o1) {
        super(o1, Math::cosh, "cosh");
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its hyperbolic cosine on the stack";
    }
}
