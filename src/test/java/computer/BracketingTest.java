package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Calculator;
import main.CommandLineParser;
import main.Parser;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ReportPortalExtension.class)
public class BracketingTest {

    @ParameterizedTest
    @CsvSource({
        "1|sin,sin(1)",

        "1|exp,e^1",
        "pi|exp,e^π",
        "1|sin|exp,e^sin(1)",
        "1|exp|exp,e^(e^1)",
        "1|2|add|exp,e^(1 + 2)",
        "1|2|subtract|exp,e^(1 - 2)",
        "1|2|multiply|exp,e^(1 * 2)",
        "1|2|divide|exp,e^(1 / 2)",
        "1|2|mod|exp,e^(1 % 2)",
        "1|2|power|exp,e^(1 ^ 2)",

        "1|2|add,1 + 2",
        "1|2|subtract,1 - 2",
        "1|2|multiply,1 * 2",
        "1|2|divide,1 / 2",
        "1|2|mod,1 % 2",
        "1|2|power,1 ^ 2",

        "1|2|add|sin,sin(1 + 2)",
        "1|2|subtract|sin,sin(1 - 2)",
        "1|2|multiply|sin,sin(1 * 2)",
        "1|2|divide|sin,sin(1 / 2)",
        "1|2|mod|sin,sin(1 % 2)",
        "1|2|power|sin,sin(1 ^ 2)",

        "1|sin|2|add,sin(1) + 2",
        "1|sin|2|subtract,sin(1) - 2",
        "1|sin|2|multiply,sin(1) * 2",
        "1|sin|2|divide,sin(1) / 2",
        "1|sin|2|mod,sin(1) % 2",
        "1|sin|2|power,sin(1) ^ 2",

        "1|2|sin|add,1 + sin(2)",
        "1|2|sin|subtract,1 - sin(2)",
        "1|2|sin|multiply,1 * sin(2)",
        "1|2|sin|divide,1 / sin(2)",
        "1|2|sin|mod,1 % sin(2)",
        "1|2|sin|power,1 ^ sin(2)",

        "1|2|3|add|add,1 + 2 + 3",
        "1|2|3|add|subtract,1 - (2 + 3)",
        "1|2|3|add|multiply,1 * (2 + 3)",
        "1|2|3|add|divide,1 / (2 + 3)",
        "1|2|3|add|mod,1 % (2 + 3)",
        "1|2|3|add|power,1 ^ (2 + 3)",

        "1|2|3|subtract|add,1 + 2 - 3",
        "1|2|3|subtract|subtract,1 - (2 - 3)",
        "1|2|3|subtract|multiply,1 * (2 - 3)",
        "1|2|3|subtract|divide,1 / (2 - 3)",
        "1|2|3|subtract|mod,1 % (2 - 3)",
        "1|2|3|subtract|power,1 ^ (2 - 3)",

        "1|2|3|multiply|add,1 + 2 * 3",
        "1|2|3|multiply|subtract,1 - 2 * 3",
        "1|2|3|multiply|multiply,1 * 2 * 3",
        "1|2|3|multiply|divide,1 / (2 * 3)",
        "1|2|3|multiply|mod,1 % (2 * 3)",
        "1|2|3|multiply|power,1 ^ (2 * 3)",

        "1|2|3|divide|add,1 + 2 / 3",
        "1|2|3|divide|subtract,1 - 2 / 3",
        "1|2|3|divide|multiply,1 * (2 / 3)",
        "1|2|3|divide|divide,1 / (2 / 3)",
        "1|2|3|divide|mod,1 % (2 / 3)",
        "1|2|3|divide|power,1 ^ (2 / 3)",

        "1|2|3|mod|add,1 + (2 % 3)",
        "1|2|3|mod|subtract,1 - (2 % 3)",
        "1|2|3|mod|multiply,1 * (2 % 3)",
        "1|2|3|mod|divide,1 / (2 % 3)",
        "1|2|3|mod|mod,1 % (2 % 3)",
        "1|2|3|mod|power,1 ^ (2 % 3)",

        "1|2|3|power|add,1 + 2 ^ 3",
        "1|2|3|power|subtract,1 - 2 ^ 3",
        "1|2|3|power|multiply,1 * 2 ^ 3",
        "1|2|3|power|divide,1 / 2 ^ 3",
        "1|2|3|power|mod,1 % 2 ^ 3",
        "1|2|3|power|power,1 ^ (2 ^ 3)",

        "1|2|add|3|add,1 + 2 + 3",
        "1|2|add|3|subtract,1 + 2 - 3",
        "1|2|add|3|multiply,(1 + 2) * 3",
        "1|2|add|3|divide,(1 + 2) / 3",
        "1|2|add|3|mod,(1 + 2) % 3",
        "1|2|add|3|power,(1 + 2) ^ 3",

        "1|2|subtract|3|add,1 - 2 + 3",
        "1|2|subtract|3|subtract,1 - 2 - 3",
        "1|2|subtract|3|multiply,(1 - 2) * 3",
        "1|2|subtract|3|divide,(1 - 2) / 3",
        "1|2|subtract|3|mod,(1 - 2) % 3",
        "1|2|subtract|3|power,(1 - 2) ^ 3",

        "1|2|multiply|3|add,1 * 2 + 3",
        "1|2|multiply|3|subtract,1 * 2 - 3",
        "1|2|multiply|3|multiply,1 * 2 * 3",
        "1|2|multiply|3|divide,1 * 2 / 3",
        "1|2|multiply|3|mod,(1 * 2) % 3",
        "1|2|multiply|3|power,(1 * 2) ^ 3",

        "1|2|divide|3|add,1 / 2 + 3",
        "1|2|divide|3|subtract,1 / 2 - 3",
        "1|2|divide|3|multiply,(1 / 2) * 3",
        "1|2|divide|3|divide,(1 / 2) / 3",
        "1|2|divide|3|mod,(1 / 2) % 3",
        "1|2|divide|3|power,(1 / 2) ^ 3",

        "1|2|mod|3|add,(1 % 2) + 3",
        "1|2|mod|3|subtract,(1 % 2) - 3",
        "1|2|mod|3|multiply,(1 % 2) * 3",
        "1|2|mod|3|divide,(1 % 2) / 3",
        "1|2|mod|3|mod,(1 % 2) % 3",
        "1|2|mod|3|power,(1 % 2) ^ 3",

        "1|2|power|3|add,1 ^ 2 + 3",
        "1|2|power|3|subtract,1 ^ 2 - 3",
        "1|2|power|3|multiply,1 ^ 2 * 3",
        "1|2|power|3|divide,1 ^ 2 / 3",
        "1|2|power|3|mod,1 ^ 2 % 3",
        "1|2|power|3|power,(1 ^ 2) ^ 3",
        })
    @SuppressWarnings("static-method")
    void check(final String program,
               final String expectedDescription) {
        final List<String> expression = Arrays.asList(program.split("\\|"));
        final Parser parser = Calculator.buildParser(new CommandLineParser(new String[0]));
        final Operand o = parser.parse(expression);
        assertEquals(expectedDescription, o.getDescription());
    }
}
