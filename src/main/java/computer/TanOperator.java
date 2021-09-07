package computer;

public class TanOperator extends SimpleBracketedUnaryOperator {

    public TanOperator(final Operand o1) {
        super(o1, Math::tan, "tan");
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its tangent (considering that the value is in radians) on the stack"; 
    }
}
