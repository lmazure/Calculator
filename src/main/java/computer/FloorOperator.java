package computer;

public class FloorOperator extends SimpleUnaryOperator {

    public FloorOperator(final Operand o1) {
        super(o1, Math::floor, "⌊", "⌋");
    }

    @Override
    public String getLatex() {
        return "\\lfloor{" + o1.getLatex() + "}\\rfloor";
    }

}
