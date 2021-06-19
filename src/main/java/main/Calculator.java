package main;

import java.util.Arrays;

import computer.AcosOperator;
import computer.AcoshOperator;
import computer.AddOperator;
import computer.AsinOperator;
import computer.AsinhOperator;
import computer.AtanOperator;
import computer.AtanhOperator;
import computer.CeilOperator;
import computer.CosOperator;
import computer.CoshOperator;
import computer.DivideOperator;
import computer.ExpOperator;
import computer.FloorOperator;
import computer.LnOperator;
import computer.MultiplyOperator;
import computer.Operand;
import computer.PowerOperator;
import computer.SinOperator;
import computer.SinhOperator;
import computer.SubtractOperator;
import computer.TanOperator;
import computer.TanhOperator;


public class Calculator {

    public static void main (String[] args) {
        final Parser parser = new Parser();
        parser.addOperatorClass(AddOperator.class);
        parser.addOperatorClass(SubtractOperator.class);
        parser.addOperatorClass(MultiplyOperator.class);
        parser.addOperatorClass(DivideOperator.class);
        parser.addOperatorClass(PowerOperator.class);
        parser.addOperatorClass(ExpOperator.class);
        parser.addOperatorClass(LnOperator.class);
        parser.addOperatorClass(CosOperator.class);
        parser.addOperatorClass(SinOperator.class);
        parser.addOperatorClass(TanOperator.class);
        parser.addOperatorClass(CoshOperator.class);
        parser.addOperatorClass(SinhOperator.class);
        parser.addOperatorClass(TanhOperator.class);
        parser.addOperatorClass(AcosOperator.class);
        parser.addOperatorClass(AsinOperator.class);
        parser.addOperatorClass(AtanOperator.class);
        parser.addOperatorClass(AcoshOperator.class);
        parser.addOperatorClass(AsinhOperator.class);
        parser.addOperatorClass(AtanhOperator.class);
        parser.addOperatorClass(CeilOperator.class);
        parser.addOperatorClass(FloorOperator.class);
        final Operand o = parser.parse(Arrays.asList(new String[] { "2", "1", "asin", "multiply" }));
        printOperand(o);
    }

    private static void printOperand(final Operand o) {
        System.out.println(o.getDescription() + " = " + o.getValue());
    }

}
