package computer;

public class Number implements Operand {

    private double number;
    private String name;
    private final static double EPSILON = 0.000001d;

    public Number(final double number,
                  final String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public double getValue() {
        return this.number;
    }

    @Override
    public String getDescription() {
        return this.name;
    }


    @Override
    public String getLatex() {
        return this.name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(this.number);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Number other = (Number) obj;
        return (Double.doubleToLongBits(this.number) == Double.doubleToLongBits(other.number));
    }

    @Override
    public String toString() {
        return Double.toString(this.number);
    }

    public static boolean approximateEquals(final Number n1,
                                            final Number n2) {
        return Math.abs(n1.number - n2.number) < EPSILON;
    }
}
