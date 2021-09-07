package main;

import java.io.PrintStream;
import java.util.Optional;

/**
 * parse the command line arguments
 *
 */
public class CommandLineParser {

    private final boolean displayInBrowser;
    private final boolean displayOperators;
    private final boolean displayExamples;
    private final Optional<String> svgFileName;
    private final Optional<Long> randomSeed;

    public CommandLineParser(final String[] args) {

        boolean displayInBrowserTempo = false;
        boolean displayOperatorsTempo = false;
        boolean displayExamplesTempo = false;
        Optional<String> svgFileNameTempo = Optional.empty();
        Optional<Long> randomSeedTempo = Optional.empty();

        int i = 0;
        while (i < args.length ) {
            if (args[i].equals("-h")) {
                printHelp(System.out);
                System.exit(0);
            }
            if (args[i].equals("-o")) {
                displayOperatorsTempo = true;
                i++;
                continue;
            }
            if (args[i].equals("-x")) {
                displayExamplesTempo = true;
                i++;
                continue;
            }
            if (args[i].equals("-b")) {
                displayInBrowserTempo = true;
                i++;
                continue;
            }
            if (args[i].equals("-f")) {
                if (i == (args.length - 1)) {
                    System.err.println("missing SVG filename");
                    printHelp(System.err);
                    System.exit(1);
                }
                svgFileNameTempo = Optional.of(args[i+1]);
                i += 2;
                continue;
            }
            if (args[i].equals("-s")) {
                if (i == (args.length - 1)) {
                    System.err.println("missing seed");
                    printHelp(System.err);
                    System.exit(1);
                }
                try {
                    randomSeedTempo = Optional.of(Long.valueOf(args[i+1]));
                } catch (@SuppressWarnings("unused") final NumberFormatException e) {
                    System.err.println("invalid seed value: " + args[i+1]);
                    printHelp(System.err);
                    System.exit(1);
                }
                i += 2;
                continue;
            }
            System.err.println("unexpected argument: " + args[i]);
            printHelp(System.err);
            System.exit(1);
        }

        this.displayInBrowser = displayInBrowserTempo;
        this.displayOperators = displayOperatorsTempo;
        this.displayExamples = displayExamplesTempo;
        this.svgFileName = svgFileNameTempo;
        this.randomSeed = randomSeedTempo;
    }

    /**
     * @return should the expression be displayed in Browser?
     */
    public boolean getDisplayInBrowser() {
        return this.displayInBrowser;
    }

    /**
     * @return should the operator list be displayed?
     */
    public boolean getDisplayOperators() {
        return this.displayOperators;
    }

    /**
     * @return should the examples be displayed?
     */
    public boolean getDisplayExamples() {
        return this.displayExamples;
    }

    /**
     * @return name of the SVG file to generate<br>
     * empty if no SVG file should be generated
     */
    public Optional<String> getSvgFileName() {
        return this.svgFileName;
    }

    /**
     * @return seed for random numbers<br>
     * empty if seed has been defined
     */
    public Optional<Long> getRandomSeed() {
        return this.randomSeed;
    }

    static private void printHelp(final PrintStream ps) {
        ps.println("options:");
        ps.println("-h        display this help");
        ps.println("-o        display list of operators");
        ps.println("-x        display examples");
        ps.println("-b        display the expression in a Browser");
        ps.println("-f <file> generate a SVG file of the expression");
        ps.println("-s <seed> set the (integer) seed of random numbers");
    }
}
