package computer;

public class FloorOperator extends SimpleUnaryOperator {

    public FloorOperator(final Operand o1) {
        super(o1, Math::floor, "⌊", "⌋");
    }

    @Override
    public String getLatex() {
        return "\\lfloor{" + this.o1.getLatex() + "}\\rfloor";
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its floor value on the stack"; 
    }
}
