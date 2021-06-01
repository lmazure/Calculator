package computer;

public class Acos extends JavaMathUnaryOperator {

    public Acos(final Operand o1) {
        super(o1, Math::acos, "arccos(", ")");
    }
}
