package computer;

public abstract class BinaryOperator implements Operand {

    protected final Operand o1;
    protected final Operand o2;
    private final String description;
    private final String latex;
    protected enum Position { LEFT, RIGHT }

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
        return (needBrackets(this.o1, Position.LEFT) ? ("(" + this.o1.getDescription() + ")")
                                                     :  this.o1.getDescription()) +
               " " + this.description + " " +
               (needBrackets(this.o2, Position.RIGHT) ? ("(" + this.o2.getDescription() + ")")
                                                      :  this.o2.getDescription());
    }

    @Override
    public String getLatex() {
        String leftOpening, leftClosing;
        if (needBrackets(this.o1, Position.LEFT)) {
            leftOpening = "\\left(";
            leftClosing = "\\right)";
        } else if ((this.o1 instanceof VarOperator) || (this.o1 instanceof Number)) {
            leftOpening = "{";
            leftClosing = "}";
        } else {
            leftOpening = "";
            leftClosing = "";
        }
        String rightOpening, rightClosing;
        if (needBrackets(this.o2, Position.RIGHT)) {
            rightOpening = "\\left(";
            rightClosing = "\\right)";
        } else if ((this.o2 instanceof VarOperator) || (this.o2 instanceof Number)) {
            rightOpening = "{";
            rightClosing = "}";
        } else {
            rightOpening = "";
            rightClosing = "";
        }

        return leftOpening + this.o1.getLatex() + leftClosing +
               this.latex +
               rightOpening + this.o2.getLatex() + rightClosing;
    }

    abstract boolean needBrackets(final Operand other,
                                  final Position position);
}
