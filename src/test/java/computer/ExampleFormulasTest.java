package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import main.Calculator;
import main.CommandLineParser;
import main.Formula;
import main.FormulaRepository;
import main.Parser;

public class ExampleFormulasTest {

    @ParameterizedTest
    @MethodSource("getExampleFormulas")
    @SuppressWarnings("static-method")
    void check(final Formula formula) {

        // -- arrange
        final List<String> expression = formula.getExpression();
        final double expectedResult = formula.getResult();
        final double precision = formula.getPrecision();
        final Parser parser = Calculator.buildParser(new CommandLineParser(new String[0]));

        // -- act
        final Operand parsedExpression = parser.parse(expression);
        final double effectiveValue = parsedExpression.getValue();

        // -- assert
        assertEquals(expectedResult, effectiveValue, precision, "Wrong result for expression " + parsedExpression.getDescription());
     }

    private static Stream<Formula> getExampleFormulas() {
        return FormulaRepository.getFormulas().stream();
    }
}
