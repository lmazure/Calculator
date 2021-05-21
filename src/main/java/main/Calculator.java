package main;

import computer.Adder;
import computer.Multiplier;
import computer.Number;

public class Calculator {

    public static void main (String[] args) {
        System.out.println("--- Start ---");
        final Number n1 = new Number(1.3d);
        final Number n2 = new Number(0.7d);
        final Number n3 = new Number(1.1d);
        final Number n4 = (new Adder()).operate(n1, n2);
        final Number n5 = (new Multiplier()).operate(n4, n3);
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("n3 = " + n3);
        System.out.println("n1+n2 = " + n4);
        System.out.println("(n1+n2)*n3 = " + n5);
        System.out.println("--- End ---");
    }
}
