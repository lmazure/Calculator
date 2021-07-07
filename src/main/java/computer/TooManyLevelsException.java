package computer;

@SuppressWarnings("serial")
public class TooManyLevelsException extends RuntimeException {

    public TooManyLevelsException(final String message) {
        super(message);
    }
}
