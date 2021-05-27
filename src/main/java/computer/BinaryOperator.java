package computer;

public abstract class BinaryOperator implements Operand {

    protected final Operand o1;
    protected final Operand o2;

    protected BinaryOperator(final Operand o1,
                          final Operand o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
}
