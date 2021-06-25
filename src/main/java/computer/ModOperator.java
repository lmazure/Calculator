package computer;

public class ModOperator extends BinaryOperator {
    
    public ModOperator(final Operand o1, final Operand o2) {
        super(o1, o2);
    }

    @Override
    public double getValue() {
        final double d = o1.getValue() / o2.getValue(); 
        return d - (int)d;
    }

    @Override
    public String getDescription() {
        return "(" + o1.getDescription() + ") % (" + o2.getDescription() + ")";
    }
}
