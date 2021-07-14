package computer;

import java.util.Random;

public class RandOperator implements Operand {

    private static final Random random = new Random();

    public RandOperator() {
    }

    public static void setSeed(final long seed) {
        random.setSeed(seed);
    }

    @Override
    public double getValue() {
        return random.nextDouble();
    }

    @Override
    public String getDescription() {
        return "rand()";
    }

    @Override
    public String getLatex() {
        return "rand()";
    }
}
