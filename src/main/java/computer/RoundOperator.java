package computer;

public class RoundOperator extends SimpleUnaryOperator {

    public RoundOperator(final Operand o1) {
        super(o1, x -> Double.valueOf(Math.round(x.doubleValue())), "[", "]");
    }

    @Override
    public String getLatex() {
        return "\\left[{" + this.o1.getLatex() + "}\\right]";
    }
}
