package computer;

public abstract class ConstantOperator implements Operand {

    private final double value;
    private final String name;
    private final String latex;
    
    public ConstantOperator(final double value,
                            final String name,
                            final String latex) {
        this.value = value;
        this.name = name;
        this.latex = latex;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public String getDescription() {
        return this.name;
    }

    @Override
    public String getLatex() {
        return this.latex;
    }
}
