package computer;

public class CeilOperator extends JavaMathUnaryOperator {

    protected CeilOperator(final Operand o1) {
        super(o1, Math::ceil, "⌈", "⌉");
    }
}
