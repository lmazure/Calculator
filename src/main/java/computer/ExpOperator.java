package computer;

public class ExpOperator extends SimpleUnaryOperator {

    public ExpOperator(final Operand o1) {
        super(o1, Math::exp, "e^(", ")");
    }

    @Override
    public String getDescription() {
        if ((this.o1 instanceof BinaryOperator) || (this.o1 instanceof ExpOperator)) {
            return "e^(" + this.o1.getDescription() + ")";
        }
        return "e^" + this.o1.getDescription();
    }

    @Override
    public String getLatex() {
        return "e^" + this.o1.getLatex();
    }
}
