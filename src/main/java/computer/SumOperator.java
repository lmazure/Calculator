package computer;

public class SumOperator extends LoopOperator {

    public SumOperator(final Operand o1,
                       final Operand o2,
                       final Operand o3,
                       final IncrementStack incrementStack) {
        super(o1, o2, o3, incrementStack, 0, (x,y) -> (x + y), "sum", "sum");
    }

    public static String getHelp() {
        return "Pop c from the stack\n"
                + "Pop b from the stack\n"
                + "Pop a from the stack\n"
                + "Compute imin the rounded value of a\n"
                + "Compute imax the rounded value of b\n"
                + "From i equal imin to imax, set the value of the var of the current depth to i and compute the value of c\n"
                + "Add all these values and push the result on the stack";
    }
}
