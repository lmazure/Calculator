package computer;

import java.util.function.Function;

public class SimpleBracketedUnaryOperator extends SimpleUnaryOperator {

    protected SimpleBracketedUnaryOperator(final Operand o1,
                                           final Function<Double, Double> function,
                                           final String syntax) {
        super(o1, function, syntax + "(", ")");
    }

    
}
