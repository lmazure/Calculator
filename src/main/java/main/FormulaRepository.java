package main;

import java.util.Arrays;
import java.util.List;

public class FormulaRepository {

    private final static List<Formula> formulas = Arrays.asList( new Formula[] {
            new Formula(1.0d , 1e-14d, "42", "cos", "2", "power",
                                       "42", "sin", "2", "power",
                                       "add"),
            new Formula(1.0d , 1e-14d, "0.42", "cosh", "2", "power",
                                       "0.42", "sinh", "2", "power",
                                       "subtract"),
            new Formula(Math.PI , 1e-3d, "1", "100000000",
                                         "1",
                                         "rand", "2", "power",
                                         "rand", "2", "power",
                                         "add", "sqrt", "floor", "subtract",
                                         "sum", "25000000", "divide"),
            new Formula(Math.PI , 1e-7d, "1", "10000000",
                                         "1", "var 0", "2", "power", "divide",
                                         "sum", "6", "multiply", "sqrt"),
            new Formula(0.0d , 1e-7d, "1", "100000000",
                                      "1", "var 0", "-2", "power", "add", "product",
                                      "pi", "sinh", "pi", "divide",
                                      "subtract"),
            new Formula(0.0d , 1e-6d, "1", "100000000",
                                      "1", "4", "42", "2", "power", "multiply",
                                      "pi", "2", "power", "2", "var 0", "multiply", "1", "subtract", "2" , "power", "multiply", "divide", "subtract", "product",
                                      "42", "cos", "subtract"),
            new Formula(0.0d , 1e-6d, "pi",
                                      "1", "100000000", "1",
                                      "4", "var 0", "multiply", "2", "subtract",
                                      "pi", "2", "power", "recvar 0", "divide", "add", "recursion", "divide",
                                      "pi", "exp", "1", "subtract",
                                      "pi", "exp", "1", "add", "divide", "subtract"),
            });

    public static List<Formula> getFormulas() {
        return formulas;
    }
}
