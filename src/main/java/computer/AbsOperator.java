package computer;

public class AbsOperator extends SimpleUnaryOperator {


    public AbsOperator(final Operand o1) {
        super(o1, Math::abs, "|", "|");
    }

    @Override
    public String getLatex() {
        return "\\abs*{" + this.o1.getLatex() + "}";
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its absolute value on the stack"; 
    }
}
