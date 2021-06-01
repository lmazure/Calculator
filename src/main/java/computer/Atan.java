package computer;

public class Atan extends JavaMathUnaryOperator {

    public Atan(final Operand o1) {
        super(o1, Math::atan, "arctan(", ")");
    }
}
