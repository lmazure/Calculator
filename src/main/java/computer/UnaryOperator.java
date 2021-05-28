package computer;

public abstract class UnaryOperator implements Operand {

    protected final Operand o1;

    protected UnaryOperator(final Operand o1) {
        this.o1 = o1;
    }
}
