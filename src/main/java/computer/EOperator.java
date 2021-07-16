package computer;

public class EOperator implements Operand {

    public EOperator() {
    }

    @Override
    public double getValue() {
        return Math.E;
    }

    @Override
    public String getDescription() {
        return "e";
    }

    @Override
    public String getLatex() {
        return "e";
    }
}
