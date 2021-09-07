package computer;

public class AcosOperator extends SimpleBracketedUnaryOperator {

    public AcosOperator(final Operand o1) {
        super(o1, Math::acos, "arccos");
    }

    @Override
    public double getValue() {
        if (this.o1.getValue() < -1.0d) {
            throw new ArithmeticException("acos of a value smaller than 1");
        }
        if (this.o1.getValue() > 1.0d) {
            throw new ArithmeticException("acos of a value greater than 1");
        }
        return Math.acos(this.o1.getValue());
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its arccosine (expressed in radians between 0 and π) on the stack"; 
    }
}
