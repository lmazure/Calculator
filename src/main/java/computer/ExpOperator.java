package computer;

public class ExpOperator extends SimpleUnaryOperator {

    public ExpOperator(final Operand o1) {
        super(o1, Math::exp, "e^(", ")");
    }


    @Override
    public String getLatex() {
        return "e^" + o1.getLatex();
    }
}
