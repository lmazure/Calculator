package main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

import computer.AbsOperator;
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
import computer.EOperator;
import computer.ExpOperator;
import computer.FloorOperator;
import computer.LnOperator;
import computer.ModOperator;
import computer.MultiplyOperator;
import computer.Operand;
import computer.PiOperator;
import computer.PowerOperator;
import computer.ProductOperator;
import computer.RandOperator;
import computer.RoundOperator;
import computer.SinOperator;
import computer.SinhOperator;
import computer.SqrtOperator;
import computer.SubtractOperator;
import computer.SumOperator;
import computer.TanOperator;
import computer.TanhOperator;

public class Calculator {

    public static void main(final String[] args) {
        final CommandLineParser commandLineParser = new CommandLineParser(args);
        final Parser parser = buildParser(commandLineParser);
        if (commandLineParser.getDisplayExamples()) {
            displayExamples(parser);
        }
        final LinkedList<String> expression = readExpression();
        final Operand o = parser.parse(expression);
        printOperand(o);
        if (commandLineParser.getDisplayInBrowser()) {
            launchCodecogs(o);
        }
        if (commandLineParser.getSvgFileName().isPresent()) {
            generateSvgFile(o, commandLineParser.getSvgFileName().get());
        }
    }

    private static void displayExamples(final Parser parser) {
        final String TABLE_STYLE = "border: 2px solid black; border-collapse: collapse";
        final String CELL_STYLE = "border: 1px solid black; padding: 5px 5px";
        try {
            final Path path = Files.createTempFile(null, ".html");
            try (final FileOutputStream stream = new FileOutputStream(path.toFile());
                 final OutputStreamWriter writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8)) {
                writer.write("<!DOCTYPE html>\n");
                writer.write("<html>\n");
                writer.write("<body>\n");
                writer.write("<h1>Examples</h1>\n");
                for (Formula formula: FormulaRepository.getFormulas()) {
                    int  line = 0;
                    final Operand example = parser.parse(formula.getExpression());
                    writer.write("<table style=\"" + TABLE_STYLE + "\">\n");
                    final List<String> expression = formula.getExpression();
                    final int expressionSize = expression.size();
                    final Instant t1 = Instant.now();
                    final URI codecogsUri = getCodecogsUri(example);
                    final Instant t2 = Instant.now();
                    final long duration = ChronoUnit.MILLIS.between(t1, t2);
                    for (String s: expression) {
                        writer.write("<tr style=\"" + CELL_STYLE + "\">\n");
                        writer.write("<td style=\"" + CELL_STYLE + "\">" + s + "</td>\n");
                        if (line == 0) {
                            writer.write("<td style=\"" + CELL_STYLE + "\">" + htmlEncode(example.getDescription()) + "</td>\n");
                        } else if (line == 1) {
                                writer.write("<td style=\"" + CELL_STYLE + "\" rowspan=\"" + (expressionSize - 2) + "\"><iframe frameBorder=\"0\" src=\"" + codecogsUri + "\"></iframe></td>\n");
                        } else if (line == (expressionSize - 1)) {
                            writer.write("<td style=\"" + CELL_STYLE + "\"> duration = " + duration + " ms</td>\n");
                        }
                        writer.write("</tr>\n");
                        line++;
                    }
                    //System.out.println(example.getLatex());
                    writer.write("</table><br>\n");
                }
                writer.write("</body>\n");
                writer.write("</html>");
                displayBrowser(path.toUri());
            }
        } catch (final IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static LinkedList<String> readExpression() {
        final LinkedList<String> program = new LinkedList<>();
        try {
            final BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
            for (;;) {
                System.out.print( "> " );
                final String input = reader.readLine();
                if ((input == null) || (input.length() == 0)) {
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

    public static Parser buildParser(final CommandLineParser commandLineParser) {
        final Parser parser = new Parser();
        parser.addOperatorClass(AddOperator.class);
        parser.addOperatorClass(SubtractOperator.class);
        parser.addOperatorClass(MultiplyOperator.class);
        parser.addOperatorClass(DivideOperator.class);
        parser.addOperatorClass(ModOperator.class);
        parser.addOperatorClass(PowerOperator.class);
        parser.addOperatorClass(SqrtOperator.class);
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
        parser.addOperatorClass(RoundOperator.class);
        parser.addOperatorClass(CeilOperator.class);
        parser.addOperatorClass(FloorOperator.class);
        parser.addOperatorClass(AbsOperator.class);
        parser.addOperatorClass(RandOperator.class);
        if (commandLineParser.getRandomSeed().isPresent()) {
            RandOperator.setSeed(commandLineParser.getRandomSeed().get().longValue());
        }
        parser.addOperatorClass(EOperator.class);
        parser.addOperatorClass(PiOperator.class);
        parser.addOperatorClass(SumOperator.class);
        parser.addOperatorClass(ProductOperator.class);
        return parser;
    }

    private static void printOperand(final Operand o) {
        System.out.println(o.getDescription() + " = " + o.getValue());
    }

    private static void launchCodecogs(final Operand o) {
        System.out.println(o.getLatex());
        displayBrowser(getCodecogsUri(o));
    }

    private static void generateSvgFile(final Operand o,
                                        final String filename) {
        final String svgContent = getSvgContent(o);
        try (final FileOutputStream stream = new FileOutputStream(filename);
             final OutputStreamWriter writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8)) {
            writer.write(svgContent);
        } catch (final IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String getSvgContent(final Operand o) {
        final StringBuffer content = new StringBuffer();
        try {
            final HttpURLConnection connection = (HttpURLConnection) getUrl(o).openConnection();
            connection.setRequestMethod("GET");
            try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            connection.disconnect();
        } catch (final IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return content.toString();
    }

    private static URL getUrl(final Operand o) {
        final URI uri = getCodecogsUri(o);
        try {
            return uri.toURL();
        } catch (final MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    private static URI getCodecogsUri(final Operand o) {
        final String url = "https://latex.codecogs.com/svg.image?";
        String encodedLatexExpression = "";
        try {
            encodedLatexExpression = URLEncoder.encode(o.getLatex() + "=" + o.getValue(), StandardCharsets.UTF_8.toString());
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            return new URI(url + encodedLatexExpression);
        } catch (final URISyntaxException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    private static void displayBrowser(final URI uri) {
        try {
            Desktop.getDesktop().browse(uri);
        } catch (final IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String htmlEncode(final String str) {
        return str.replace("&", "&amp;")
                  .replace(">", "&gt;")
                  .replace("<", "&lt;")
                  .replace("\n", "<br>")
                  .replace(" ", "&nbsp;");
    }
}
