package computer;

public class SinOperator extends SimpleBracketedUnaryOperator {

    public SinOperator(final Operand o1) {
        super(o1, Math::sin, "sin");
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its sine (considering that the value is in radians) on the stack"; 
    }
}
