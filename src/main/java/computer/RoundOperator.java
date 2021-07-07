package computer;

public class RoundOperator extends SimpleUnaryOperator {

    public RoundOperator(final Operand o1) {
        super(o1, x -> (double)Math.round(x), "[", "]");
    }

    @Override
    public String getLatex() {
        return "\\left[{" + o1.getLatex() + "}\\right]";
    }
}
