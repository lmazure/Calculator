package main;

import java.util.Arrays;
import java.util.List;

public class FormulaRepository {

    private final static List<Formula> formulas = Arrays.asList( new Formula[] {
            new Formula(1.0d , 1e-10d, "42", "cos", "2", "power",
                                       "42", "sin", "2", "power",
                                       "add", "sqrt"),
            new Formula(Math.PI , 1e-3d, "1", "100000000",
                                         "1",
                                         "rand", "2", "power",
                                         "rand", "2", "power",
                                         "add", "sqrt", "floor", "subtract",
                                         "sum", "25000000", "divide"),
            new Formula(Math.PI , 1e-3d, "1", "10000000",
                                         "1", "var 0", "2", "power", "divide",
                                         "sum", "6", "multiply", "sqrt")
            });
    
    public static List<Formula> getFormulas() {
        return formulas;
    }
}
