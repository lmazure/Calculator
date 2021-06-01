package computer;

public class Asin extends JavaMathUnaryOperator {

    public Asin(final Operand o1) {
        super(o1, Math::asin, "arcsin(", ")");
    }
}
