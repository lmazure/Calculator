package computer;

public class Number {
    
    private double number;
    private final static Double EPSILON = 0.000001d;

    public Number(final double number) {
        this.number = number;
    }

    public double get() {
        return number;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(number);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Number other = (Number) obj;
        if (Double.doubleToLongBits(number) != Double.doubleToLongBits(other.number))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return Double.toString(number);
    }

    public static boolean approximateEquals(final Number n1,
                                            final Number n2) {
        return Math.abs(n1.number - n2.number) < EPSILON;
    }
}

