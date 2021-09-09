package computer;

public class CosOperator extends SimpleBracketedUnaryOperator {

    public CosOperator(final Operand o1) {
        super(o1, Math::cos, "cos");
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its cosine (considering that the value is in radians) on the stack";
    }
}
