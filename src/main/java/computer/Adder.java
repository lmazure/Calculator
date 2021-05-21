package computer;

public class Adder implements BinaryOperator {

    public Number operate(final Number n1, final Number n2) {
        return new Number(n1.get() + n2.get());
    }    
}
