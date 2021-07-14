package computer;

public abstract class BinaryOperator implements Operand {

    protected final Operand o1;
    protected final Operand o2;
    private final String description;
    private final String latex;
    protected enum Position { LEFT, RIGHT };

    protected BinaryOperator(final Operand o1,
                             final Operand o2,
                             final String description,
                             final String latex) {
        this.o1 = o1;
        this.o2 = o2;
        this.description = description;
        this.latex = latex;
    }

    @Override
    public String getDescription() {
        return (needBrackets(o1, Position.LEFT) ? ("(" + o1.getDescription() + ")") :  o1.getDescription()) +
               " " + this.description + " " +
               (needBrackets(o2, Position.RIGHT) ? ("(" + o2.getDescription() + ")") :  o2.getDescription());
    }

    @Override
    public String getLatex() {
        return (needBrackets(o1, Position.LEFT) ? ("\\left(" + o1.getLatex() + "\\right)") :  o1.getLatex()) +
               this.latex +
               (needBrackets(o2, Position.RIGHT) ? ("\\left(" + o2.getLatex() + "\\right)") :  o2.getLatex());
    }

    abstract boolean needBrackets(final Operand other,
                                  final Position position);
}
