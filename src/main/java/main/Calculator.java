package main;

import computer.Adder;
import computer.Multiplier;
import computer.Number;
import computer.Operand;


public class Calculator {

    public static void main (String[] args) {
        System.out.println("--- Start ---");
        final Number n1 = new Number(1.3d, "n1");
        final Number n2 = new Number(0.7d, "n2");
        final Number n3 = new Number(1.1d, "n3");
        final Operand n4 = new Adder(n1, n2);
        final Operand n5 = new Multiplier(n4, n3);
        printOperand(n1);
        printOperand(n2);
        printOperand(n3);
        printOperand(n5);
        System.out.println("--- End ---");
    }

    private static void printOperand(final Operand o) {
        System.out.println(o.getDescription() + " = " + o.getValue());
    }
}
