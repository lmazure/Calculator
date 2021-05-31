package computer;

public class Tan extends JavaMathUnaryOperator {

    public Tan(final Operand o1) {
        super(o1, Math::tan, "tan(", ")");
    }
}
