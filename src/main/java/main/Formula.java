package main;

import java.util.Arrays;
import java.util.List;

public class Formula {

    private final List<String> expression;
    private final double result;
    private final double precision;

    public Formula(final double result,
                   final double precision,
                   final String... expression) {
        this.expression = Arrays.asList(expression);
        this.result = result;
        this.precision = precision;
    }

    public List<String> getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }

    public double getPrecision() {
        return precision;
    }
}
