package computer;

public class SqrtOperator extends SimpleBracketedUnaryOperator {

    public SqrtOperator(final Operand o1) {
        super(o1, Math::sqrt, "sqrt");
    }

    @Override
    public String getLatex() {
        return "\\sqrt{" + this.o1.getLatex() + "}";
    }
}
