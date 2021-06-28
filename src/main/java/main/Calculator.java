package main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

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
import computer.ModOperator;
import computer.MultiplyOperator;
import computer.Operand;
import computer.PowerOperator;
import computer.SinOperator;
import computer.SinhOperator;
import computer.SubtractOperator;
import computer.TanOperator;
import computer.TanhOperator;

public class Calculator {

    public static void main (final String[] args) {
        final LinkedList<String> program = readProgram();
        final Parser parser = buildParser();
        final Operand o = parser.parse(program);
        printOperand(o);
        launchCodecogs(o);
    }

    private static LinkedList<String> readProgram() {
        final LinkedList<String> program = new LinkedList<>();
        try {
            final BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
            for (;;) {
                System.out.print( "> " );
                final String input = reader.readLine();
                if (input.length() == 0) {
                    break;
                }
                program.addLast(input);
            }
        } catch(final Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        return program;
    }

    private static Parser buildParser() {
        final Parser parser = new Parser();
        parser.addOperatorClass(AddOperator.class);
        parser.addOperatorClass(SubtractOperator.class);
        parser.addOperatorClass(MultiplyOperator.class);
        parser.addOperatorClass(DivideOperator.class);
        parser.addOperatorClass(ModOperator.class);
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
        return parser;
    }

    private static void printOperand(final Operand o) {
        System.out.println(o.getDescription() + " = " + o.getValue());
    }

    private static void launchCodecogs(final Operand o) {
        System.out.println(o.getLatex());
        final String url = "https://latex.codecogs.com/svg.image?";
        String u = "";
        try {
            u = URLEncoder.encode(o.getLatex() + "=" + o.getValue(), StandardCharsets.UTF_8.toString());
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            Desktop.getDesktop().browse(new URI(url + u));
        } catch (final IOException | URISyntaxException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
