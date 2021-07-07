package computer;

public class SumOperator extends LoopOperator {

    public SumOperator(final Operand o1,
                       final Operand o2,
                       final Operand o3,
                       final IncrementStack incrementStack) {
        super(o1, o2, o3, incrementStack, 0, (x,y) -> (x + y), "sum", "sum");
    }
}
