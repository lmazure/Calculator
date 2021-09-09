package computer;

public class AtanOperator extends SimpleBracketedUnaryOperator {

    public AtanOperator(final Operand o1) {
        super(o1, Math::atan, "arctan");
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its arctangent (expressed in radians between -π/2 and π/2) on the stack";
    }
}
