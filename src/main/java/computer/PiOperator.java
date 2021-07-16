package computer;

public class PiOperator implements Operand {

    public PiOperator() {
    }

    @Override
    public double getValue() {
        return Math.PI;
    }

    @Override
    public String getDescription() {
        return "π";
    }

    @Override
    public String getLatex() {
        return "\\pi";
    }
}
