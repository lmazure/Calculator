package computer;

public class CeilOperator extends SimpleUnaryOperator {

    public CeilOperator(final Operand o1) {
        super(o1, Math::ceil, "⌈", "⌉");
    }

    @Override
    public String getLatex() {
        return "\\lceil{" + this.o1.getLatex() + "}\\rceil";
    }

    public static String getHelp() {
        return "Pop an element from the stack\n"
               + "Push its ceiling value on the stack"; 
    }
}
