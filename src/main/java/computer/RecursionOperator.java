package computer;

import java.util.stream.Collectors;

public class RecursionOperator implements Operand {

    private final Operand o1;
    private final Operand o2;
    private final Operand o3;
    private final Operand o4;
    private final Stack stack;

    public RecursionOperator(final Operand o1,
                             final Operand o2,
                             final Operand o3,
                             final Operand o4,
                             final Stack stack) {
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.o4 = o4;
        this.stack = stack;
    }

    @Override
    public double getValue() {
        final int min = (int)Math.round(this.o1.getValue());
        final int max = (int)Math.round(this.o2.getValue());
        if (max < min) {
            throw new BadBoundsException("Bad bounds (min=" + min + " , max=" + max + ") ");
        }
        double result = this.o3.getValue();
        for (int i = max ; i >= min; i--) {
            this.stack.push(i, result);
            result = this.o4.getValue();
            this.stack.discardTop();
        }
        return result;
    }


    public static String getHelp() {
        return "Pop d from the stack\n"
                + "Pop c from the stack\n"
                + "Pop b from the stack\n"
                + "Pop a from the stack\n"
                + "Compute imin the rounded value of a\n"
                + "Compute imax the rounded value of b\n"
                + "From i equal imin to imax, set the value of the var of the current depth to i, set the value of the recvar of the current depth to the current recursion value and compute the value of c\n"
                + "For i equal to imax, set the initial value if recvar to c"
                + "Push on the stack the final result of the recursion";
    }

    @Override
    public String getDescription() {
        final String incrementName = generateIncrementName();
        this.stack.pushDescription(incrementName, "recvar " + (this.stack.getCurrentDepth() + 1));
        final String desc = "for " +
                            incrementName +
                            " equal " +
                            this.o1.getDescription() +
                            " to " +
                            this.o2.getDescription() +
                            " recurse on {\n" +
                            this.o4.getDescription().lines().map(s -> "    " + s).collect(Collectors.joining("\n")) +
                            "\n} starting with value " +
                            this.o3.getDescription() +
                            " for initializing the deepest recursion";
        this.stack.discardTop();
        return desc;
    }

    @Override
    public String getLatex() {

        final int min = (int)Math.round(this.o1.getValue());
        String result = "...";
        for (int i = 0 ; i < 3; i++) {
            this.stack.pushLatex(generateIncrementName(), Integer.toString(i + min));
            result = this.o4.getLatex();
            this.stack.discardTop();
        }
        return result;
    }

    private String generateIncrementName() {
        final int depth = this.stack.getCurrentDepth();
        return ""+ (char)('i' + (depth + 1));
    }
}
