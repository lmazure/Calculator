package computer;

public class ProductOperator extends LoopOperator {

    public ProductOperator(final Operand o1,
                           final Operand o2,
                           final Operand o3,
                           final IncrementStack incrementStack) {
        super(o1, o2, o3, incrementStack, 1, (x,y) -> (x * y), "product", "prod");
    }

    public static String getHelp() {
        return "Pop c from the stack\n"
                + "Pop b from the stack\n"
                + "Pop a from the stack\n"
                + "Compute imin the rounded value of a\n"
                + "Compute omax the rounded value of b\n"
                + "From imin to imax, set the value of the var of the current depth to i and compute the value of c"
                + "Multiply all these values and push the result on the stack";
    }
}
