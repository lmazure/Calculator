package computer;

public class AbsOperator extends SimpleUnaryOperator {


    public AbsOperator(final Operand o1) {
        super(o1, Math::abs, "|", "|");
    }

    @Override
    public String getLatex() {
        return "\\abs*{" + o1.getLatex() + "}";
    }
}
