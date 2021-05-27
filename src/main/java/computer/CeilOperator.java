package computer;

public class CeilOperator extends UnaryOperator {

	protected CeilOperator(final Operand o1) {
		super(o1);
	}

	@Override
	public double getValue() {
		return Math.ceil(o1.getValue());
	}

	@Override
	public String getDescription() {
		return "⌈" + o1.getDescription() + "⌉";
	}
}
