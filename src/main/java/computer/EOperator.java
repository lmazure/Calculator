package computer;

public class EOperator extends ConstantOperator {

    public EOperator() {
        super(Math.E, "e", "e");
    }

    public static String getHelp() {
        return "Push on the stack the value of e (2.718281828459045…)";
    }
}
