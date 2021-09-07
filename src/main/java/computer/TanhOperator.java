package computer;

public class TanhOperator extends SimpleBracketedUnaryOperator {

    public TanhOperator(final Operand o1) {
        super(o1, Math::tanh, "tanh");
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its hyperbolic tangent on the stack"; 
    }
}
