package computer;

public class AcoshOperator extends SimpleUnaryOperator {

    public AcoshOperator(final Operand o1) {
        super(o1, AcoshOperator::acosh, "arccosh(", ")");
    }

    private static Double acosh(final Double value) {
        return Math.log(value + Math.sqrt(value * value - 1));
    }
}
