package computer;

public class Sin extends JavaMathUnaryOperator {

    public Sin(final Operand o1) {
        super(o1, Math::sin, "sin(", ")");
    }
}
