package computer;

import java.util.function.Function;

public class SimpleBracketedUnaryOperator extends SimpleUnaryOperator {

    private final String syntax;

    protected SimpleBracketedUnaryOperator(final Operand o1,
                                           final Function<Double, Double> function,
                                           final String syntax) {
        super(o1, function, syntax + "(", ")");
        this.syntax = syntax;
    }


    @Override
    public String getLatex() {
        return this.syntax + "(" + o1.getLatex() + ")";
    }
}
