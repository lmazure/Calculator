package main;

import java.io.PrintStream;
import java.util.Optional;

/**
 * parse the comman line arguments
 *
 */
public class CommandLineParser {

    private final boolean displayInBrowser;
    private final Optional<String> svgFileName;

    public CommandLineParser(final String[] args) {

        boolean displayInBrowserTempo = false;
        Optional<String> svgFileNameTempo = Optional.empty();

        int i = 0;
        while (i < args.length ) {
            if (args[i].equals("-h")) {
                printHelp(System.out);
                System.exit(0);
            }
            if (args[i].equals("-b")) {
                displayInBrowserTempo = true;
                i++;
                break;
            }
            if (args[i].equals("-f")) {
                if (i == (args.length - 1)) {
                    System.err.println("missing SVG filename");
                    printHelp(System.err);
                    System.exit(1);
                }
                svgFileNameTempo = Optional.of(args[i+1]);
                i += 2;
                break;
            }
            System.err.println("unexpected argument: " + args[i]);
            printHelp(System.err);
            System.exit(1);
        }
        
        this.displayInBrowser = displayInBrowserTempo;
        this.svgFileName = svgFileNameTempo;
    }

    /**
     * @return should the expression be displayed in Browser?
     */
    public boolean getDisplayInBrowser() {
        return this.displayInBrowser;
    }

    /**
     * @return name of the SVG file to generate<br>
     * empty if no SVG file should be generated
     */
    public Optional<String> getSvgFileName() {
        return this.svgFileName;
    }

    static private void printHelp(final PrintStream ps) {
        ps.println("options:");
        ps.println("-h        display this help");
        ps.println("-b        display the expression in a Browser");
        ps.println("-f <file> generate a SVG file of the expression");
    }
}
