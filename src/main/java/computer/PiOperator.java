package computer;

public class PiOperator extends ConstantOperator {

    public PiOperator() {
        super(Math.PI, "π", "\\pi");
    }

    public static String getHelp() {
        return "Push on the stack the value of π (3.141592653589793…)";
    }
}
