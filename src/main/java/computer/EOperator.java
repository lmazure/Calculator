package computer;

public class EOperator extends ConstantOperator {

    public EOperator() {
        super(Math.E, "e", "e");
    }

    public static String getHelp() {
        return "Push on the stack the value of e (2.7182818284590452353602874713526624977572470936999595749669676277240766303535475945713821785251664274274663919320030599218174135966290435729003342952605956307381323286279434907632338298807531…)";
    }
}
